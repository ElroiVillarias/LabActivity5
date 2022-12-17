package FoodOrdering;

import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderGUI extends JFrame{
    private JPanel panel1;
    private JButton btnOrder;
    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private List<JCheckBox> FoodGroup;
    private List<JRadioButton> DisGroup;

    public FoodOrderGUI() {
        this.setTitle("Food Ordering System");
    //for checkbox
        FoodGroup = new ArrayList<>();
        FoodGroup.add(cPizza);
        FoodGroup.add(cBurger);
        FoodGroup.add(cFries);
        FoodGroup.add(cSoftDrinks);
        FoodGroup.add(cTea);
        FoodGroup.add(cSundae);
    //for radiobutton
        DisGroup = new ArrayList<>();
        DisGroup.add(rbNone);
        DisGroup.add(rb5);
        DisGroup.add(rb10);
        DisGroup.add(rb15);

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = checkFood();
                double total = checkDiscount(amount);

                JOptionPane.showMessageDialog(panel1, String.format("The total price is Php %.2f", total));
            }
        });
    }

    public static void main(String[] args) {
        FoodOrderGUI app = new FoodOrderGUI();
        app.setContentPane(app.panel1);
        app.setSize(750, 500);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    public int checkFood(){
        int total = 0;

        for (JCheckBox rb : FoodGroup) {
            if (rb.isSelected()) {
                if (rb.equals(cPizza)) {
                    total += 100;
                } else if (rb.equals(cBurger)) {
                    total += 80;
                } else if (rb.equals(cFries)) {
                    total += 65;
                } else if (rb.equals(cSoftDrinks)) {
                    total += 55;
                } else if (rb.equals(cTea)) {
                    total += 50;
                } else if (rb.equals(cSundae)) {
                    total += 40;
                }
            }
        }

        return total;
    }
    public double checkDiscount(int val){
        double newval = 0;

        for (JRadioButton rb : DisGroup) {
            if (rb.isSelected()) {
                if(rb.equals(rb5)){
                    newval = val - (val * 0.05);
                } else if (rb.equals(rb10)) {
                    newval = val - (val * 0.10);
                } else if (rb.equals(rb15)) {
                    newval = val - (val * 0.15);
                } else {
                    newval = val;
                }
            }
        }

        return newval;
    }

}
