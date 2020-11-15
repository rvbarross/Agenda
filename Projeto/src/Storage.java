import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Storage {
    private ArrayList<String> nomes = new ArrayList<>();
    private ArrayList<String> idade = new ArrayList<>();
    private ArrayList<Double> altura = new ArrayList<>();
    private DefaultListModel listaContato = new DefaultListModel();
    private DefaultListModel listaData = new DefaultListModel();
    private DefaultListModel listaAltura = new DefaultListModel();
    private int idadeIndex;
    private int alturaIndex;
    String[] vetorContatos;
    String[] vetorAlturas;
    String[] vetorDatas;


    public void armazenaPessoa(String nome, String idade, double altura) {
        this.nomes.add(nome);
        this.idade.add(idade);
        this.altura.add(altura);
    }

    public void removePessoa(String nome){
       int indice = this.buscaPessoa(nome);
       if(indice != -1){
           this.nomes.remove(nome);
           this.idade.remove(indice);
           this.altura.remove(indice);
       }
    }

    public int buscaPessoa(String nome){
        int index = this.nomes.indexOf(nome);
            return index;
    }

    public String buscaContato(String nome){
        int indice = this.nomes.indexOf(nome);
        String contato = this.nomes.get(indice);
        idadeIndex = indice;
        alturaIndex = indice;
        return contato;
    }

    public String buscaIdade(){
        System.out.println(idadeIndex);
        String idadeContato = this.idade.get(idadeIndex);
        return idadeContato;
    }

    public double buscaAltura(){
        System.out.println(alturaIndex);
        double alturaContato = this.altura.get(alturaIndex);
        return alturaContato;
    }

    public DefaultListModel imprimirContatos(){
        listaContato.removeAllElements();
        for(int i = 0; i < this.nomes.size(); i++){
            listaContato.addElement(this.nomes.get(i));
        }
        return listaContato;
    }

    public DefaultListModel imprimirAlturas(){
        listaAltura.removeAllElements();
        for(int i = 0; i < this.altura.size(); i++){
            listaAltura.addElement(this.altura.get(i));
        }
        return listaAltura;
    }

    public DefaultListModel imprimirDatas(){
        listaData.removeAllElements();
        for(int i = 0; i < this.idade.size(); i++){
            listaData.addElement(this.idade.get(i));
        }
        return listaData;
    }


}
