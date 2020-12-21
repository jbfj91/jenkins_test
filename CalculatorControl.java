package de.jacobs.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Steuerung des Taschenrechner Views und Models.
 * @author jacob
 * @version 1.3
 */

public class CalculatorControl implements ActionListener {

	/**
	 * Datenfelder des Controller Objekts des Taschenrechners 
	 **/
	private final CalculatorView view;
	private final CalculatorModel model;

	/**
	 * Konstruktor zum Anlegen eines Taschenrechner Controller Objekts
	 * @param v Viewobjekt eines Taschenrechners, dass dieser Controller betreut 
	 * @param m Modelobjekt eines Taschenrechners, dass dieser Controller betreut 
	 **/
	public CalculatorControl(CalculatorView v, CalculatorModel m) {
		this.view = v;
		this.model = m;
		}
	
	
	
	/**
	 * ActionListener - Diese Methode wird immer aufgerufen, wenn ein Button auf dem TR
	 * betaetigt wurde.
	 **/
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == view.getButtons().get(0)) adNumber("0");  // 0
		if (ev.getSource() == view.getButtons().get(1)) adNumber("1");  // 1
		if (ev.getSource() == view.getButtons().get(2)) adNumber("2");  // 2
		if (ev.getSource() == view.getButtons().get(3)) adNumber("3");  // 3
		if (ev.getSource() == view.getButtons().get(4)) adNumber("4");  // 4
		if (ev.getSource() == view.getButtons().get(5)) adNumber("5");  // 5
		if (ev.getSource() == view.getButtons().get(6)) adNumber("6");  // 6
		if (ev.getSource() == view.getButtons().get(7)) adNumber("7");  // 7
		if (ev.getSource() == view.getButtons().get(8)) adNumber("8");  // 8
		if (ev.getSource() == view.getButtons().get(9)) adNumber("9");  // 9

		if (ev.getSource() == view.getButtons().get(10)) setOperator("+"); // Plus
		if (ev.getSource() == view.getButtons().get(11)) setOperator("-"); // Minus
		if (ev.getSource() == view.getButtons().get(12)) setOperator("*"); // Mal
		if (ev.getSource() == view.getButtons().get(13)) setOperator("/"); // Geteilt

		if (ev.getSource() == view.getButtons().get(14)) startCalculation();			// =
		if (ev.getSource() == view.getButtons().get(15)) startToClear();				// C
	}	
	
	
	/**
	* Wird aufgerufen, wenn eine Zahl auf dem Taschenrechner betaetigt wurde
	* Diese Zahl wird der aktuell auf dem Display stehenden Zahl angehaengt
	* @param i Die Ziffer die an den aktuell eingegebenen Operanden angehaengt werden soll
	**/
	private void adNumber(String i) {
		model.setOperand(model.getOperand() + i); 
		view.update();
	}
	
	/**
	* Wird aufgerufen, wenn eine Operatoraste, -, /, *) betaetigt wurde 
	* @param i Der eingegebene Operator (+, -, /, *)
	**/
	private void setOperator(String i) {
		model.setOperator(i);
		view.update();
	}
	
	
	/**
	* Wird aufgerufen, wenn die = Taste auf einem Taschenrechner betaetigt wurde. 
	**/
	private void startCalculation() {
		model.calculate();
		view.update();
	}
	
	
	/**
	* Wird aufgerufen, wenn die C Taste auf einem Taschenrechner
	* betaetigt wurde.
	**/
	private void startToClear() {
		model.clear(); 
		view.update();
	}
	
	
}
