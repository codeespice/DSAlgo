package com.g.ds.multithreading;

public class Runner extends Thread {
    public void run()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println(Thread.currentThread().getName() + "    Hello::"+i);
            try
            {
                Thread.sleep(100);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
