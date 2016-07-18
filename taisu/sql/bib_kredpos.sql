/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  akulov_ev
 * Created: 24.06.2016
 */

SELECT PT.ID,                                      /* код */
  PT.C_PORT_NAME,                                  /* наименование портфеля */
  A2_1.C_GROUP_NUM C_GROUP_NUM,                    /* группа риска */
  A1_1.C_PRC_RESERV C_PRC_RESERV,                  /* проц. резервирования */
  NVL('45515810100000000847',' ') AccRezervOD,     /* 45515 */
  NVL(NULL,'0.00') RezervOD,                       /* sum 45515 */
  NVL('45818810100000000117',' ') AccRezervOverOD, /* 45818*/
  NVL(NULL,'0.00') RezervOverOD,                   /* sum 45818 */
  NVL('47425810000000000475',' ') AccRezervVB,     /* 47425 */
  NVL(NULL,'0.00') RezervVB,                       /* sum 47425 */
  NVL('47425810900000000562',' ') AccRezervNP,     /* 47425 */
  NVL(NULL,'0.00') RezervNP,                       /* sum 47425 */
  NVL('45918810200000000001',' ') AccRezervPP,     /* 45918 */
  NVL(NULL,'0.00') RezervPP                        /* sum 45918 */
FROM IBS.Z#SIM_LOAN_PORT PT, 
  IBS.Z#CR_RISK_GR A1_1,
  IBS.Z#CRED_RISK A2_1
WHERE PT.c_gr_risk_hist = A1_1.collection_id(+)
  AND A1_1.C_RISK_GROUP = A2_1.ID(+)