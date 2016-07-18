/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  akulov_ev
 * Created: 21.06.2016
    BKL_PR_CRED_ACCS 
 */
SELECT 
    TRIM(A1_3.C_NUM_DOG) NUM_DOG,     /* номер договора */
    TRIM(A1_2.C_CLIENT) ID,           /* номер клиента  */
    CASE A2_1.c_code_iso WHEN '643' THEN '810' ELSE A2_1.c_code_iso END iso, /* код валюты */
    NVL(CASE A10_1.C_CODE 
        WHEN '09' THEN 'Автокред' 
        WHEN '20' THEN 'Автокред' 
        WHEN '21' THEN 'Автокред' 
        WHEN '22' THEN 'Автокред' 
        WHEN '23' THEN 'Автокред' 
        WHEN '24' THEN 'Автокред' 

        WHEN '08' THEN 
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЛинЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредЛинФЛ'
            END    
        WHEN '11' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЛинЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредЛинФЛ'
            END    
        WHEN '28' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЛинЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредЛинФЛ'
            END    
        WHEN '29' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЛинЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредЛинФЛ'
            END    
        WHEN '29_1' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЛинЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредЛинФЛ'
            END    
        WHEN '29_2' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЛинЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредЛинФЛ'
            END    
        WHEN '29_3' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЛинЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредЛинФЛ'
            END    
        WHEN '29_4' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЛинЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредЛинФЛ'
            END    
        WHEN '59' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЛинЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредЛинФЛ'
            END    
        WHEN '69' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЛинЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредЛинФЛ'
            END    
        WHEN '88' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЛинЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредЛинФЛ'
            END    
        WHEN '88_1' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЛинЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредЛинФЛ'
            END    
        WHEN '88_2' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЛинЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредЛинФЛ'
            END    
        WHEN '88_3' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЛинЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредЛинФЛ'
            END    
        WHEN '89' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЛинЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредЛинФЛ'
            END    
        WHEN '99' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЛинЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредЛинФЛ'
            END    
        WHEN '99_1' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЛинЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредЛинФЛ'
            END    
        WHEN '99_2' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЛинЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредЛинФЛ'
            END    
        WHEN '99_3' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЛинЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредЛинФЛ'
            END    
        WHEN '99_4' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЛинЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредЛинФЛ'
            END    


        WHEN '05' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредФизЛиц'
            END    
        WHEN '18' THEN 
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредФизЛиц'
            END    
        WHEN '19' THEN 
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредФизЛиц'
            END    
        WHEN '19_1' THEN 
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредФизЛиц'
            END    
        WHEN '19_2' THEN 
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредФизЛиц'
            END    
        WHEN '40' THEN 
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредФизЛиц'
            END    
        WHEN '79' THEN 
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредФизЛиц'
            END    
        WHEN '81' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредФизЛиц'
            END    
        WHEN '83' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредФизЛиц'
            END    
        WHEN '85' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредФизЛиц'
            END    
        WHEN '87' THEN
            CASE NVL(TRIM(A3_11.ID),'NOT')
                WHEN 'NOT' THEN 'КредЮрЛиц'
                WHEN TRIM(A3_11.ID) THEN 'КредФизЛиц'
            END    

        WHEN '38' THEN 'Овердрафт'
        WHEN '39' THEN 'Овердрафт'
        WHEN '49' THEN 'Овердрафт'
        ELSE A10_1.C_CODE
    END,' ') TYPE_CRED,                                  /* тип кредита */ 
    'Овердрафт КредЛинЮрЛиц' KRED_LINE,                  /* Получаем признак кредитной линии */
    NVL(TO_CHAR(TO_DATE(A1_3.C_DATE_BEGIN),'YYYY-MM-DD'),' ') DATE_BEGIN, /* дата начала договора */
    '    -  -  ' DATE_,
    NVL(TO_CHAR(TO_DATE(A1_3.C_DATE_ENDING),'YYYY-MM-DD'),' ') DATE_ENDING,
    IBS.Z$CRED_INTERFACE_PRX_P12006128.GETPRCRATE(A7_1.C_PRC_SCHEME,SYS_CONTEXT('IBS_USER', 'SYS_DATE')) STAVKA, 
    IBS.Z$CRED_INTERFACE_PRX_P12006128.GETPRCRATE(A8_1.C_PRC_SCHEME,SYS_CONTEXT('IBS_USER', 'SYS_DATE')) PR_STAVKA, 
    NVL(PORTFEL.C_PORT_NAME,' ') PORTFEL,                /* портфель */ 
    NVL(RISK.C_GROUP_NUM,0) GROUP_RISK,                  /* Группа риска ПОС */
    NVL(RISK.C_PRC_RESERV,0.00) PROC_REZ,                /* Процент резерва ПОС*/
    A4_1.C_MAIN_V_ID ACOUNT,                             /* счет договора ВСЕ СЧЕТА !!! */
    A1_2.C_DEBT_SUM SALDO,                               /* сальдо A4_1.C_SALDO */
    Z$PR_CRED_Z57604593.getAcc(A1_1.ID, 'ACCOUNT') ACCOUNT, 
    Z$PR_CRED_Z57604593.getAcc(A1_1.ID, 'ACCOUNT', 1) ACCOUNT1, 
    TRIM(A14.C_MAIN_V_ID) ACC_PROS,                      /* 45815 Счет просроченной задолженности по кредиту */
    A1_2.c_debt_pr_sum, /* A1_2.c_ext_sum */
NVL(NULL,'отсутствует') limit_,                          /* 91316 */ 
'0.00' limit_sum,
NVL(NULL,'отсутствует') free_limit_,                     /* 91317 */
'0.00' free_limit_sum,
NVL(TRIM(A14_4.C_MAIN_V_ID),'отсутствует') ACC_47427,    /* 47427 Счет Начисленные %% */
'0.00' ,                                                 /* Начисленные %% */
NVL(NULL,'отсутствует') ,                                /* 91604 Счет Начисленные %% ВБС */
'0.00' ,                                                 /* Начисленные %% ВБС */
TRIM(A14_1.C_MAIN_V_ID) ACC_PROS_PR,                     /* 45915 Счет Просроч. %% БС */
TRIM(A14_5.C_MAIN_V_ID) ACC_TEST,
/*остатки я могу вытащить по счетам*/
'0.00',                                                  /* Просроч. %% БС */
NVL(NULL,'отсутствует'),                                 /* 91604 Счет Просроч. %% ВБС */
'0.00',                                                  /* Просроч. %% ВБС */
NVL(TRIM(A14_2.C_MAIN_V_ID),'отсутствует') ACC_SR_REZ,   /* 45515 Резерв по срочной задолженности*/
A1_2.C_DEBT_SUM * 0.1 / 100,                             /* Расчетный резерв по СЗ = текущ задолж * проц резерва это если пос, иначе Резерв по срочной задол  */
NVL(TRIM(A14_3.C_MAIN_V_ID),'отсутствует') ACC_PROS_REZ, /* 45818 Резерв по просроч. задолженности */
'0.00',                                                  /* лимит задолженности по кредитной линии * процент/100  не пос Резерв по просроч. задолженности*/
NVL(NULL,'отсутствует'),                                 /* 47425 Резерв по внебалансовым инструментам */
'0.00',                                                  /* ПОС Расчетный резерв по по внебалансовым инструментам, иначе Резерв по внебалансовым инструментам */
NVL(NULL,'отсутствует'),                                 /* 47425 Резерв по начисленным %% */
'0.00',                                                  /* Резерв по начисленным %% */
NVL(NULL,'отсутствует'),                                 /* 45918 Резерв по просроченным %% */
'0.00',                                                  /* Резерв по просроченным %% */
TO_CHAR(TO_DATE(SYSDATE),'DD.MM.YYYY') DATE_             /* дата формирования */
/*A1_2.C_FT_CREDIT REF6, A1_2.C_ACCOUNT REF4,A5_1.C_NAME C_18, A1_2.C_KIND_CREDIT REF18*/
FROM IBS.Z#PRODUCT A1_3,
    IBS.Z#PR_CRED A1_2,
    IBS.Z#KIND_CREDITS A10_1,
    IBS.Z#KRED_PERS A1_1,
    IBS.Z#FT_MONEY A2_1,
    IBS.Z#KIND_CREDITS A5_1,
    IBS.Z#PRC_SCHEME A9_1,
    IBS.Z#DEBT_COMISS_PRC A7_1,
    IBS.Z#DEBT_COMISS_PRC A8_1,
    IBS.Z#AC_FIN A4_1,
    IBS.Z#CLIENT A3_1,
    IBS.Z#COM_STATUS_PRD A6_1,
    ibs.Z#CL_PRIV A3_11,
    IBS.Z#AC_FIN A14,
    IBS.Z#AC_FIN A14_1,
    IBS.Z#AC_FIN A14_2,
    IBS.Z#AC_FIN A14_3,
    IBS.Z#AC_FIN A14_4,
    IBS.Z#AC_FIN A14_5,
    (SELECT DISTINCT   /* таблица договоров с риском, по идее надо через history  но и так ок */
        A1_1.C_PROD ID_NUM_DOG,             /* id договора */
        A2_1.C_GROUP_NUM C_GROUP_NUM,       /* группа риска */
        A3_1.C_GROUP_NUM C_GROUP_NUM_CALC,  /* расчетная группа */
        A1_1.C_PRC_RESERV C_PRC_RESERV      /* проц. резервирования */
    FROM IBS.Z#CR_RISK_GR A1_1,
        IBS.Z#CRED_RISK A2_1,  
        IBS.Z#CRED_RISK A3_1
    WHERE 
        A1_1.C_RISK_GROUP = A2_1.ID(+)
        AND A1_1.C_CALC_RISK_GROUP = A3_1.ID(+)
        AND A1_1.id = (select max(gr.id) from ibs.Z#CR_RISK_GR gr where gr.c_prod = A1_1.C_PROD)
    ) RISK,
    (SELECT                        /* таблица договоров с портфелями */
        a1.C_PR_CRED ID_DOG,               /* id договора */
        e1.C_PORT_NAME C_PORT_NAME         /* портфель */
    FROM IBS.Z#SIM_LOAN_PORT e1, 
        IBS.Z#CRED_IN_PORT a1 
    WHERE e1.C_CREDITS = a1.COLLECTION_ID
    ) PORTFEL


WHERE A1_1.ID = A1_3.ID
    AND A1_1.ID = A1_2.ID
    AND A1_2.C_FT_CREDIT = A2_1.ID(+)
    AND A1_2.C_KIND_CREDIT = A5_1.ID(+)
    AND A7_1.C_PRC_SCHEME = A9_1.ID(+)
    AND A1_2.C_ACCOUNT = A4_1.ID(+)
    AND A1_2.C_CLIENT = A3_1.ID(+)
    AND A1_3.C_COM_STATUS = A6_1.ID(+)
    AND A1_2.C_KIND_CREDIT = A10_1.ID(+)
    AND A3_1.ID = A3_11.ID(+)
    AND ((A7_1.COLLECTION_ID (+) = A1_2.C_COMISS_ARR and A7_1.C_DEBT (+) = 1984123) /* срочн */
    and (A8_1.COLLECTION_ID (+) = A1_2.C_COMISS_ARR and A8_1.C_DEBT (+) = 1984141) --10015581)  /* просроч */
    and A1_2.CLASS_ID = 'KRED_PERS')
    AND A1_3.ID = RISK.ID_NUM_DOG(+)
    AND A1_3.ID = PORTFEL.ID_DOG(+)
    AND A1_2.c_acc_debts_cr = A14.id(+)
    AND A1_2.c_acc_debts_prc = A14_1.id(+)
    AND A1_2.C_ACC_RESERV = A14_2.id(+)
    AND A1_2.C_ACC_RESERV_DEBTS = A14_3.id(+)
    AND A1_2.C_ACC_DEMAND_PRC = A14_4.id(+)
    AND A1_2.C_ACC_SETTLEMENT = A14_5.id(+)

    and A1_3.C_NUM_DOG = '0029-8009' 
--phd:if frame = 4 and i1 = 649 then no-apply
--phd:// Определим условие, 30 дней до окончания договора
--phd:if i#10 > 0 & i#10 <= 30 then if d#10 < текущая задолженность then d#10 = текущая задолженность;
--phd:// Для овердрафта всю сумму задолженности выводим в ожидаемые
--phd:if Тип кредита = "639" then d#10 = текущая задолженность;
--phd:if Тип кредита = "638" then d#10 = текущая задолженность;


