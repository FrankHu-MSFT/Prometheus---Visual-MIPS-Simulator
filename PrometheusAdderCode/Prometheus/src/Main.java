import java.util.HashMap;

import Components.Adder;
import Components.Component;
import Components.MultipleWire;

/**
 * Driver class. This main function currently creates an adder, and displays it's sum and c_out. If you wish to change the values, you can change the item in the parameters of 
 * input1 and input2 of multiple wire, you should be able to spot the variables clearly in the code.
 * @author Frank Hu
 *
 */
public class Main {

	public static void main(String[] args) {

	
		HashMap<String, MultipleWire> inputs = new HashMap<String, MultipleWire>();

		

		// These values when changed change the output of sum/c_out. If you wish to change the value to test, change MultipleWire input[y] = new MultipleWire(x). And change x to whatever you wish.
		// ----------------------------------------------------------------------------------------------------------------
		// ----------------------------------------------------------------------------------------------------------------
		MultipleWire input1 = new MultipleWire(0); // A
		MultipleWire input2 = new MultipleWire(0); // B
		MultipleWire input3 = new MultipleWire(1); // C_IN
		// ----------------------------------------------------------------------------------------------------------------
		// ----------------------------------------------------------------------------------------------------------------
		
		
		inputs.put("input1", input1);
		inputs.put("input2", input2);
		inputs.put("input3", input3);
		HashMap<String, MultipleWire> outputs = new HashMap<String, MultipleWire>();
		HashMap<String, Component> noInnerComponents = new HashMap<String, Component>();
		Adder adder = new Adder(inputs, outputs, noInnerComponents, "adder", "Adds two bits");
		adder.wiresIn.get("input1").setValue(1);
		System.out.println("Sum  = " + adder.wiresOut.get("output1").getValue().get());
		System.out.println("C_OUT = " + adder.wiresOut.get("output2").getValue().get());
		
	}
}
