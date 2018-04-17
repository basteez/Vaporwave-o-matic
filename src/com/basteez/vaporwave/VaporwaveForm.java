package com.basteez.vaporwave;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;

public class VaporwaveForm extends JFrame{
    private JLabel statueLbl;
    private JButton vaporwaveBtn;
    private JPanel panel1;
    private boolean isPlaying = false;

    public VaporwaveForm(){
        initComponents();

    }

    private void initComponents(){
        statueLbl = new JLabel();
        vaporwaveBtn = new JButton();

        //add components to the layout
        getContentPane().add(statueLbl, BorderLayout.CENTER);
        getContentPane().add(vaporwaveBtn, BorderLayout.SOUTH);

        getContentPane().setBackground(new Color(255,105,180));

        //set image for statueLbl
        ImageIcon statueIcon = new ImageIcon(getClass().getClassLoader().getResource("assets/bustmac.gif"));
        Image img = statueIcon.getImage();
        Image scaledImg = img.getScaledInstance(statueIcon.getIconWidth()/2, statueIcon.getIconHeight()/2, Image.SCALE_SMOOTH);
        statueLbl.setIcon(new ImageIcon(scaledImg));

        //set button
        vaporwaveBtn.setText("Ｖａｐｏｒｗａｖｅ　ト医佳");
        vaporwaveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isPlaying){
                    isPlaying = true;
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //File macplus = new File("assets/macplus.mp3");
                            InputStream is = getClass().getClassLoader().getResourceAsStream("assets/macplus.mp3");
                            //File macplus = new File(is);
                            try {
                                BufferedInputStream bis = new BufferedInputStream(is);
                                Player player = new Player(bis);
                                player.play();
                                isPlaying = false;
                            } catch (JavaLayerException exc) {
                                exc.printStackTrace();
                            }
                        }
                    });
                    t.start();
                    /*try {
                        t.wait();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }*/
                }
            }
        });
        pack();
    }

    // GETTERS AND SETTERS (not used so far)
    public JLabel getStatueLbl() {
        return statueLbl;
    }

    public void setStatueLbl(JLabel statueLbl) {
        this.statueLbl = statueLbl;
    }

    public JButton getVaporwaveBtn() {
        return vaporwaveBtn;
    }

    public void setVaporwaveBtn(JButton vaporwaveBtn) {
        this.vaporwaveBtn = vaporwaveBtn;
    }
}
