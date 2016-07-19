/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taisu;

import static taisu.Taisu.BIB_KREDPOS;

/**
 *
 * @author akulov_ev
 */
public class KredPosThread implements Runnable {
    public KredPosThread() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        new bib_kredpos().to_file(BIB_KREDPOS);
    }


}
