import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vue {
    private JFrame frame;
    private Compte compte;

    private JLabel soldeLabel;
    private JTextArea operationsTextArea;
    private JTextField intituleField;
    private JTextField montantField;
    private JButton depositButton;
    private JButton withdrawButton;

    public Vue() {
        frame = new JFrame("Compte Bancaire");
        compte = new Compte();

        soldeLabel = new JLabel("Solde: " + compte.getSolde() + "€");
        operationsTextArea = new JTextArea(10, 30);
        operationsTextArea.setEditable(false);

        intituleField = new JTextField(15);
        montantField = new JTextField(10);

        depositButton = new JButton("Crédit");
        withdrawButton = new JButton("Débit");

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String intitule = intituleField.getText();
                double montant = Double.parseDouble(montantField.getText());
                compte.soldeUp(intitule, montant);
                soldeLabel.setText("Solde: " + compte.getSolde() + "€");
                updateOperationsTextArea();
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String intitule = intituleField.getText();
                double montant = Double.parseDouble(montantField.getText());
                compte.soldeDown(intitule, montant);
                soldeLabel.setText("Solde: " + compte.getSolde() + "€");
                updateOperationsTextArea();
            }
        });

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(soldeLabel);
        panel.add(new JScrollPane(operationsTextArea));
        panel.add(new JLabel("Intitulé:"));
        panel.add(intituleField);
        panel.add(new JLabel("Montant:"));
        panel.add(montantField);
        panel.add(depositButton);
        panel.add(withdrawButton);

        frame.add(panel);
        frame.setSize(1500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void updateOperationsTextArea() {
        operationsTextArea.setText(compte.getOperations());
        operationsTextArea.setCaretPosition(0); // Scroll to the top
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Vue();
            }
        });
    }
}
