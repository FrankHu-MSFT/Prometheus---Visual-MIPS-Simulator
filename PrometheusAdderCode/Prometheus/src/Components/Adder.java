package Components;

import java.util.HashMap;

/**
 * This is a composition for an adder. It consists of all the elements displayed in the Software Design document. It follows the same sequencing as of the sequence diagram, and
 * is portrayed in visually through the component item made by Nick Klepp.
 * 
 * It utilizes, 4 junctions, 2 xorgates, and 3 NandGates to create the adder.
 * 
 * After implementing the adder class. I wonder if they innerComponents parameter is necessary. When initializing, all innercomponents should be initialized in the constructor
 * but by leaving a parameter for innerComponents HashMap<String, Component> This leads to extraneous code. I think it should probably be taken out. 
 * 
 * @author Frank Hu
 *
 */

public class Adder extends Component {
	HashMap<String, Component> noInnerComponents = new HashMap<String, Component>();
	HashMap<String, MultipleWire> componentsJuncInOne = new HashMap<String, MultipleWire>();
	HashMap<String, MultipleWire> juncOneOutput = new HashMap<String, MultipleWire>();
	MultipleWire juncOneOutputOne = new MultipleWire(0);
	MultipleWire juncOneOutputTwo = new MultipleWire(0);
	HashMap<String, MultipleWire> componentsJuncInTwo = new HashMap<String, MultipleWire>();
	HashMap<String, MultipleWire> juncTwoOutput = new HashMap<String, MultipleWire>();
	MultipleWire juncTwoOutputOne = new MultipleWire(0);
	MultipleWire juncTwoOutputTwo = new MultipleWire(0);
	HashMap<String, MultipleWire> nandGate1In = new HashMap<String, MultipleWire>();
	HashMap<String, MultipleWire> nandGate1Out = new HashMap<String, MultipleWire>();
	MultipleWire nandGate1Output = new MultipleWire(0);
	HashMap<String, MultipleWire> xorGate1In = new HashMap<String, MultipleWire>();
	HashMap<String, MultipleWire> xorGate1Out = new HashMap<String, MultipleWire>();
	MultipleWire xorGate1Output = new MultipleWire(0);
	HashMap<String, MultipleWire> componentsJuncInThree = new HashMap<String, MultipleWire>();
	HashMap<String, MultipleWire> juncThreeOutput = new HashMap<String, MultipleWire>();
	MultipleWire juncThreeOutputOne = new MultipleWire(0);
	MultipleWire juncThreeOutputTwo = new MultipleWire(0);
	HashMap<String, MultipleWire> componentsJuncInFour = new HashMap<String, MultipleWire>();
	MultipleWire inputJunctFour = new MultipleWire(0);
	HashMap<String, MultipleWire> juncFourOutput = new HashMap<String, MultipleWire>();
	MultipleWire juncFourOutputOne = new MultipleWire(0);
	MultipleWire juncFourOutputTwo = new MultipleWire(0);
	HashMap<String, MultipleWire> xorGate4In = new HashMap<String, MultipleWire>();
	HashMap<String, MultipleWire> xorGate4Out = new HashMap<String, MultipleWire>();
	MultipleWire xorGate4Output = new MultipleWire(0);
	HashMap<String, MultipleWire> nandGate2In = new HashMap<String, MultipleWire>();
	HashMap<String, MultipleWire> nandGate2Out = new HashMap<String, MultipleWire>();
	MultipleWire nandGate2Output = new MultipleWire(0);
	HashMap<String, MultipleWire> nandGate5In = new HashMap<String, MultipleWire>();
	HashMap<String, MultipleWire> nandGate5Out = new HashMap<String, MultipleWire>();
	MultipleWire nandGate5Output = new MultipleWire(0);

	XorGate xorGate1 = null;
	Junction junct3 = null;
	Junction junct4 = null;
	XorGate xorGate4 = null;
	NandGate nandGate2 = null;
	NandGate nandGate5 = null;
	NandGate nandGate3 = null;
	Junction junct1 = null;
	Junction junct2 = null;
	
	/**
	 * Here we initialize all the items. We set the input for each junction accordingly to the picture provided. The inputs are from in, and the outputs are from out.
	 * Inner components are initialized in this constructor because it is a pretty low level one, and it is typically consistent.
	 * @param in
	 * @param out
	 * @param innerComponents
	 * @param name
	 * @param description
	 */
	public Adder(HashMap<String, MultipleWire> in, HashMap<String, MultipleWire> out,
			HashMap<String, Component> innerComponents, String name, String description) {
		super(in, out, innerComponents, name, description);
		noInnerComponents = new HashMap<String, Component>();

		componentsJuncInOne = new HashMap<String, MultipleWire>();
		componentsJuncInOne.put("input1", in.get("input1"));
		juncOneOutput = new HashMap<String, MultipleWire>();
		juncOneOutputOne = new MultipleWire(0);
		juncOneOutputTwo = new MultipleWire(0);
		juncOneOutput.put("output1", juncOneOutputOne);
		juncOneOutput.put("output2", juncOneOutputTwo);

		junct1 = new Junction(componentsJuncInOne, juncOneOutput, noInnerComponents, "Junction1",
				"Junction for first nand gate");

		componentsJuncInTwo = new HashMap<String, MultipleWire>();
		componentsJuncInTwo.put("input1", in.get("input2"));
		juncTwoOutput = new HashMap<String, MultipleWire>();
		juncTwoOutputOne = new MultipleWire(0);
		juncTwoOutputTwo = new MultipleWire(0);
		juncTwoOutput.put("output1", juncTwoOutputOne);
		juncTwoOutput.put("output2", juncTwoOutputTwo);

		junct2 = new Junction(componentsJuncInTwo, juncTwoOutput, noInnerComponents, "Junction2",
				"Junction for first nand gate");

		nandGate1In = new HashMap<String, MultipleWire>();
		nandGate1In.put("input1", junct1.wiresOut.get("output1"));
		nandGate1In.put("input2", junct2.wiresOut.get("output1"));
		nandGate1Out = new HashMap<String, MultipleWire>();
		nandGate1Output = new MultipleWire(0);
		nandGate1Out.put("output1", nandGate1Output);
		nandGate3 = new NandGate(nandGate1In, nandGate1Out, noInnerComponents, "NandGate3",
				"Nandgate1 output goes to Nand 5");

		xorGate1In = new HashMap<String, MultipleWire>();
		xorGate1In.put("input1", junct1.wiresOut.get("output1"));
		xorGate1In.put("input2", junct2.wiresOut.get("output1"));
		xorGate1Out = new HashMap<String, MultipleWire>();
		xorGate1Output = new MultipleWire(0);
		xorGate1Out.put("output1", xorGate1Output);
		xorGate1 = new XorGate(xorGate1In, xorGate1Out, noInnerComponents, "xorGate1",
				"xorgate1 output goes to the junction 3");

		componentsJuncInThree = new HashMap<String, MultipleWire>();
		componentsJuncInThree.put("input1", xorGate1.wiresOut.get("output1"));
		juncThreeOutput = new HashMap<String, MultipleWire>();
		juncThreeOutputOne = new MultipleWire(0);
		juncThreeOutputTwo = new MultipleWire(0);
		juncThreeOutput.put("output1", juncThreeOutputOne);
		juncThreeOutput.put("output2", juncThreeOutputTwo);

		junct3 = new Junction(componentsJuncInThree, juncThreeOutput, noInnerComponents, "Junction3",
				"Output should go to xor 4");

		componentsJuncInFour = new HashMap<String, MultipleWire>();
		inputJunctFour = new MultipleWire(0);
		componentsJuncInFour.put("input1", in.get("input3"));
		juncFourOutput = new HashMap<String, MultipleWire>();
		juncFourOutputOne = new MultipleWire(0);
		juncFourOutputTwo = new MultipleWire(0);
		juncFourOutput.put("output1", juncFourOutputOne);
		juncFourOutput.put("output2", juncFourOutputTwo);

		junct4 = new Junction(componentsJuncInFour, juncFourOutput, noInnerComponents, "Junction4",
				"Goes into Xor4 and Nand 2, C_IN");

		xorGate4In = new HashMap<String, MultipleWire>();
		xorGate4In.put("input1", junct3.wiresOut.get("output1"));
		xorGate4In.put("input2", junct4.wiresOut.get("output2"));
		xorGate4Out = new HashMap<String, MultipleWire>();
		xorGate4Output = new MultipleWire(0);
		xorGate4Out.put("output1", xorGate4Output);
		xorGate4 = new XorGate(xorGate4In, xorGate4Out, noInnerComponents, "xorGate1",
				"xorgate4 output goes to sum of the component");

		nandGate2In = new HashMap<String, MultipleWire>();
		nandGate2In.put("input1", junct3.wiresOut.get("output1"));
		nandGate2In.put("input2", junct4.wiresOut.get("output2"));
		nandGate2Out = new HashMap<String, MultipleWire>();
		nandGate2Output = new MultipleWire(0);
		nandGate2Out.put("output1", nandGate2Output);
		nandGate2 = new NandGate(nandGate2In, nandGate2Out, noInnerComponents, "NandGate2",
				"Nandgate2 goes to nandgate 5");

		nandGate5In = new HashMap<String, MultipleWire>();
		nandGate5In.put("input1", nandGate2.wiresOut.get("output1"));
		nandGate5In.put("input2", nandGate3.wiresOut.get("output1"));
		nandGate5Out = new HashMap<String, MultipleWire>();
		nandGate5Output = new MultipleWire(0);
		nandGate5Out.put("output1", nandGate5Output);
		nandGate5 = new NandGate(nandGate5In, nandGate5Out, noInnerComponents, "NandGate2", "Nandgate5 output = C_out");

		this.innerComponents.put("xorGate1", xorGate1);
		this.innerComponents.put("xorGate4", xorGate1);
		this.innerComponents.put("junct3", junct3);
		this.innerComponents.put("junct4", junct4);
		this.innerComponents.put("nandGate2", nandGate2);
		this.innerComponents.put("nandGate5", nandGate5);
		this.innerComponents.put("nandGate3", nandGate3);
		this.innerComponents.put("junct1", junct1);
		this.innerComponents.put("junct2", junct2);
		this.wiresOut.put("output1", xorGate4.wiresOut.get("output1")); // Sum
		// vale
		this.wiresOut.put("output2", nandGate5.wiresOut.get("output1")); // C_out

	}

}
