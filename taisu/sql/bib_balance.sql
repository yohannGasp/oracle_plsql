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
    TRIM(c1.C_MAIN_V_ID) STG_Account_ID,  /* ID счета */
    TO_CHAR(TO_DATE(?),'YYYY-MM-DD') date_,
    ROUND(ABS(ibs.Z$AC_FIN_ACC_TURN_LS.TURN(c1.C_ARC_MOVE,'ИВ',?,?)),2) val, -- получаем остаток на дату
    ROUND(ABS(ibs.Z$AC_FIN_ACC_TURN_LS.TURN(c1.C_ARC_MOVE,'ИН',?,?)),2) rub,
    SUBSTR(A17_1.C_CODE,1,6)
FROM ibs.Z#AC_FIN c1, Z#DEPART A17_1
WHERE 
    (c1.C_DATE_CLOSE is null OR c1.C_DATE_CLOSE >= TO_DATE(?,'DD.MM.YYYY')) /* закрытые с начала периода */
    --and c1.C_MAIN_V_ID = '99998810700000000001'
    AND c1.C_DEPART = A17_1.ID(+)
    order by c1.C_MAIN_V_ID


 