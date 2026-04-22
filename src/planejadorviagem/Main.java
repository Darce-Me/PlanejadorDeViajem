package planejadorviagem;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        menuInicial();

    }

    public static void menuInicial() {
        int escolha;
        do {
            String[] opcoes = {"Planejar", "Sair"};
            escolha = JOptionPane.showOptionDialog(null, "Escolha: ", "Início", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
            System.out.println(escolha);

            verificacao(escolha);
        }while(escolha == 0);
    }

    public static void verificacao(int escolha) {
        if (escolha == 0) {
            planejar();
        } else {
            JOptionPane.showMessageDialog(null, "Tenha um bom dia!");
        }
    }

    public static void planejar() {

        String nome = JOptionPane.showInputDialog("Digite seu nome: ");

        String data = JOptionPane.showInputDialog("Data da viagem(dd-MM-yyyy): ");

        String qtd = JOptionPane.showInputDialog("Quantos dias a viagem vai durar: ");
        int qtdDias = Integer.parseInt(qtd);

        String preco = JOptionPane.showInputDialog("Valor da diária: ");
        double valor = Double.parseDouble(preco);

    }

}
