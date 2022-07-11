package ui;//пакет интерфейса пользователя

import javax.swing.*;
import java.awt.event.*;

import library.*;
import simulator.Simulator;

public class Graphic extends JPanel implements ActionListener { // графический интерфейс пользователя
    private JTextField textField = null;
    private JTextField textField0 = null;
    JTextField textField1 = null;
    JComboBox<String> comboBox = null;
    JFrame frame = null;

    public Graphic() {// конструктор
        frame = new JFrame("ENIGMA");
        JLabel label = new JLabel("TEXT");
        label.setBounds(10, 10, 610, 20);
        textField = new JTextField();
        textField.setBounds(10, 30, 610, 20);
        JLabel label0 = new JLabel("KEY");
        label0.setBounds(10, 80, 200, 20);
        textField0 = new JTextField();
        textField0.setBounds(10, 100, 200, 20);
        JLabel label1 = new JLabel("TRANSFORMATION");
        label1.setBounds(215, 80, 200, 20);
        String[] string = { "ENCODING", "DECODING" };
        comboBox = new JComboBox<>(string);
        comboBox.setBounds(215, 100, 200, 20);
        JButton button = new JButton("KEY GENERATION");
        button.setBounds(420, 100, 200, 20);
        button.setActionCommand("keyGeneration");
        button.addActionListener(this);
        JButton button0 = new JButton("CALCULATE");
        button0.setBounds(420, 160, 200, 20);
        button0.setActionCommand("calculate");
        button0.addActionListener(this);
        JLabel label2 = new JLabel("CONVERTED TEXT");
        label2.setBounds(10, 140, 610, 20);
        textField1 = new JTextField();
        textField1.setBounds(10, 160, 405, 20);
        frame.add(label);
        frame.add(textField);
        frame.add(label0);
        frame.add(textField0);
        frame.add(label1);
        frame.add(comboBox);
        frame.add(button);
        frame.add(button0);
        frame.add(label2);
        frame.add(textField1);
        frame.setSize(640, 480);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void keyGeneration() {// генерация ключа
        textField0.setText(Key.generate());

    }

    private boolean calculate() {// механихм вычесления
        String message = textField.getText();
        String code = (String) (comboBox.getSelectedItem());
        String key = textField0.getText();
        try {
            if (!Message.check(message) && !Key.check(key)) {
                JOptionPane.showMessageDialog(frame, "INCORRECT MESSAGE AND KEY");
                return false;
            }
            if (!Message.check(message)) {
                JOptionPane.showMessageDialog(frame, "INCORRECT MESSAGE");
                return false;
            }
            if (!Key.check(key)) {
                JOptionPane.showMessageDialog(frame, "INCORRECT KEY");
                return false;
            }
            if (code.equals("ENCODING")) {
                textField1.setText(Simulator.encoder(message, key));
            } else {
                textField1.setText(Simulator.decoder(message, key));
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            JOptionPane.showMessageDialog(frame, "EMPTY MESSAGE OR KEY");
        }
        return true;
    }

    public void actionPerformed(ActionEvent event) {// механизм работы кнопок
        if ("keyGeneration".equals(event.getActionCommand())) {
            keyGeneration();
        } else

        {
            calculate();
        }
    }
}
