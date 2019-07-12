package Components;

import java.util.HashMap;
import java.util.concurrent.Callable;

import javafx.beans.binding.Bindings;

/**
 * This is the xorgate class. It utilizes teh createIntegerBinding function and then finds the xor of a value by doing output1  ^ output2. This is a natural way to find
 * the xor between two numbers.
 * @author Frank Hu
 *
 */
public class XorGate extends Component {

	public XorGate(HashMap<String, MultipleWire> in, HashMap<String, MultipleWire> out,
			HashMap<String, Component> innerComponents, String name, String description) {
		super(in, out, innerComponents, name, description);
		this.wiresOut.get("output1").getValue().bind(Bindings.createIntegerBinding(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return wiresIn.get("input1").getValue().get() ^ wiresIn.get("input2").getValue().get();
			}

		}, this.wiresIn.get("input1").getValue(), this.wiresIn.get("input2").getValue()));

	}

	public void update() {
	}

}
