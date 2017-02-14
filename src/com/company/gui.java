package com.company;

import javafx.stage.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by simon blank on 2017-01-21.
 */
public class gui {

    websiteList web= new websiteList();
    JFrame frame = new JFrame();
    JFrame addFrame = new JFrame();
    JFrame removeFrame = new JFrame();
    JPanel panel = new JPanel();
    JPanel addPanel = new JPanel();
    JPanel removePanel = new JPanel();
    JTextArea urlInput = new JTextArea();
    JTextArea nameInput = new JTextArea();
    JComboBox box = new JComboBox();
    int  buttonNumber=0  ;




    public gui() {}

    public void loadGui(){
        panelProperties();
        addButton();
        removeButton();
        addwebbButtons();
        removeframe();


        frameProperties();

    }

    public void panelProperties (){

        panel.setBackground(Color.gray);
        frame.getContentPane().add(panel);

    }

    private void frameProperties(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void addButton(){
        JButton button = new JButton("addWebSite");
        button.setPreferredSize(new Dimension(150,40));


        addFrameProperties();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            addFrame.setVisible(true);


            }
        });
        panel.add(button);
    }

    public void button(){
        int websiteNumber=buttonNumber;
        String webbUrl = web.getNextWebsite(websiteNumber);
        JButton button = new JButton(web.getNextWebsiteTittle(websiteNumber));
        button.setPreferredSize(new Dimension(150,50));


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Desktop.isDesktopSupported())
                {
                    try {
                        Desktop.getDesktop().browse(new URI(webbUrl));


                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (URISyntaxException e1) {
                        e1.printStackTrace();
                    }
                }

            }
        });


        panel.add(button);
        buttonNumber++;


    }

    public void addwebbButtons(){
        while(buttonNumber<web.getWebsiteAmount()){
            button();
        }
    }

    public void removeButton(){
        JButton button = new JButton("remove");
        button.setPreferredSize(new Dimension(150,40));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeFrame.setVisible(true);


            }
        });

        panel.add(button);

    }




    public void removeframe(){
        removeFrame.setSize(new Dimension(300,200));
        removeFrame.getContentPane().add(removePanel);
        removeframeCombobox();
        removeframeRemoveButton();

    }

    public void removeframeRemoveButton(){
        JButton button= new JButton("remove");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                web.removeFromList(box.getSelectedIndex());
                panel.remove(box.getSelectedIndex()+2);
                box.removeItemAt(box.getSelectedIndex());
                printOutWhatsLeftInWebsiteList();

                buttonNumber--;


                buttonRefresh();
                removeFrame.setVisible(false);



            }
        });

        removePanel.add(button);

    }

    public void removeframeCombobox(){
        for(int l=0;l<web.getWebsiteAmount();l++) {
            box.addItem(web.getNextWebsiteTittle(l));
        }
        removePanel.add(box);
    }




    public void addFrameProperties(){

        addFrame.setSize(new Dimension(300,200));
        addFrame.getContentPane().add(addPanel);

        JLabel label1 = new JLabel("enter URL");
        addPanel.add(label1);
        urlArea();
        JLabel label2 = new JLabel("enter display name");
        addPanel.add(label2);
        nameArea();
        addFrameAddButton();
        addFrameExitButton();

    }

    public void addFrameAddButton(){
        JButton addButton = new JButton("add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(urlInput.getText() != ""&& nameInput.getText()!= ""){
                web.addToList(urlInput.getText(),nameInput.getText());
                box.addItem(nameInput.getText());
                buttonRefresh();}
                urlInput.setText("www.");
                nameInput.setText("");
                addFrame.setVisible(false);

            }
        });

        addPanel.add(addButton);
    }

    public void addFrameExitButton(){
        JButton exitButton = new JButton("exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFrame.setVisible(false);


            }
        });

        addPanel.add(exitButton);
    }

    public void urlArea(){

        urlInput.setPreferredSize(new Dimension(250,25));
        urlInput.setText("www.");
        addPanel.add(urlInput);
    }

    public void nameArea(){
        nameInput.setPreferredSize(new Dimension(250,25));

        addPanel.add(nameInput);
    }

    public void buttonRefresh() {
            addwebbButtons();
            frame.setVisible(false);
            frame.setVisible(true);

    }






    public void printOutWhatsLeftInWebsiteList(){
        for(int i=0 ;i<web.getWebsiteAmount();i++)
        {
            System.out.println(web.getNextWebsiteTittle(i)+ " "+ web.getNextWebsite(i));

        }

    }

}
