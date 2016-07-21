/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  akulov_ev
 * Created: 15.06.2016
 */

  /* физики */
SELECT NVL(A1_2.c_internal_code,' '), A1_2.ID, TRIM(A1_2.c_name) c_name, '0' as type_cl, NVL(a1_2.c_inn,' ') c_inn,
  TRIM(A1_2.c_name) c_name,
  NVL(TRIM(SUBSTR(c_name,1,INSTR(c_name,' '))),' ') FAMILY,
  NVL(TRIM(SUBSTR(c_name,INSTR(c_name,' ')+1,INSTR(c_name,' ',1, 2) - INSTR(c_name,' '))),' ') NAME_,  /* kosyak */
  NVL(TRIM(SUBSTR(c_name,INSTR(c_name,' ',1, 2)+1)),' ') LAST_NAME,
  CASE A1_1.C_SEX WHEN 2047935 THEN '0' WHEN 2047936 THEN '1' ELSE '0' END SEX, ' ' C_LONG_NAME 
  FROM ibs.Z#CLIENT A1_2,ibs.Z#CL_PRIV A1_1 WHERE A1_1.ID = A1_2.ID 
  AND NOT A1_2.c_name IS NULL

UNION ALL
  /* юрики */
SELECT NVL(A1_2.c_internal_code,' '), A1_2.ID, TRIM(A1_2.c_name) c_name, '1' as type_cl, NVL(a1_2.c_inn,' ') c_inn, 
  ' ' c_name,
  ' ' FAMILY,
  ' ' NAME_,
  ' ' LAST_NAME,
  ' ' SEX, NVL(A1_1.C_LONG_NAME,' ') C_LONG_NAME
  FROM ibs.Z#CLIENT A1_2,ibs.Z#CL_CORP A1_1 WHERE A1_1.ID = A1_2.ID
  AND NOT A1_2.c_name IS NULL
  AND (A1_2.class_id = 'CL_ORG' OR A1_2.class_id = 'CL_BANK_N' OR A1_2.class_id = 'CL_PART')
  AND (NOT A1_2.c_internal_code like 'GNI%' OR A1_2.c_internal_code IS NULL)
  

