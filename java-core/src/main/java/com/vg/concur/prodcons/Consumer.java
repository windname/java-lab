/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.concur.prodcons;

/**
 *
 * @author 1
 */
public class Consumer extends Thread {
    private Deposit deposit;

    public Consumer(Deposit deposit) {
        this.deposit = deposit;
    }
    
    public void run() {
    
    }
}
