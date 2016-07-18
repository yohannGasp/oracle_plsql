/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taisu;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.util.Formatter;
import java.util.Locale;

/**
 *
 * @author akulov_ev
 */
public class bib_kreddog implements CFT_Interface{

    @Override
    public void to_file(String fileName) {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), "Cp866");) {
            ResultSet rs = Taisu.db.ExecProc(Taisu.db.SELECT_KREDDOG_SQL);
            while (rs.next()) {
                String str;
                try (Formatter fmt = new Formatter(Locale.ENGLISH)) {
                    str = fmt.format("%s\t" /* 1. номер договора */
                            + "%s\t"        /* 2. номер клиента банкир */
                            + "%s\t"        /* 3. номер клиента  */
                            + "%3s\t"       /* 4. код валюты     */
                            + "%s\t"        /* 5. тип кредита    */
                            + "%s\t"        /* 6. Получаем признак возобновляемой кредитной линии */
                            + "%s\t"        /* 7. дата начала договора */
                            + "%s\t"        /* 8. дата прекращения обязательств по кредитной линии */
                            + "%s\t"        /* 9. дата окончания договора */
                            + "%.2f\t"      /* 10. процентная ставка по счету срочной задолженности */
                            + "%.2f\t"      /* 11. процентная ставка по счету просроч. задолженности */
                            + "%s\t"        /* 12. пос */
                            + "%.0f\t"      /* 13. Группа риска ПОС */
                            + "%.2f\t"      /* 14. Процент резерва ПОС */
                            + "%s\t"        /* 15. Все счета СЗ по договору */
                            + "%.2f\t"      /* 16. текущая задолженность */
                            + "%s\t"        /* 17. Счет просроченной задолженности */
                            + "%.2f\t"      /* 18. просроченная задолженность по капиталу */
                            + "%s\t"        /* 19. Лимит кредитной линии */
                            + "%.2f\t"      /* 20. Лимит кредитной линии сумма */
                            + "%s\t"        /* 21. Свободн. кредит. линии */
                            + "%.2f\t"      /* 22. Свободн. кредит. линии  сумма */
                            + "%s\t"        /* 23. Счет Начисленные %% баланс */
                            + "%.2f\t"      /* 24. Начисленные %%  баланс */
                            + "%s\t"        /* 25. Счет Начисленные %% ВБС */
                            + "%.2f\t"      /* 26. Начисленные %% ВБС */
                            + "%s\t"        /* 27. Счет Просроч. %% БС */
                            + "%.2f\t"      /* 28. Просроч. %% БС */
                            + "%s\t"        /* 29. Счет Просроч. %% ВБС */
                            + "%.2f\t"      /* 30. Просроч. %% ВБС */
                            + "%s\t"        /* 31. Резерв по срочной задолженности */
                            + "%.2f\t"      /* 32. Расчетный резерв по СЗ ПОС или не пос Резерв по срочной задолженности */
                            + "%s\t"        /* 33. Резерв по просроч. задолженности */
                            + "%.2f\t"      /* 34. лимит задолженности по кредитной линии * процент/100  не пос Резерв по просроч. задолженности*/
                            + "%s\t"        /* 35. Резерв по внебалансовым инструментам */
                            + "%.2f\t"      /* 36. ПОС Расчетный резерв по по внебалансовым инструментам, иначе Резерв по внебалансовым инструментам */
                            + "%s\t"        /* 37. Резерв по начисленным %% */
                            + "%.2f\t"      /* 38. Резерв по начисленным %% */
                            + "%s\t"        /* 39. Резерв по просроченным %% */
                            + "%.2f\t"      /* 40. Резерв по просроченным %% */
                            + "%s"          /* 41. дата отчета */
                            + "%n",
                            rs.getString(1),rs.getString(2).trim(),rs.getString(3),rs.getString(4),rs.getString(5),
                            rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getFloat(10),
                            rs.getFloat(11),rs.getString(12),rs.getFloat(13),rs.getFloat(14),rs.getString(15),
                            rs.getFloat(16),rs.getString(17),rs.getFloat(18),rs.getString(19),rs.getFloat(20),
                            rs.getString(21),rs.getFloat(22),rs.getString(23),rs.getFloat(24),rs.getString(25),
                            rs.getFloat(26),rs.getString(27),rs.getFloat(28),rs.getString(29),rs.getFloat(30),
                            rs.getString(31),rs.getFloat(32),rs.getString(33),rs.getFloat(34),rs.getString(35),
                            rs.getFloat(36),rs.getString(37),rs.getFloat(38),rs.getString(39),rs.getFloat(40),rs.getString(41)).toString();
                }
                writer.write(str);
            }
            System.out.println("5. kreddog");
            writer.flush();
        } catch (java.sql.SQLException | IOException ex) {
            System.out.println(ex);
        }

    }

}
