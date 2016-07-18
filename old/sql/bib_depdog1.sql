/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  akulov_ev
 * Created: 20.06.2016
*/

SELECT 
    CASE SUBSTR(A9.C_CODE,1,6)
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
        ELSE A9.C_CODE
    END DEPART_CODE,                                                                    /* подразделение */
    CASE SUBSTR(A9.C_CODE,1,6)
        WHEN '000' THEN 'ГО Иркутск'      
        WHEN '000-00' THEN 'ГО Иркутск'   
        WHEN '000-01' THEN 'ДО №1 Шелехов'
        WHEN '000-02' THEN 'ДО №2 Бодайбо'
        WHEN '000-03' THEN 'ДО №3 Ангарск'
        WHEN '000-04' THEN 'ГО УРБ       ' 
        WHEN '000-05' THEN 'ДО №5 ОСП Москва'
        WHEN '000-06' THEN 'ДО №6 ККО Москва' 
        WHEN '000-07' THEN 'ДО №7 ОСП Магадан'
        WHEN '003' THEN 'Филиал Москва'      
        WHEN '003-00' THEN 'Филиал Москва'   
        ELSE A9.C_CODE
    END DEPART,                                                                         /* подразделение */
    SUBSTR(A4.C_MAIN_V_ID,1,5) KONTO,                                                   /* конто         */
    CASE A5.c_code_iso WHEN '643' THEN '810' ELSE A5.c_code_iso END iso,                /* код валюты    */
    A4.C_MAIN_V_ID ACCA,                                                                /* номер счета   */
    A6.C_NAME VID_DEPOSIT,                                                              /* вид депозита  */
    A1.C_NUM_DOG_EXT NUM_DOG,                                                           /* номер договора*/
    IBS.Z$DEPN_LIB_01.GET(A1.ID,'PRC_RATE') STAVKA,                                     /* пр. ставка   */
    TO_CHAR(TO_DATE(A2.C_DATE_BEGIN),'YYYY-MM-DD') DATE_BEGIN,                          /* дата открытия */
    NVL(TO_CHAR(TO_DATE(A2.C_DATE_ENDING),'YYYY-MM-DD'),'    -  -  ') DATE_ENDING,
    ibs.Z$AC_FIN_ACC_TURN_LS.TURN(A4.C_ARC_MOVE,'ВВ', SYSDATE, SYSDATE - 1) VAL,        /* входящий остаток вал сч */
    ibs.Z$AC_FIN_ACC_TURN_LS.TURN(A4.C_ARC_MOVE,'ВН', SYSDATE, SYSDATE - 1) RUB,        /* входящий остаток рубли  */
    --A4.C_SALDO SALDO, A1.C_SUMMA_DOG SUMMA_DOG,
    NVL(TO_CHAR(TO_DATE(A2.C_DATE_CLOSE),'YYYY-MM-DD'),'    -  -  ') DATE_CLOSE,        /* дата закрытия    ???       */
    NVL(TO_CHAR(ROUND(A2.C_DATE_ENDING - SYSDATE,0)),'     ') SUBDATE,                  /* количество дней до окончания */
    A3.ID ID,                                                                           /* номер клиента */
    NVL(TO_CHAR(TO_DATE((SELECT max(b1.C_PREV_DATE_BEGIN) C_PREV_DATE_BEGIN
        from ibs.Z#PROL_CONTRACT b1 
        where (b1.COLLECTION_ID = A1.C_LIST_PROL and 
        b1.CLASS_ID = 'PROL_CONTRACT'))),'YYYY-MM-DD'),'    -  -  ') C_PREV_DATE_BEGIN, /* дата ввода условий до последней пролонгации */
    NVL(TO_CHAR(TO_DATE(A2.C_DATE_CLOSE),'YYYY-MM-DD'),'    -  -  ') DATE_CLOSE,        /* дата реального закрытия договора ???        */
    NVL((SELECT max(b1.c_num_prol) num_prol
            from ibs.Z#PROL_CONTRACT b1 
            where (b1.COLLECTION_ID = A1.C_LIST_PROL and 
            b1.CLASS_ID = 'PROL_CONTRACT')),'0') NUM_PROL,                               /* номер пролонгации */
    A6.ID,                                                                               /* код типового договора */
    NVL(TO_CHAR(A2.C_DATE_ENDING - A2.C_DATE_BEGIN),'       ') PERIOD_,                  /* общий срок договора */
    NVL(TO_CHAR(A2.C_DATE_ENDING - A2.C_DATE_BEGIN),'       ') PERIOD1                   /* первоначальный срок договора */
FROM IBS.Z#DEPN A1,
    IBS.Z#PRODUCT A2,
    IBS.Z#DEPART A9, 
    IBS.Z#VID_DEPOSIT A6, 
    IBS.Z#FT_MONEY A5, 
    IBS.Z#AC_FIN A4, 
    IBS.Z#CLIENT A3,
    IBS.Z#PRC_SCHEME A10
WHERE A1.ID=A2.ID AND 
    A1.C_CLIENT=A3.ID(+)  AND 
    A1.C_ACCOUNT=A4.ID(+) AND 
    A1.C_FINTOOL=A5.ID(+) AND 
    A1.C_VID_DOG=A6.ID(+) AND 
    A2.C_DEPART=A9.ID(+)  AND 
    A1.C_PRC_DOG=A10.ID(+) AND 
    A1.CLASS_ID = 'DEPOSIT_PRIV' AND 
    A2.C_DATE_CLOSE IS NULL AND
    A2.C_DATE_BEGIN < SYSDATE AND
    A1.C_NUM_DOG_EXT = '1350051106/46083' and
    --A4.C_MAIN_V_ID = '42305978900000017143'
    (SUBSTR(A4.C_MAIN_V_ID,1,5) = 42102 OR 
        SUBSTR(A4.C_MAIN_V_ID,1,5) = 42103 OR 
        SUBSTR(A4.C_MAIN_V_ID,1,5) = 42104 OR 
        SUBSTR(A4.C_MAIN_V_ID,1,5) = 42105 OR 
        SUBSTR(A4.C_MAIN_V_ID,1,5) = 42205 OR 
        SUBSTR(A4.C_MAIN_V_ID,1,5) = 42206 OR 

        SUBSTR(A4.C_MAIN_V_ID,1,5) = 42304 OR 
        SUBSTR(A4.C_MAIN_V_ID,1,5) = 42305 OR 
        SUBSTR(A4.C_MAIN_V_ID,1,5) = 42306 OR 
        SUBSTR(A4.C_MAIN_V_ID,1,5) = 42307 OR 
        SUBSTR(A4.C_MAIN_V_ID,1,5) = 42601 OR 
        SUBSTR(A4.C_MAIN_V_ID,1,5) = 42605 OR 

        SUBSTR(A4.C_MAIN_V_ID,1,5) = 40817 OR 
        SUBSTR(A4.C_MAIN_V_ID,1,5) = 40820) 
ORDER BY A4.C_MAIN_V_ID