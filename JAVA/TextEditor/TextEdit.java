//packages
//package com.example.textedit;

import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileSystemView;

//action packages
import java.awt.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// input output stream packages
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//java util packages
import java.util.Scanner;
import java.util.logging.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * additional classes as needed
 * javax swing JFileChooser, JFrame, JMenu, JMenuBar, JMenuItem, JOptionPane,
 * JTextArea
 * swing UIManager, UnsupportedLookAndFeelException,filechooser.FileSytemView,
 * awt.event actionEvent, ActionListener
 * io.File, FileNotFoundException, FileReader, FileWriter, IOException,
 * logging level, Logger
 */

public final class TextEdit extends JFrame implements ActionListener {
    // main window is a single-window app, a jframe with action listener attached to
    // menu events
    // the window needs the window, an indicator for the return value, and text
    // editor.
    private static JTextArea area;
    private static JFrame frame;
    private static int returnValue = 0;

    public TextEdit() {
        run();
    }

    public void run() {
        frame = new JFrame("Text Edit");
        // set look-and-feel of the app
        // try to default to the host system preferances
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TextEdit.class.getName()).log(Level.SEVERE, null, ex);
        }

        // set attributes of the app window
        area = new JTextArea();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(area);
        frame.setSize(640, 480);
        frame.setVisible(true);

        // Build the menu
        JMenuBar menu_main = new JMenuBar();
        JMenu menu_file = new JMenu("FIle");
        JMenuItem menuitem_new = new JMenuItem("New");
        JMenuItem menuitem_open = new JMenuItem("Open");
        JMenuItem menuitem_save = new JMenuItem("Save");
        JMenuItem menuitem_quit = new JMenuItem("Quit");

        menuitem_new.addActionListener(this);
        menuitem_open.addActionListener(this);
        menuitem_save.addActionListener(this);
        menuitem_quit.addActionListener(this);

        menu_main.add(menu_file);
        menu_file.add(menuitem_new);
        menu_file.add(menuitem_open);
        menu_file.add(menuitem_save);
        menu_file.add(menuitem_quit);

        frame.setJMenuBar(menu_main);
    }

    // ActionListener implementation
    @Override
    public void actionPerformed(ActionEvent e) {
        String ingest = null;
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Choose Destination.");

        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        String ae = e.getActionCommand();
        if (ae.equals("Open")) {
            returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File f = new File(jfc.getSelectedFile().getAbsolutePath());
                try {
                    FileReader read = new FileReader(f);
                    Scanner scan = new Scanner(read);
                    while (scan.hasNextLine()) {
                        String line = scan.nextLine() + "\n";
                        ingest = ingest + line;
                    }
                    area.setText(ingest);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }

            // Save
            else if (ae.equals("Save")) {
                returnValue = jfc.showSaveDialog(null);
                try {
                    File f = new File(jfc.getSelectedFile().getAbsolutePath());
                    FileWriter out = new FileWriter(f);
                    out.write(area.getText());
                    out.close();
                } catch (FileNotFoundException ex) {
                    Component f = null;
                    JOptionPane.showMessageDialog(f, "File not found.");
                } catch (IOException ex) {
                    Component f = null;
                    JOptionPane.showMessageDialog(f, "Error");
                }
            }
            // New file
            else if (ae.equals("New")) {
                area.setText("");
            }
            // exit
            else if (ae.equals("Quit")) {
                System.exit(0);
            }
        }
    }
}
