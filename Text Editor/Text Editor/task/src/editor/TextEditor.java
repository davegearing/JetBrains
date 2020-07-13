package editor;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class TextEditor extends JFrame {

    final private JTextArea textArea;
    final private JTextField filenameField;
    final private JButton saveButton;
    final private JButton loadButton;
    final private JScrollPane scrollPane;
    final private JMenuBar menuBar;
    final private JMenu menuFile;
    final private JMenuItem loadItem;
    final private JMenuItem saveItem;
    final private JMenuItem exitItem;
    final private JPanel area1;
    final private JPanel area2;
    //private String origfile = "";

    public TextEditor() {
        super("Text Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 350);

        textArea = new JTextArea();
        textArea.setName("TextArea");
        scrollPane = new JScrollPane(textArea);
        scrollPane.setName("ScrollPane");
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        forceSize(scrollPane, 250, 250);

        filenameField = new JTextField();
        filenameField.setName("FilenameField");
        forceSize(filenameField, 100, 20);
        saveButton = new JButton();
        saveButton.setName("SaveButton");
        saveButton.setText("Save");
        saveButton.addActionListener(actionEvent -> saveCode());
        forceSize(saveButton, 80, 20);
        loadButton = new JButton();
        loadButton.setName("LoadButton");
        loadButton.setText("Load");
        loadButton.addActionListener(actionEvent -> loadCode());
        forceSize(loadButton, 80, 20);

        // menu
        menuBar = new JMenuBar();
        menuFile = new JMenu();
        menuFile.setName("MenuFile");
        menuFile.setText("File");
        menuBar.add(menuFile);
        loadItem = new JMenuItem();
        loadItem.setName("MenuLoad");
        loadItem.setText("Load");
        loadItem.addActionListener(actionEvent -> loadCode());
        saveItem = new JMenuItem();
        saveItem.setName("MenuSave");
        saveItem.setText("Save");
        saveItem.addActionListener(actionEvent -> saveCode());
        exitItem = new JMenuItem();
        exitItem.setName("MenuExit");
        exitItem.setText("Exit");
        exitItem.addActionListener(actionEvent -> dispose());
        menuFile.add(loadItem);
        menuFile.add(saveItem);
        menuFile.addSeparator();
        menuFile.add(exitItem);

        area1 = new JPanel();
        area2 = new JPanel();
        //add(menuBar);
        this.setJMenuBar(menuBar);
        area1.add(filenameField);
        area1.add(saveButton);
        area1.add(loadButton);
        area2.add(scrollPane);

        add(area1);
        add(area2);
        setVisible(true);
        setLayout(new FlowLayout());
    }

    private void loadCode() {
        File file = new File(filenameField.getText());

        try {
            if (file.createNewFile()) {
                textArea.setText("");
            } else {
                textArea.setText(new String(Files.readAllBytes(file.toPath())));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //textArea.setText("");
        //String filename = filenameField.getText();
        //if (filename.equals("")) {
        //    File file = new File(filename);
        //    if (file.isFile()) {
        //        try (Scanner scanner = new Scanner(file)) {
        //            while (scanner.hasNextLine()) {
        //                if (!textArea.getText().equals("")) {
        //                    textArea.append("\n");
        //                }
        //                textArea.append(scanner.nextLine());
        //            }
        //        } catch (Exception e) {
        //            e.printStackTrace();
        //        }
        //    }
        //}
        //origfile = textArea.getText();
    }

    private void saveCode() {
        File file = new File(filenameField.getText());
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(textArea.getText());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //String filename = filenameField.getText();
        //if (!filename.equals("")) {
        //    String newFile = textArea.getText();
        //    try (FileWriter writer = new FileWriter(filename)) {
        //        writer.write(newFile);
        //    } catch (Exception e) {
        //        e.printStackTrace();
        //   }
        //}
    }

    public static void forceSize(JComponent component, int width, int height) {
        Dimension d = new Dimension(width, height);
        component.setMinimumSize(d);/*from  www.javas.com*/
        component.setMaximumSize(d);
        component.setPreferredSize(d);
    }
}
