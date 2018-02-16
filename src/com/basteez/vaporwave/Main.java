package com.basteez.vaporwave;

import javax.swing.*;

public class Main {

    public static void main(String args[]){
       VaporwaveForm form = new VaporwaveForm();
       form.setResizable(false);
       form.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       form.setVisible(true);
    }
}
