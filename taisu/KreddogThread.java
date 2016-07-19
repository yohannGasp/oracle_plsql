/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taisu;

import static taisu.Taisu.BIB_KREDDOG;

/**
 *
 * @author akulov_ev
 */
public class KreddogThread implements Runnable {
    public KreddogThread() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        new bib_kreddog().to_file(BIB_KREDDOG);
    }


}
