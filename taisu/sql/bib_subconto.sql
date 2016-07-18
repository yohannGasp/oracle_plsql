/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  akulov_ev
 * Created: 15.06.2016
 */

SELECT TRIM(A1_1.C_NUM) C_1,'0' C_2, TRIM(A1_1.C_NAME) C_3 
FROM ibs.Z#PL_US A1_1
WHERE A1_1.C_VID_P = '2036152' /* Новый план счетов ЦБ Росcии */
ORDER BY A1_1.C_NUM