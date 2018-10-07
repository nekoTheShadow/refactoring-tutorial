package ch12;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Map;

public class IntegerDisplay extends Frame implements ActionListener, ValueListener{
	private static final long serialVersionUID = 1L;
	private Label octalLabel = new Label("0");
	private Label decimalLabel = new Label("0");
	private Label hexadecimalLabel = new Label("0");
	private Button incrementButton = new Button("+");
	private Button decrementButton = new Button("-");
	private Value value = new Value(0);
	
	private Graph graphCircle = Graph.createGraph(GraphType.Circle, 100, 100);
	private Graph graphRectangle = Graph.createGraph(GraphType.Rectangle, 100, 50);
	
	public IntegerDisplay() {
		super("IntegerDisplay");
		
		var labels = Map.of(
			"Octal", octalLabel,
			"Decimal", decimalLabel,
			"Hexadecimal", hexadecimalLabel
		);
		var buttons = List.of(incrementButton, decrementButton);
		var graphs = Map.of(
			graphCircle, BorderLayout.CENTER, 
			graphRectangle, BorderLayout.SOUTH
		);
		
		setLayout(new BorderLayout());
		
		var panel = new Panel(new GridLayout(4, 2));
		labels.forEach((name, label) -> {
			panel.add(new Label(name + ":"));
			panel.add(label);
		});
		buttons.forEach(panel::add);
		
		add(panel, BorderLayout.NORTH);
		graphs.forEach(this::add);
		
		
		buttons.forEach(button -> button.addActionListener(this));
		value.addValueListener(this);
		value.addValueListener(graphCircle);
		value.addValueListener(graphRectangle);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		pack();
		setVisible(true);
	}

	@Override
	public void valueChanged(ValueChangeEvent e) {
		if (e.getSource() == value) {
			octalLabel.setText(Integer.toString(value.getValue(), 8));
			decimalLabel.setText(Integer.toString(value.getValue(), 10));
			hexadecimalLabel.setText(Integer.toString(value.getValue(), 16));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		var source = e.getSource();
		if (source == incrementButton) {
			setValue(value.getValue() + 1);
		}
		if (source == decrementButton) {
			setValue(value.getValue() - 1);
		}
	}
	
	public int getValue() {
		return value.getValue();
	}
	
	public void setValue(int value) {
		this.value.setValue(value);
	}
}
