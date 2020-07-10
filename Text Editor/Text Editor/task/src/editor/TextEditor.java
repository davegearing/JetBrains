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
    private String origfile = "";

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
        saveButton.addActionListener(actionEvent -> {
            //Save code
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
        });
        forceSize(saveButton, 80, 20);
        loadButton = new JButton();
        loadButton.setName("LoadButton");
        loadButton.setText("Load");
        loadButton.addActionListener(actionEvent -> {
            //load code
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
        });
        forceSize(loadButton, 80, 20);

        add(filenameField);
        add(saveButton);
        add(loadButton);
        add(scrollPane);
        setVisible(true);
        setLayout(new FlowLayout());
    }

    public static void forceSize(JComponent component, int width, int height) {
        Dimension d = new Dimension(width, height);
        component.setMinimumSize(d);/*from  www.javas.com*/
        component.setMaximumSize(d);
        component.setPreferredSize(d);
    }
}
