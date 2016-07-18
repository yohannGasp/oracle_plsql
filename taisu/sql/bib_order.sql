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
    A1_1.ID,                                               /* UNI    */
    TRIM(A1_1.C_NUM_DT) C_NUM_DT,                          /* дебет  */
    TRIM(A1_1.C_NUM_KT) C_NUM_KT,                          /* кредит */
    TRIM(A1_1.C_NUM_DT) DEB,                               /* дебет  */
    TRIM(A1_1.C_NUM_KT) KRED,                              /* кредит */
    TO_CHAR(A1_1.C_DATE_PROV,'YYYY-MM-DD') C_DATE_PROV,    /* дата проводки */
    ROUND(decode(A1_1.C_SUM, null, A1_1.C_SUM_PO, 0, A1_1.C_SUM_PO, A1_1.C_SUM),2) SUM_ACCA, /* сумма в валюте счета */ 
    ROUND(A1_1.C_SUM_NT,2),                                       /* Сумма в рублях */
    ROUND(decode(A1_1.C_SUM, null, A1_1.C_SUM_PO, 0, A1_1.C_SUM_PO, A1_1.C_SUM),2) SUM_ACCA, /* сумма в валюте счета */ 
    ROUND(A1_1.C_SUM_NT,2),                                       /* Сумма в рублях */
    REPLACE(REPLACE(TRIM(A1_1.C_NAZN),chr(10),' '),chr(13),' ') NAZN,      /* Назначение */
    NVL(NVL(BIB_TAISU_FIND_KREDDOG(A1_1.C_ACC_DT),BIB_TAISU_FIND_KREDDOG(A1_1.C_ACC_KT)),' ') KRED_DOG, /* Номер кредитного договора */
    NVL(NVL(BIB_TAISU_FIND_KIND_CR_FULL(BIB_TAISU_FIND_KIND_CREDIT(A1_1.C_ACC_DT),BIB_TAISU_NVL2(A3_11.ID)),BIB_TAISU_FIND_KIND_CR_FULL(BIB_TAISU_FIND_KIND_CREDIT(A1_1.C_ACC_KT),BIB_TAISU_NVL2(A3_11_2.ID))),' ') KRED_TYPE, /* Тип кредита */
    NVL(NVL(TRIM(A1_8.C_NUM_DOG_EXT),TRIM(A1_8_1.C_NUM_DOG_EXT)),' ') DEP_DOG /* Номер депозита */
FROM ibs.Z#MAIN_DOCUM A1_1,
    IBS.Z#DEPN A1_8,                                     /* депозиты */  
    IBS.Z#DEPN A1_8_1,
    (select ID,C_CLIENT_r COD_CL from Z#AC_FIN A1_1
     where not C_CLIENT_r is null
     union 
     select ID,C_CLIENT_V COD_CL from Z#AC_FIN A1_1
     where  C_CLIENT_r is null) klient,
    (select ID,C_CLIENT_r COD_CL from Z#AC_FIN A1_1
     where not C_CLIENT_r is null
     union 
     select ID,C_CLIENT_V COD_CL from Z#AC_FIN A1_1
     where  C_CLIENT_r is null) klient1,
    IBS.Z#CL_PRIV A3_11,
    IBS.Z#CL_PRIV A3_11_2
WHERE A1_1.C_ACC_DT = A1_8.C_ACCOUNT(+) AND
    A1_1.C_ACC_KT = A1_8_1.C_ACCOUNT(+) AND
    A1_1.C_ACC_DT = klient.ID(+) AND 
    A1_1.C_ACC_KT = klient1.ID(+) AND 
    klient.COD_CL = A3_11.ID(+) AND 
    klient1.COD_CL = A3_11_2.ID(+) AND 
    (A1_1.C_DATE_PROV >= TO_DATE(?,'DD-MM-YYYY HH24:MI:SS') AND A1_1.C_DATE_PROV <= TO_DATE(?,'DD-MM-YYYY HH24:MI:SS') AND UPPER(A1_1.STATE_ID) = 'PROV') 
ORDER BY A1_1.C_DATE_PROV