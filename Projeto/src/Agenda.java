import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Agenda {
    private JTextField txtfNome;
    private JTextField txtfIdade;
    private JLabel lblNome;
    private JLabel lblIdade;
    private JTextField txtfAltura;
    private JLabel lblAltura;
    private JButton btnSalvar;
    private JButton btnRemove;
    private JButton btnBuscar;
    private JPanel panel;
    private JButton btnImprimirLista;
    private JList lstNome;
    private JList lstData;
    private JList lstAltura;
    private DefaultListModel listaContato = new DefaultListModel();
    private DefaultListModel listaData = new DefaultListModel();
    private DefaultListModel listaAltura = new DefaultListModel();

    public Agenda() {
        Storage armazenamento = new Storage();
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtfNome.getText().isEmpty() || txtfAltura.getText().isEmpty() || txtfIdade.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Dados Incompletos", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    int resp = JOptionPane.showConfirmDialog(null, "Deseja Realmente Cadastrar Contato?", "Cadastro", JOptionPane.YES_NO_OPTION);
                    if (resp == 0 && !(txtfNome.getText().isEmpty()) && !(txtfIdade.getText().isEmpty()) && !(txtfAltura.getText().isEmpty())) {
                        armazenamento.armazenaPessoa(txtfNome.getText(), txtfIdade.getText(), Double.parseDouble(txtfAltura.getText()));
                        txtfNome.setText(null);
                        txtfAltura.setText(null);
                        txtfIdade.setText(null);
                        JOptionPane.showMessageDialog(null, "Dados Salvos!!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtfNome.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Por Favor, Digite o Nome Que Deseja Remover", "Remover", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    int respTw = JOptionPane.showConfirmDialog(null, "Deseja Realmente Remover Contato?", "Remover", JOptionPane.YES_NO_OPTION);
                    if(respTw == 0){
                        armazenamento.removePessoa(txtfNome.getText());
                        txtfNome.setText(null);
                        txtfAltura.setText(null);
                        txtfIdade.setText(null);
                        JOptionPane.showMessageDialog(null,"Contato Removido!!");
                    }
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtfNome.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Por Favor, Digite o Nome Que Deseja Buscar", "Buscar", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    int index = armazenamento.buscaPessoa(txtfNome.getText());
                    if(index != -1){
                        JOptionPane.showMessageDialog(null, "Contato: "+armazenamento.buscaContato(txtfNome.getText())+" Data de nascimento: "+armazenamento.buscaIdade()+" Altura: "+Double.toString(armazenamento.buscaAltura()),"Dados do Contato", JOptionPane.INFORMATION_MESSAGE);
                        txtfNome.setText(null);
                        txtfAltura.setText(null);
                        txtfIdade.setText(null);
                    }else{
                        JOptionPane.showMessageDialog(null, "Contato Inexistente", "Contato", JOptionPane.INFORMATION_MESSAGE);
                    }


                }
            }
        });
        btnImprimirLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lstNome.setVisible(true);
                lstData.setVisible(true);
                lstAltura.setVisible(true);
                //System.out.println(armazenamento.vetorAlturas);

                lstNome.setModel(armazenamento.imprimirContatos());
                lstData.setModel(armazenamento.imprimirDatas());
                lstAltura.setModel(armazenamento.imprimirAlturas());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Agenda");
        frame.setContentPane(new Agenda().panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
