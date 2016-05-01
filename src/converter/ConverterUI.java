package converter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * GUI of unit converter
 * 
 * @author Wisarut Boonnumma
 *
 */
public class ConverterUI extends JFrame implements Runnable {

	private JButton convertButton;
	private UnitConverter unitconverter;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem itemExit;
	private JTextField leftTextField;
	private JTextField rightTextField;
	private JComboBox<Unit> leftComboBox;
	private JComboBox<Unit> rightComboBox;
	private JButton btnClear;
	private UnitType utype;

	public ConverterUI(UnitConverter uc) {
		this.unitconverter = uc;
		this.setTitle("Length Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		utype = UnitType.LENGTH;
		initComponents();
	}

	/**
	 * initialize components in the window
	 */
	private void initComponents() {
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());

		leftTextField = new JTextField();
		leftTextField.setBounds(10, 11, 86, 20);
		contentPane.add(leftTextField);
		leftTextField.setColumns(10);
		leftTextField.addActionListener(new convertButtonListenerLeftToRight());

		leftComboBox = new JComboBox<Unit>(unitconverter.getUnits(utype));
		contentPane.add(leftComboBox);

		JLabel label = new JLabel("=");
		contentPane.add(label);

		rightTextField = new JTextField();
		contentPane.add(rightTextField);
		rightTextField
				.addActionListener(new convertButtonListenerRighttoLeft());
		rightTextField.setColumns(10);

		rightComboBox = new JComboBox<Unit>(unitconverter.getUnits(utype));
		contentPane.add(rightComboBox);

		convertButton = new JButton("Convert!");
		convertButton.addActionListener(new convertButtonListenerLeftToRight());
		contentPane.add(convertButton);

		btnClear = new JButton("Clear");
		btnClear.addActionListener(new clearButtonListener());
		contentPane.add(btnClear);

		menuBar = new JMenuBar();

		menu = makeMenu();
		menuBar.add(menu);

		menu.addSeparator();
		itemExit = new JMenuItem("Exit");
		itemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});
		menu.add(itemExit);

		this.setJMenuBar(menuBar);
		this.add(contentPane, BorderLayout.CENTER);
		this.pack();

	}

	/**
	 * UnitAction is an ActionListener that perform when the menu is pressed It
	 * is an inner class so it can access private attributes of ConverterUI. It
	 * change ComboBox to unit that selected.
	 */
	class UnitAction implements ActionListener {
		private UnitType utype;

		/**
		 * Constructor of this class
		 * 
		 * @param utype
		 */
		UnitAction(UnitType utype) {
			this.utype = utype;
		}

		public void actionPerformed(ActionEvent e) {
			leftComboBox.removeAllItems();
			rightComboBox.removeAllItems();
			Unit[] units = unitconverter.getUnits(utype);
			for (Unit u : units) {
				leftComboBox.addItem(u);
				rightComboBox.addItem(u);
			}
			rightTextField.setText("");
			leftTextField.setText("");
		}

	}

	/**
	 * create menu from type of unit
	 * 
	 * @return menu
	 */
	private JMenu makeMenu() {
		JMenu menu = new JMenu("Unit Type");
		UnitType[] unitTypes = UnitFactory.getInstance().getUnitTypes();
		for (UnitType utype : unitTypes) {
			JMenuItem menuItem = new JMenuItem(utype.toString());
			menuItem.addActionListener(new UnitAction(utype));
			menu.add(menuItem);
		}
		return menu;
	}

	/**
	 * CleatButtonListener is an ActionListener that performs an action when the
	 * button is pressed. It is an inner class so it can access private
	 * attributes of ConverterUI. It set text field to empty
	 */
	class clearButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			rightTextField.setText("");
			leftTextField.setText("");
		}
	}

	/**
	 * ConvertButtonListenerLeftToRight is an ActionListener that performs an
	 * action when the button or text field is pressed. It is an inner class so
	 * it can access private attributes of ConverterUI. It reads the text from
	 * JTextField, convert the value to a number, unitconverter to convert, and
	 * write result in other text field.
	 */
	class convertButtonListenerLeftToRight implements ActionListener {
		/** The action to perform action when the "convert" button is pressed */
		public void actionPerformed(ActionEvent evt) {
			String s = leftTextField.getText().trim();
			try {
				if (s.length() > 0) {
					leftTextField.setForeground(Color.black);
					rightTextField.setForeground(Color.black);
					double value = Double.valueOf(s);
					Unit unit1 = (Unit) leftComboBox.getSelectedItem();
					Unit unit2 = (Unit) rightComboBox.getSelectedItem();
					rightTextField.setText(String.valueOf(String.format("%.5g",
							(unitconverter.convert(value, unit1, unit2)))));
				}
			} catch (NumberFormatException e) {
				leftTextField.setForeground(Color.red);
				rightTextField.setForeground(Color.red);
			} catch (NullPointerException e) {
				leftTextField.setForeground(Color.red);
				rightTextField.setForeground(Color.red);
			}
		}
	}

	/**
	 * ConvertButtonListenerRightToLeft is an ActionListener that performs an
	 * action when the button or text field is pressed. It is an inner class so
	 * it can access private attributes of ConverterUI. It reads the text from
	 * JTextField, convert the value to a number, unitconverter to convert, and
	 * write result in other text field.
	 */
	class convertButtonListenerRighttoLeft implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = rightTextField.getText().trim();
			try {
				if (s.length() > 0) {
					leftTextField.setForeground(Color.black);
					rightTextField.setForeground(Color.black);
					double value = Double.valueOf(s);
					Unit unit1 = (Unit) leftComboBox.getSelectedItem();
					Unit unit2 = (Unit) rightComboBox.getSelectedItem();
					leftTextField.setText(String.valueOf(String.format("%.5g",
							(unitconverter.convert(value, unit2, unit1)))));
				}
			} catch (NumberFormatException error) {
				leftTextField.setForeground(Color.red);
				rightTextField.setForeground(Color.red);
			} catch (NullPointerException error) {
				leftTextField.setForeground(Color.red);
				rightTextField.setForeground(Color.red);
			}

		}

	}

	/**
	 * run this user interface
	 */
	public void run() {
		this.setVisible(true);

	}

}
