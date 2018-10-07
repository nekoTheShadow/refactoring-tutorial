package ch12;

import java.util.ArrayList;
import java.util.List;

public class Value {
	private int value = 0;
	private List<ValueListener> listeners = new ArrayList<>();
	
	public Value(int value) {
		this.value = value;
	}
	
	public void setValue(int value) {
		this.value = value;
		notifyToListeners();
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void addValueListener(ValueListener listener) {
		this.listeners.add(listener);
	}
	
	public boolean removeValueListener(ValueListener listener) {
		return listeners.remove(listener);
	}
	
	private void notifyToListeners() {
		this.listeners.forEach(listener -> listener.valueChanged(new ValueChangeEvent(this)));
	}
}
