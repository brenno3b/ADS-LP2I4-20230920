import javax.swing.*;
import java.awt.*;

public class Form2 {
    private static Pessoa umaPessoa = new Pessoa();
    public static void main(String[] args) {
        final JFrame frame = new JFrame("TP02 - LP2I4");
        frame.setSize(400,250);

        final JPanel inputPanel = new JPanel();
        final GridLayout inputLayout = new GridLayout(4, 2, 10, 10);
        inputPanel.setLayout(inputLayout);

        final JTextField numeroTextField = new JTextField();
        final JTextField nomeTextField = new JTextField();

        String[] sexOptions = {"F", "M"};

        final JComboBox sexoComboBox = new JComboBox(sexOptions);
        sexoComboBox.setEditable(false);
        final JTextField idadeTextField = new JTextField();

        inputPanel.add(new JLabel("Número: "));
        inputPanel.add(numeroTextField);
        numeroTextField.setEditable(false);

        inputPanel.add(new JLabel("Nome: "));
        inputPanel.add(nomeTextField);
        inputPanel.add(new JLabel("Sexo: "));
        inputPanel.add(sexoComboBox);
        inputPanel.add(new JLabel("Idade: "));
        inputPanel.add(idadeTextField);

        final JPanel actionPanel = new JPanel();
        final GridLayout actionLayout = new GridLayout(1, 4, 10, 10);
        actionPanel.setLayout(actionLayout);

        final JButton okButton = new JButton("Ok");
        final JButton limparButton = new JButton("Limpar");
        final JButton mostrarButton = new JButton("Mostrar");
        final JButton sairButton = new JButton("Sair");

        okButton.addActionListener(e -> {
            final String nome = nomeTextField.getText();

            if (nome.length() < 3) {
                JOptionPane.showMessageDialog(frame, "O campo nome deve conter 3 ou mais caracteres.");
                return;
            }

            final String sexo = (String) sexoComboBox.getSelectedItem();

            if (sexo == null || sexo.length() == 0) {
                JOptionPane.showMessageDialog(frame, "O campo sexo é obrigatório.");
                return;
            }

            if (!sexo.equalsIgnoreCase("M") && !sexo.equalsIgnoreCase("F")) {
                JOptionPane.showMessageDialog(frame, "O campo sexo deve ser 'M' ou 'F'");
                return;
            }

            final String idadeStr = idadeTextField.getText();

            try {
                Integer.parseInt(idadeStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "O campo idade não é um número.");
                return;
            }

            final int idade = Integer.parseInt(idadeStr);

            if (idade < 0 || idade > 122) {
                JOptionPane.showMessageDialog(frame, "Idade inválida");
                return;
            }

            umaPessoa = new Pessoa(nome, sexo.charAt(0), idade);
        });

        limparButton.addActionListener(e -> {
            numeroTextField.setText("");
            nomeTextField.setText("");
            sexoComboBox.setSelectedIndex(0);
            idadeTextField.setText("");
        });

        mostrarButton.addActionListener(e -> {
            final String kp = String.valueOf(umaPessoa.getKp());
            final String nome = umaPessoa.getNome();
            final String sexo = String.valueOf(umaPessoa.getSexo());
            final String idade = String.valueOf(umaPessoa.getIdade());

            numeroTextField.setText(kp);
            nomeTextField.setText(nome);
            sexoComboBox.setSelectedItem(sexo);
            idadeTextField.setText(idade);
        });

        sairButton.addActionListener(e -> {
            frame.dispose();
            System.exit(0);
        });

        actionPanel.add(okButton);
        actionPanel.add(limparButton);
        actionPanel.add(mostrarButton);
        actionPanel.add(sairButton);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(actionPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}