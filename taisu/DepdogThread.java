/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taisu;

import static taisu.Taisu.BIB_DEPDOG;


/**
 *
 * @author akulov_ev
 */
public class DepdogThread implements Runnable {
    public DepdogThread() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        new bib_depdog().to_file(BIB_DEPDOG);
    }


}
