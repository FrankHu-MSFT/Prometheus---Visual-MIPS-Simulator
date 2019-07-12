package Components;

import java.util.HashMap;
import java.util.concurrent.Callable;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;

/**
 * Class NandGate, this class is a little bit different since max/min doesn't work here. I had utilize the create integer binding function to create a new binding
 * to turn the integer input values into boolean values. From there, it utilizes a true nand operation, and then returns 1/0 accordingly.
 * @author Frank Hu
 *
 */
public class NandGate extends Component {
	NumberBinding output = null;
	public NandGate(HashMap<String, MultipleWire> in, HashMap<String, MultipleWire> out,
			HashMap<String, Component> innerComponents, String name, String description) {
		
		super(in, out, innerComponents, name, description);
		Bindings.min(this.wiresIn.get("input1").getValue(), this.wiresIn.get("input2").getValue());

		this.wiresOut.get("output1").getValue().bind(Bindings.createIntegerBinding(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				boolean wiresInOne = false;
				boolean wiresInTwo = false;
				wiresInOne = wiresIn.get("input1").getValue().get() == 0 ? false : true;
				wiresInTwo = wiresIn.get("input2").getValue().get() == 0 ? false : true;
				if (!(wiresInOne && wiresInTwo)) {
					return 1;
				} else {
					return 0;
				}
			}

		}, this.wiresIn.get("input1").getValue(), this.wiresIn.get("input2").getValue()));

	}

	public void update() {
		this.wiresOut.get("output1").getValue().set(output.intValue());
	}

}
