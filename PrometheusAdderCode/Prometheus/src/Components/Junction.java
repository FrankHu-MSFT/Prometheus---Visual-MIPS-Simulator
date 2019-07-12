package Components;

import java.util.HashMap;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;

/**
 * This is a junction. It takes one input and has two outputs of equivalent value of the input. It does this through binding the output1 and output2 to input1 of the HashMap<String,MultipleWire> in.get("input")
 * 
 * @author Frank Hu
 *
 */
public class Junction extends Component {

	public Junction(HashMap<String, MultipleWire> in, HashMap<String, MultipleWire> out,
			HashMap<String, Component> innerComponents, String name, String description) {
		super(in, out, innerComponents, name, description);
		this.wiresOut.get("output1").getValue().bind(this.wiresIn.get("input1").getValue());
		this.wiresOut.get("output2").getValue().bind(this.wiresIn.get("input1").getValue());

	}
}
