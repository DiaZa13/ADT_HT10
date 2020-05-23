import java.util.ArrayList;

public class Node {
	
	private String node;
	private ArrayList<String> nodes;
	
	public Node() {
		this.node = " ";
		this.nodes = new ArrayList<String>();
	}

	/**
	 * @return the node
	 */
	public String getNode() {
		return node;
	}

	/**
	 * @param node the node to set
	 */
	public void setNode(String node) {
		this.node = node;
	}
	
	
	/**
	 * addNodes -> add new nodes to the arrayList
	 * @param from -> node to add
	 */
	public void addNodes(String from) {
		if(!nodes.contains(from))
			nodes.add(from);
	}
	
	/**
	 * actualNodes -> returns the arrayList with the nodes
	 * @return
	 */
	public ArrayList<String> actualNodes(){
		return nodes;
	}
	

}
