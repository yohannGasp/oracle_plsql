/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taisu;

import static taisu.Taisu.BIB_CLIENT;

/**
 *
 * @author akulov_ev
 */
public class ClientsThread implements Runnable {

    public ClientsThread() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        new bib_client().to_file(BIB_CLIENT);
    }

}
