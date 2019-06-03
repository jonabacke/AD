package ab_09;

import java.util.HashMap;

public class Node {
	
	private int _value;
	private HashMap<Integer, Integer> _distance;
	private HashMap<Integer, Node> _nachfolger;
	
	public Node(int value) {
		// TODO Auto-generated constructor stub
		this._distance = new HashMap<Integer, Integer>();
		this._nachfolger = new HashMap<Integer, Node>();
		this._value = value;
	}
	
	
	public int get_distanc(int nachfolger) {
		return this._distance.get(nachfolger);
	}
	
	public HashMap<Integer, Node> get_neighbours() {
		return _nachfolger;
	}
	
	public int get_value() {
		return _value;
	}
	
	public void set_distance(int distance, int nachfolger) {
		this._distance.put(nachfolger, distance);
	}
	
	public void set_neighbours(Node nachfolger, int value) {
		this._nachfolger.put(value, nachfolger);
	}
	
	public void set_value(int _value) {
		this._value = _value;
	}

}
