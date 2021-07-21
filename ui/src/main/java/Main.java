import com.storyteller_f.read.ExcelRead;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    private JTextField textFieldPath;
    private JTextField textFieldRow;
    private JTextField textFieldCol;
    private JButton 开始Button;

    public Main() {
        开始Button.addActionListener(e -> {
            if (!check(textFieldPath, textFieldRow, textFieldCol)) {
                return;
            }
            int row=Integer.parseInt(textFieldRow.getText());
            int col=Integer.parseInt(textFieldCol.getText());
            ExcelRead excelRead=new ExcelRead(textFieldPath.getText());
            HashMap<String, List<String>> read = excelRead.read(row, col);
            Output output=Factory.get();
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
}
