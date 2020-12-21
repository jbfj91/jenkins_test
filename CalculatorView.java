package de.jacobs.calculator;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;


/**
 * Erstellt die Oberfläche des Taschenrechners mit Eingabe- und Darstellungsmöglichkeiten.
 *
 * @author jacob
 * @version 1.3
 */
public class CalculatorView extends JFrame {

    /**
     * Datenfeld des Taschenrechner-Views zur Darstellung des Displays
     */
    private final JTextField display = new JTextField();

    /*
     * Datenfeld in Form einer Liste in der alle Tasten des Taschenrechners
     * abgelegt werden. Die Tasten werden in diesem Programm ueber den
     * entsprechenden Index angesprochen.
     */
    private final List<JButton> buttons = new LinkedList<>();

    public List<JButton> getButtons() {
        return buttons;
    }

    /*
     * Datenfelder des Views die auf das Modelobjekt und Controllerobjekt des TR
     * verweisen
     */
    private CalculatorModel model = new CalculatorModel();
    private CalculatorControl controller = new CalculatorControl(this, model);


    /**
     * Konstruktor zum Anlegen eines Viewobjekts eines Taschenrechners. Der
     * Konstruktor platziert alle Bedienelemente und "verlinkt" diese mit einem
     * Controller
     **/
    public CalculatorView() {

        super("Taschenrechner");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //Initialisierung des Displays
        this.display.setEditable(false);
        this.display.setSize(200, 60);

        Panel buttonPanel = new Panel();
        GridLayout gbLayout = new GridLayout(4, 4);
        gbLayout.setHgap(5);
        gbLayout.setVgap(5);
        buttonPanel.setLayout(gbLayout);

        //Initizialisierung der Buttons
        buttons.add(new JButton("0")); // Index 0
        buttons.add(new JButton("1")); // Index 1
        buttons.add(new JButton("2")); // Index 2
        buttons.add(new JButton("3")); // Index 3
        buttons.add(new JButton("4")); // Index 4
        buttons.add(new JButton("5")); // Index 5
        buttons.add(new JButton("6")); // Index 6
        buttons.add(new JButton("7")); // Index 7
        buttons.add(new JButton("8")); // Index 8
        buttons.add(new JButton("9")); // Index 9
        buttons.add(new JButton("+")); // Index 10
        buttons.add(new JButton("-")); // Index 11
        buttons.add(new JButton("*")); // Index 12
        buttons.add(new JButton("/")); // Index 13
        buttons.add(new JButton("=")); // Index 14
        buttons.add(new JButton("C")); // Index 15


        // Zeile 1 des Bedienpanels des TR wird angelegt
        buttonPanel.add(this.buttons.get(1));
        buttonPanel.add(this.buttons.get(2));
        buttonPanel.add(this.buttons.get(3));
        buttonPanel.add(this.buttons.get(10));

        // Zeile 2 des Bedienpanels des TR wird angelegt
        buttonPanel.add(this.buttons.get(4));
        buttonPanel.add(this.buttons.get(5));
        buttonPanel.add(this.buttons.get(6));
        buttonPanel.add(this.buttons.get(11)); // Minus

        // Zeile 3 des Bedienpanels des TR wird angelegt
        buttonPanel.add(this.buttons.get(7));
        buttonPanel.add(this.buttons.get(8));
        buttonPanel.add(this.buttons.get(9));
        buttonPanel.add(this.buttons.get(12)); // Mal

        // Zeile 4 des Bedienpanels des TR wird angelegt
        buttonPanel.add(this.buttons.get(15));
        buttonPanel.add(this.buttons.get(0));
        buttonPanel.add(this.buttons.get(14));
        buttonPanel.add(this.buttons.get(13));

        // Display des TR in die erste Zeile setzen. Das Bedienpanel direkt
        // darunter
        this.add(display, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);

        // Alle Tasten des Rechners mit dem Controllerobjekt verknuepfen
        for (JButton b : buttons) b.addActionListener(controller);
    }

    /**
     * Diese Methode wird vom Controller aufgerufen, wenn der View aufdatiert
     * werden soll.
     */
    public void update() {
        String result = model.getResult();
        String operator = model.getOperator();
        String operand = model.getOperand();
        String error = (model.getError().equals("") ? "" : (model.getError() + "!!!"));
        display.setText(result + operator + operand + error);
    }
}
