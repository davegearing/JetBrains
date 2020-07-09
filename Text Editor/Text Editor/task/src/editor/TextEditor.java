package editor;

import javax.swing.*;

public class TextEditor extends JFrame {

    private JTextArea textArea;

    public TextEditor() {
        super("The first stage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        textArea = new JTextArea();
        textArea.setName("TextArea");
        add(textArea);
        setVisible(true);
        setLayout(null);
    }
}
