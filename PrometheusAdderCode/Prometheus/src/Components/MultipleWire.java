package Components;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * MultipleWire class is the representation of every wire between one component and another. 
 * This is because for consistency we can represent each wire as a multiple wire, but not every wire can be a multiplewire.
 * 
 * @author Frank Hu
 *
 */
public class MultipleWire {

	IntegerProperty value = new SimpleIntegerProperty();
	ArrayList<Wire> wires = new ArrayList<Wire>();

	Component componentIn = null;
	Component componentOut = null;

	public MultipleWire(int value) {
		this.value.set(value);
	}

	public MultipleWire(Component in, Component out) {
		this.componentIn = in;
		this.componentOut = out;
		this.value.set((componentIn.wiresOut.get(componentOut.componentName).value.get()));
	}

	/**
	 * useless, no need for this function.
	 */
	public void update() {
		// It should update automatically if it's the same wire
		// Also need to change wires to reflect total wire value, can be done
		// through easy calculation
	}

	/**
	 * set the in component of a multiplewire
	 * @param component
	 */
	public void setComponentIn(Component component) {
		this.componentIn = component;
	}

	/**
	 * set the out component of a multiplewire
	 * @param component
	 */
	public void setComponentOut(Component component) {
		this.componentOut = component;
	}

	/**
	 * Get the value of the multiplewire
	 * @param component
	 */
	public IntegerProperty getValue() {
		return value;
	}

	/**
	 * Bind a new integerproperty to the multiplewire
	 * @param component
	 */
	public void setValue(IntegerProperty value) {
		this.value = value;
	}
	/**
	 * set the value of the multiple wire
	 * @param component
	 */
	public void setValue(int value) {
		this.value.set(value);
	}
}
