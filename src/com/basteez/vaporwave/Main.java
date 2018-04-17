package com.basteez.vaporwave;

import javax.swing.*;

public class Main {

    public static void main(String args[]){
        initLaF();
        VaporwaveForm form = new VaporwaveForm();
        form.setResizable(false);
        form.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        form.setVisible(true);
    }

    private static void initLaF()
    {
        UIManager.LookAndFeelInfo[] lafs = UIManager.getInstalledLookAndFeels();
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(UnsupportedLookAndFeelException e){e.printStackTrace();}
        catch(ClassNotFoundException e){e.printStackTrace();}
        catch(InstantiationException e){e.printStackTrace();}
        catch(IllegalAccessException e){e.printStackTrace();}
    }
}
