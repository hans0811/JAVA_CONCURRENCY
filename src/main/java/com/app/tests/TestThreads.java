/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.tests;

import com.app.runnables.AppThread;

/**
 *
 * @author Ketkee Aryamane
 */
public class TestThreads {
    
    public static void main(String[] args) {
        AppThread thread1 = new AppThread();//NEW
        AppThread thread2 = new AppThread();
        AppThread thread3 = new AppThread();
        
        thread1.start();//RUNNABLE
        thread2.start();
        thread3.start();
        //execute run // RUNNING
        //job completed - TERMINATED/DEAD
        
        
    }
    
}
