package Components;

import java.util.HashMap;

/**
 * This is the abstraction of each component. Each component should have wires in, wiresout, innercomponents, component name, and description. 
 * @author Frank Hu
 *
 */
public abstract class Component {

	public HashMap<String, MultipleWire> wiresIn = null;
	public HashMap<String, MultipleWire> wiresOut = null;
	public HashMap<String, Component> innerComponents = null;
	public String componentName = "";
	public String description = "";

	public Component(HashMap<String, MultipleWire> in, HashMap<String, MultipleWire> out, HashMap<String,Component> innerComponents, String name,
			String description) {
		this.wiresIn = in;
		this.wiresOut = out;
		this.innerComponents = innerComponents;
		this.componentName = name;
		this.description = description;
	}

}
