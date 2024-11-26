import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Cadastro_de_Contatos {
    private JPanel panelMain;
    private JTextField txtnome;
    private JTextField txttelefone;
    private JTextField txtemail;
    private JButton btnadicionarcontato;
    private JButton btnlimpar;
    private JList<String> liscontatos; // Defina a JList com tipo genérico String
    private JLabel lblnomes;
    private JLabel lbltelefone;
    private JLabel lblemail;
    private JTextArea txtAstatus;

    private String nomes = "";
    private String telefones = "";
    private String email = "";
    private String informacoes = ""; // Variável que armazena nome, telefone e email
    private ArrayList<String> contatos = new ArrayList<>(); // ArrayList de String
    private int i = 0;

    // Definição do modelo da lista para permitir manipulação de dados na JList
    DefaultListModel<String> contatinhos = new DefaultListModel<>();

    public Cadastro_de_Contatos() {
        liscontatos.setModel(contatinhos);

        // Adicionar novo contato
        btnadicionarcontato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obter os dados dos campos de texto
                nomes = txtnome.getText();
                telefones = txttelefone.getText();
                email = txtemail.getText();

                // Verifica se os campos não estão vazios
                if (nomes.isEmpty() || telefones.isEmpty() || email.isEmpty()) {
                    txtAstatus.setText("Preencha todos os campos acima");
                } else {
                    i++;
                    informacoes = i + "° Contato - Nome: " + nomes + ", Telefone: " + telefones + ", E-mail: " + email;
                    contatos.add(informacoes); // Adiciona o contato à lista de contatos
                    contatinhos.addElement(informacoes); // Adiciona o contato à JList
                    // Limpar os campos de texto após adicionar o contato
                    txtnome.setText("");
                    txttelefone.setText("");
                    txtemail.setText("");
                }
            }
        });

        // Remover contato
        btnlimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obter o índice do contato selecionado
                int excluir = liscontatos.getSelectedIndex();
                if (excluir != -1) { // Se um item foi selecionado
                    contatos.remove(excluir); // Remove da lista de contatos
                    contatinhos.removeElementAt(excluir); // Remove da JList pelo índice
                    txtAstatus.setText("Contato removido com sucesso!");
                } else {
                    txtAstatus.setText("Selecione um contato para remover.");
                }
            }
        });
    }

    public static void main(String[] args) {
        // Iniciar a interface gráfica
        JFrame frame = new JFrame("Cadastro de Contatos");
        frame.setContentPane(new Cadastro_de_Contatos().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
