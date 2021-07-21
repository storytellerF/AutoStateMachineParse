import com.storyteller_f.read.ExcelRead;

import javax.swing.*;
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

    public Main() {
        List<String> type = Factory.type();
        for (String s : type) {
            comboBox1.addItem(s);
        }
        startButton.addActionListener(e -> {
            if (!check(textFieldPath, textFieldRow, textFieldCol)) {
                return;
            }

            int row=Integer.parseInt(textFieldRow.getText());
            int col=Integer.parseInt(textFieldCol.getText());
            ExcelRead excelRead=new ExcelRead(textFieldPath.getText());
            HashMap<String, List<String>> read = excelRead.read(row, col);
            Output output=Factory.get(comboBox1.getItemAt(comboBox1.getSelectedIndex()));
            String output1 = output.output(read);
            System.out.println(output1);
        });
    }

    private boolean check(JTextField... array) {
        return Arrays.stream(array).anyMatch(this::check);
    }

    private boolean check(JTextField textField1) {
        String text = textField1.getText();
        return text !=null&&text.trim().length()>0;
    }

    public static void main(String[] args) {
        JFrame jFrame=new JFrame("自动状态机解析");
        Main main=new Main();
        jFrame.setContentPane(main.panel);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
