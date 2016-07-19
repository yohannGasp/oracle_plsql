/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taisu;

import static taisu.Taisu.BIB_SUBCONTO;

/**
 *
 * @author akulov_ev
 */
public class SubcontoThread implements Runnable {

    public SubcontoThread() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        new bib_subconto().to_file(BIB_SUBCONTO);
    }

}
