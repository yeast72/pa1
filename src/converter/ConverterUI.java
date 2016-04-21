package converter;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConverterUI extends JFrame {

	private JButton convertButton;
	private UnitConverter unitconverter;
	private Unit converter;

	private JTextField LeftTextField;
	private JTextField RightTextField;
	private JComboBox LeftComboBox;
	private JComboBox RightComboBox;
	private JButton btnClear;
	private JRadioButton radiobtnLeft;
	private JRadioButton radiobtnRight;
	
	public ConverterUI(UnitConverter uc) {
		this.unitconverter = uc;

		this.setTitle("Length Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		initComponents();
	}

	private void initComponents() {
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());

		LeftTextField = new JTextField();
		LeftTextField.setBounds(10, 11, 86, 20);
		contentPane.add(LeftTextField);
		LeftTextField.setColumns(10);
		LeftTextField.addActionListener(new ConvertButtonListener());


		LeftComboBox = new JComboBox(Length.values());
		contentPane.add(LeftComboBox);

		JLabel label = new JLabel("=");
		contentPane.add(label);

		RightTextField = new JTextField();
		contentPane.add(RightTextField);
		RightTextField.addActionListener(new ConvertButtonListener());
		RightTextField.setColumns(10);
		RightTextField.setEditable(false);

		RightComboBox = new JComboBox(Length.values());
		RightComboBox.addActionListener(new ConvertButtonListener());
		contentPane.add(RightComboBox);

		convertButton = new JButton("Convert!");
		convertButton.addActionListener(new ConvertButtonListener());
		contentPane.add(convertButton);

		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ClearButtonListener());
		contentPane.add(btnClear);

		JPanel contentPaneSount = new JPanel();
		contentPaneSount.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPaneSount.setLayout(new FlowLayout());

		radiobtnLeft = new JRadioButton("Left->Right");
		radiobtnLeft.addActionListener(new LeftRightRadioButtonListener());
		contentPaneSount.add(radiobtnLeft);

		radiobtnRight = new JRadioButton("Right->Left");
		radiobtnRight.addActionListener(new RightLeftRadioButtonListener());
		contentPaneSount.add(radiobtnRight);
		this.add(contentPane, BorderLayout.CENTER);
		this.add(contentPaneSount, BorderLayout.SOUTH);
		this.pack();
	}
	class LeftRightRadioButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			LeftTextField.setEditable(true);
			RightTextField.setEditable(false);
			radiobtnLeft.setSelected(true);
			radiobtnRight.setSelected(false);
		}
		
	}
	
	class RightLeftRadioButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			LeftTextField.setEditable(false);
			RightTextField.setEditable(true);
			radiobtnLeft.setSelected(false);
			radiobtnRight.setSelected(true);
		}
		
	}
	class ClearButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evt) {
			RightTextField.setText("");
			LeftTextField.setText("");
		}	
	}

	class ConvertButtonListener implements ActionListener, KeyListener {

		public void actionPerformed(ActionEvent evt) {
			String s = "";
			if(LeftTextField.isEditable())
				s = LeftTextField.getText().trim();
			else if(RightTextField.isEditable())
				s = RightTextField.getText().trim();
			System.out.println("actionPerformed: input= " + s);
			if (s.length() > 0) {
				double value = Double.valueOf(s);
				Length unit1 = (Length) LeftComboBox.getSelectedItem();
				Length unit2 = (Length) RightComboBox.getSelectedItem();
				if(LeftTextField.isEditable())
					RightTextField.setText(String.valueOf(String.format("%.6f", (unitconverter.convert(value,unit1, unit2)))));
				else if(RightTextField.isEditable())
					LeftTextField.setText(String.valueOf(String.format("%.6f", (unitconverter.convert(value, unit2, unit1)))));
			}
		}

		public void keyPressed(KeyEvent e) {
			String s = "";
			if(LeftTextField.isEditable())
				s = LeftTextField.getText().trim();
			else if(RightTextField.isEditable())
				s = RightTextField.getText().trim();
			System.out.println("actionPerformed: input= " + s);
			if (s.length() > 0) {
				double value = Double.valueOf(s);
				Length unit1 = (Length) LeftComboBox.getSelectedItem();
				Length unit2 = (Length) RightComboBox.getSelectedItem();
				if(LeftTextField.isEditable())
					RightTextField.setText(String.valueOf(String.format("%.6f", (unitconverter.convert(value,unit1, unit2)))));
				else if(RightTextField.isEditable())
					LeftTextField.setText(String.valueOf(String.format("%.6f", (unitconverter.convert(value, unit2, unit1)))));
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

	public static void main(String[] args) {
		UnitConverter uc = new UnitConverter();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterUI frame = new ConverterUI(uc);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
