package SimpleCalc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalcGUI extends JFrame{
    private JPanel panel1;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JTextField lblResult;
    private JTextField tfNumber2;
    private JButton btnCompute;

    public SimpleCalcGUI() {
        this.setTitle("Simple Calculator");

        cbOperations.addItem("+");
        cbOperations.addItem("-");
        cbOperations.addItem("*");
        cbOperations.addItem("/");

        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(tfNumber1.getText());
                int num2 = Integer.parseInt(tfNumber2.getText());
                String sym = cbOperations.getSelectedItem().toString();
                int result;

                if(sym == "+"){
                    result = num1 + num2;
                } else if (sym == "-") {
                    result = num1 - num2;
                } else if (sym == "*") {
                    result = num1 * num2;
                } else {
                    result = num1 / num2;
                }

                lblResult.setText(String.valueOf(result));
            }

        });
    }
    public static void main(String[] args) {
        SimpleCalcGUI app = new SimpleCalcGUI();
        app.setContentPane(app.panel1);
        app.setSize(500, 250);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
