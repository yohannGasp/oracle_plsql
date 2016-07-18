/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  akulov_ev
 * Created: 15.06.2016
 */

SELECT 
    TRIM(A1_1.C_MAIN_V_ID) STG_Account_ID,            /* ID счета */
    REPLACE(TRIM(A1_2.C_NAME),chr(9),chr(32)) C_NAME, /* наименование счета */
    TRIM(A1_1.C_MAIN_V_ID) C_1,                       /* номер счета */
    NVL(TO_CHAR(A1_2.C_DATE_OP,'YYYY-MM-DD'),' ') date_open, /* должна быть Николай сказал ! */
    NVL(TO_CHAR(A1_2.C_DATE_CLOSE,'YYYY-MM-DD'),' ') date_close,
    CASE A5_1.c_code_iso WHEN '643' THEN '810' ELSE A5_1.c_code_iso END iso, /* код валюты */
    NVL(NVL(A1_20.C_INTERNAL_CODE,A1_21.C_INTERNAL_CODE),' ') ID, /* номер клиента банкир */
    NVL(A1_1.C_CLIENT_R,A1_1.C_CLIENT_V) ID,          /* номер клиента */
    NVL(BIB_TAISU_FIND_KREDDOG(A1_1.ID),' ') KRED_DOG, /* кредиты */
    NVL(BIB_TAISU_FIND_KIND_CR_FULL(BIB_TAISU_FIND_KIND_CREDIT(A1_1.ID),BIB_TAISU_NVL2(A3_11.ID)),' ') TYPE_CRED,  /* тип кредита */ 
    NVL(TRIM(A1_8.C_NUM_DOG_EXT),' ') DEP_DOG,    /* депозит */
    CASE SUBSTR(A17_1.C_CODE,1,6)
        WHEN '000' THEN '0'       /* 0 №0 Головной офис г. Иркутск */
        WHEN '000-00' THEN '0'    /* 0 №0 Головной офис г. Иркутск */
        WHEN '000-01' THEN '1'    /* 1 №1  г. Шелехов */
        WHEN '000-02' THEN '2'    /* 2 №2  г. Бодайбо */
        WHEN '000-03' THEN '3'    /* 3 №3  г. Ангарск */
        WHEN '000-05' THEN '5'    /* 5 №5  ОСП г. Москва */
        WHEN '000-06' THEN '6'    /* 6 №6  ККО "Центральный" (г. Москва) */
        WHEN '000-07' THEN '7'    /* 7 №7  ОСП г. Магадан */
        WHEN '003' THEN '30'      /* 30 Филиал Москва */
        WHEN '003-00' THEN '30'   /* 30 Филиал Москва */
        ELSE A17_1.C_CODE
    END DEPART,                                   /* подразделение */
    '0' SUBCONTO                                  /* субконто  в ЦФТ нет субконто A11_1.C_NUM */

FROM Z#ACCOUNT A1_2,
    Z#AC_FIN A1_1,
    Z#CL_PRIV A3_11,         /* физики */
    Z#DEPART A17_1,
    Z#FT_MONEY A5_1,
    --ibs.Z#PL_USV A11_1,      /* убрать */
    Z#DEPN A1_8,             /* ДЕПОЗИТЫ */
    (select C_MAIN_V_ID,C_CLIENT_r COD_CL from Z#AC_FIN A1_1
     where not C_CLIENT_r is null
     union 
     select C_MAIN_V_ID,C_CLIENT_V COD_CL from Z#AC_FIN A1_1
     where  C_CLIENT_r is null) klient,
    Z#CLIENT A1_20,
    Z#CLIENT A1_21
WHERE A1_1.ID = A1_2.ID
    AND A1_1.C_MAIN_V_ID = klient.C_MAIN_V_ID(+)
    AND klient.COD_CL = A3_11.ID(+)
    AND A1_1.C_DEPART = A17_1.ID(+)
    AND A1_1.C_FINTOOL = A5_1.ID(+)
    --AND A1_1.C_MAIN_USV = A11_1.ID(+)
    AND A1_1.ID = A1_8.C_ACCOUNT(+)
    AND A1_1.C_CLIENT_R = A1_20.ID(+)
    AND A1_1.C_CLIENT_V = A1_21.ID(+)
    AND (A1_2.C_DATE_CLOSE IS NULL OR A1_2.C_DATE_CLOSE >= TO_DATE(?,'DD.MM.YYYY')) /* больше или равна началу периода */
--    AND A1_2.C_DATE_OP <= TO_DATE(?,'DD.MM.YYYY') /* дата открытия <= концу периода */  /* чтобы не попадали новые счета это условие хреново работает */
ORDER BY A1_1.C_MAIN_V_ID
 
 
 

