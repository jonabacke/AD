package ab_09;

import java.util.ArrayList;

import ab_01.SET;

public class Node {
	
	private int _value;
	private ArrayList<Integer> _distance;
	private ArrayList<Node> _nachfolger;
	
	public Node(int value) {
		// TODO Auto-generated constructor stub
		this._distance = new ArrayList<Integer>();
		this._nachfolger = new ArrayList<Node>();
		this._value = value;
	}
	
	
	public int get_distanc(int nachfolger) {
		return this._distance.get(nachfolger);
	}
	
	public ArrayList<Node> get_neighbours() {
		return _nachfolger;
	}
	
	public int get_value() {
		return _value;
	}
	
	public void set_distance(int distance, int nachfolger) {
		this._distance.add(nachfolger, distance);;
	}
	
	public void set_neighbours(Node nachfolger, int value) {
		this._nachfolger.add(value, nachfolger);
	}
	
	public void set_value(int _value) {
		this._value = _value;
	}

}
