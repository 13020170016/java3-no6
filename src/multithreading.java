/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Herda
 */
public class multithreading implements Runnable{
    public static int countwriter = 0;
    public static int countreader = 0;
    //
    public static final int READER = 0;
    public static final int WRITER = 1;
    //
    private int type;
    private int id;
    private String strid;
 
    public multithreading(int type) {
        this.type = type;
        this.strid = (type == READER) ? ("Reader " + (this.id = ++countreader)) : ("Writer " + (this.id = ++countwriter));
    }
 
    public static void main(String[] argv) {
        (new Thread(new multithreading(READER))).start();
        (new Thread(new multithreading(READER))).start();
        (new Thread(new multithreading(WRITER))).start();
    }
 
    public void run() {
        if (type == READER) {
            read();
        } else if (type == WRITER) {
            write();
        }
    }
 
 
    public void read() {
        System.out.println(strid + ": start!");
        while (true) {
            System.out.println(strid + ": reading!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(multithreading.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void write() {
        System.out.println(strid + ": start!");
        while (true) {
            System.out.println(strid + ": writing!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(multithreading.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
