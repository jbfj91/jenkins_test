package de.jacobs.calculator;

public class CalculatorMain {

    /**
     * Zum Start des Taschenrechner Programms
     * @author jacob
     */
    public static void main(String[] args) {
        CalculatorView tr = new CalculatorView();
        tr.setSize(300, 300);
        tr.setVisible(true);
        tr.setResizable(false);
    }
}
