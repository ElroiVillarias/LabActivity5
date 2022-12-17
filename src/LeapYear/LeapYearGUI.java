package LeapYear;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearGUI extends JFrame {
    private JPanel panel1;
    private JTextField tfYear;
    private JButton btnCheckYear;

    public LeapYearGUI(){
        this.setTitle("Leap Year Checker");

        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag;
                try{
                    Integer.parseInt(tfYear.getText());
                }catch (Exception x){
                    JOptionPane.showMessageDialog(panel1, "Not an integer");
                }
                int year = Integer.parseInt(tfYear.getText());

                if (year % 400 == 0) {
                    flag = true;
                } else if (year % 100 == 0) {
                    flag = false;
                } else if (year % 4 == 0) {
                    flag = true;
                } else {
                    flag = false;
                }

                if(flag){
                    JOptionPane.showMessageDialog(panel1, "Leap Year");
                } else {
                    JOptionPane.showMessageDialog(panel1, "Not a leap year");
                }

            }
        });

    }

    public static void main(String[] args) {
        LeapYearGUI app = new LeapYearGUI();
        app.setContentPane(app.panel1);
        app.setSize(500, 250);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
