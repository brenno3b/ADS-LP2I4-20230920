import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Calculadora {
    static double sum(Double a, Double b) {
        return a + b;
    }

    static double minus(Double a, Double b) {
        return a - b;
    }

    static double multiply(Double a, Double b) {
        return a * b;
    }

    static double divide(Double a, Double b) {
        return a / b;
    }

    public static void main(String[] args) {
        final JFrame frame = new JFrame("Calculadora");
        frame.setSize(300, 200);

        // Setting up the view section
        final JPanel viewPanel = new JPanel();
        final GridLayout viewLayout = new GridLayout(1, 1);
        viewPanel.setLayout(viewLayout);

        final JTextField viewTextField = new JTextField();
        viewTextField.setHorizontalAlignment(JTextField.RIGHT);
        viewTextField.setText("0");
        viewTextField.setEditable(false);
        viewPanel.add(viewTextField);

        // Setting up the action section
        final JPanel actionPanel = new JPanel();
        final GridLayout actionLayout = new GridLayout(5, 4);
        actionPanel.setLayout(actionLayout);

        final JButton sevenButton = new JButton("7");
        final JButton eightButton = new JButton("8");
        final JButton nineButton = new JButton("9");
        final JButton divisionButton = new JButton("/");
        final JButton fourButton = new JButton("4");
        final JButton fiveButton = new JButton("5");
        final JButton sixButton = new JButton("6");
        final JButton multiplicationButton = new JButton("*");
        final JButton oneButton = new JButton("1");
        final JButton twoButton = new JButton("2");
        final JButton threeButton = new JButton("3");
        final JButton minusButton = new JButton("-");
        final JButton zeroButton = new JButton("0");
        final JButton dotButton = new JButton(".");
        final JButton equalsButton = new JButton("=");
        final JButton sumButton = new JButton("+");
        final JButton clearButton = new JButton("C");

        sevenButton.addActionListener(e -> {
            final String str = viewTextField.getText();

            if (Objects.equals(str, "0")) {
                viewTextField.setText("7");
                return;
            }

            viewTextField.setText(str + "7");
        });

        eightButton.addActionListener(e -> {
            final String str = viewTextField.getText();

            if (Objects.equals(str, "0")) {
                viewTextField.setText("8");
                return;
            }

            viewTextField.setText(str + "8");
        });

        nineButton.addActionListener(e -> {
            final String str = viewTextField.getText();

            if (Objects.equals(str, "0")) {
                viewTextField.setText("9");
                return;
            }

            viewTextField.setText(str + "9");
        });

        divisionButton.addActionListener(e -> {
            final String str = viewTextField.getText();
            final String[] splittedString = str.split(" ");

            if (splittedString.length > 1) return;

            viewTextField.setText(str + " / ");
        });

        fourButton.addActionListener(e -> {
            final String str = viewTextField.getText();

            if (Objects.equals(str, "0")) {
                viewTextField.setText("4");
                return;
            }

            viewTextField.setText(str + "4");
        });

        fiveButton.addActionListener(e -> {
            final String str = viewTextField.getText();

            if (Objects.equals(str, "0")) {
                viewTextField.setText("5");
                return;
            }

            viewTextField.setText(str + "5");
        });

        sixButton.addActionListener(e -> {
            final String str = viewTextField.getText();

            if (Objects.equals(str, "0")) {
                viewTextField.setText("6");
                return;
            }

            viewTextField.setText(str + "6");
        });

        multiplicationButton.addActionListener(e -> {
            final String str = viewTextField.getText();
            final String[] splittedString = str.split(" ");

            if (splittedString.length > 1) return;

            viewTextField.setText(str + " * ");
        });

        oneButton.addActionListener(e -> {
            final String str = viewTextField.getText();

            if (Objects.equals(str, "0")) {
                viewTextField.setText("1");
                return;
            }

            viewTextField.setText(str + "1");
        });

        twoButton.addActionListener(e -> {
            final String str = viewTextField.getText();

            if (Objects.equals(str, "0")) {
                viewTextField.setText("2");
                return;
            }

            viewTextField.setText(str + "2");
        });

        threeButton.addActionListener(e -> {
            final String str = viewTextField.getText();

            if (Objects.equals(str, "0")) {
                viewTextField.setText("3");
                return;
            }

            viewTextField.setText(str + "3");
        });

        minusButton.addActionListener(e -> {
            final String str = viewTextField.getText();
            final String[] splittedString = str.split(" ");

            if (splittedString.length > 1) return;

            viewTextField.setText(str + " - ");
        });

        zeroButton.addActionListener(e -> {
            final String str = viewTextField.getText();

            if (Objects.equals(str, "0")) return;

            viewTextField.setText(str + "0");
        });

        equalsButton.addActionListener(e -> {
            final String str = viewTextField.getText();

            if (str.length() == 0) return;

            final String[] splittedString = str.split(" ");

            if (splittedString.length < 2) return;

            final String a = splittedString[0];
            final String operator = splittedString[1];
            String b = null;

            if (splittedString.length == 3) b = splittedString[2];

            Double result;

            switch (operator) {
                case "+":
                    result = sum(
                            Double.parseDouble(a),
                            Double.parseDouble(b == null ? a : b)
                    );
                    break;
                case "-":
                    result = minus(
                            Double.parseDouble(a),
                            Double.parseDouble(b == null ? a : b)
                    );
                    break;
                case "*":
                    result = multiply(
                            Double.parseDouble(a),
                            Double.parseDouble(b == null ? a : b)
                    );
                    break;
                case "/":
                    result = divide(
                            Double.parseDouble(a),
                            Double.parseDouble(b == null ? a : b)
                    );
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + operator);
            }

            viewTextField.setText(result.toString());
        });

        sumButton.addActionListener(e -> {
            final String str = viewTextField.getText();
            final String[] splittedString = str.split(" ");

            if (splittedString.length > 1) return;

            viewTextField.setText(str + " + ");
        });

        clearButton.addActionListener(e -> {
            viewTextField.setText("0");
        });

        actionPanel.add(sevenButton);
        actionPanel.add(eightButton);
        actionPanel.add(nineButton);
        actionPanel.add(divisionButton);
        actionPanel.add(fourButton);
        actionPanel.add(fiveButton);
        actionPanel.add(sixButton);
        actionPanel.add(multiplicationButton);
        actionPanel.add(oneButton);
        actionPanel.add(twoButton);
        actionPanel.add(threeButton);
        actionPanel.add(minusButton);
        actionPanel.add(zeroButton);
        actionPanel.add(dotButton);
        actionPanel.add(equalsButton);
        actionPanel.add(sumButton);
        actionPanel.add(clearButton);

        frame.add(viewPanel, BorderLayout.NORTH);
        frame.add(actionPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}