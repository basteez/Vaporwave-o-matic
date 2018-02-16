package com.basteez.vaporwave;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        //File labelImg = new File("assets/bustmac.gif");
        URL url = getClass().getClassLoader().getResource("com/basteez/vaporwave/assets/bustmac.gif");
        File labelImg = new File(url.getPath());
        //System.out.println(url.getPath());
        ImageIcon statueIcon = new ImageIcon(labelImg.getPath());
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
                    //File macplus = new File("assets/macplus.mp3");
                    URL url = getClass().getClassLoader().getResource("com/basteez/vaporwave/assets/macplus.mp3");
                    System.out.println(url.getPath());
                    File macplus = new File(url.getPath());
                    try {
                        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(macplus));
                        Player player = new Player(bis);
                        player.play();
                    } catch (FileNotFoundException exc) {
                        exc.printStackTrace();
                    } catch (JavaLayerException exc) {
                        exc.printStackTrace();
                    }
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
