import com.storyteller_f.read.ExcelRead;
import com.storyteller_f.read.Read;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    private JTextField textFieldPath;
    private JTextField textFieldRow;
    private JTextField textFieldCol;
    private JButton startButton;
    private JComboBox<String> comboBox1;
    private JPanel panel;
    private JComboBox<String> comboBoxSheetName;

    public Main() {
        List<String> type = Factory.type();
        for (String s : type) {
            comboBox1.addItem(s);
        }
        startButton.addActionListener(e -> {
            if (!check(textFieldPath, textFieldRow, textFieldCol)) {
                return;
            }

            int row = Integer.parseInt(textFieldRow.getText());
            int col = Integer.parseInt(textFieldCol.getText());
            ExcelRead excelRead = new ExcelRead(textFieldPath.getText());
            HashMap<String, List<String>> read;
            try {
                read = excelRead.read(row, col, comboBoxSheetName.getSelectedIndex());
                Output output = Factory.get(comboBox1.getItemAt(comboBox1.getSelectedIndex()));
                String output1 = output.output(read);
                System.out.println(output1);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        textFieldPath.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                fill();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                fill();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                fill();
            }
        });
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("自动状态机解析");
        Main main = new Main();
        jFrame.setContentPane(main.panel);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    private void fill() {
        //todo 改为异步操作
        System.out.println("fill");
        if (!check(textFieldPath)) return;
        if (!new File(textFieldPath.getText()).exists()) return;
        Read read = new ExcelRead(textFieldPath.getText());
        try {
            List<String> list = read.allSheets();
            comboBoxSheetName.removeAllItems();
            for (String s : list) {
                comboBoxSheetName.addItem(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean check(JTextField... array) {
        return Arrays.stream(array).anyMatch(this::check);
    }

    private boolean check(JTextField textField1) {
        String text = textField1.getText();
        return text != null && text.trim().length() > 0;
    }
}
