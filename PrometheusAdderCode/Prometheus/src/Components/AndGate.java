package Components;

import java.util.HashMap;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;

/**
 * AndGate class, takes two inputs and finds the minimum between the two values. This is simulating the anding function.
 * @author Frank Hu
 *
 */
public class AndGate extends Component {

	public AndGate(HashMap<String, MultipleWire> in, HashMap<String, MultipleWire> out,
			HashMap<String, Component> innerComponents, String name, String description) {
		super(in, out, innerComponents, name, description);
		NumberBinding output = Bindings.min(this.wiresIn.get("input1").getValue(),
				this.wiresIn.get("input2").getValue());
		this.wiresOut.get("output1").getValue().bind(output);
	}

	public void update() {
	}
}
