package Components;

import java.util.HashMap;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;

/**
 * This clas is the orgate. It finds the max of the two inputs.
 * @author Frank Hu
 *
 */
public class OrGate extends Component {

	public OrGate(HashMap<String, MultipleWire> in, HashMap<String, MultipleWire> out,
			HashMap<String, Component> innerComponents, String name, String description) {
		super(in, out, innerComponents, name, description);
		NumberBinding output = Bindings.max(this.wiresIn.get("input1").getValue(),
				this.wiresIn.get("input2").getValue());
		this.wiresOut.get("output1").getValue().bind(output);

	}

	public void update() {
	}
}
