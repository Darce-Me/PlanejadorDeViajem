package planejadorviagem;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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

            verificacaoEs(escolha);

        } while (escolha == 0);
    }

    public static void verificacaoEs(int escolha) {
        if (escolha == 0) {
            planejar();
        } else {
            JOptionPane.showMessageDialog(null, "Tenha um bom dia!");
        }
    }

    public static void planejar() {

        String nome = JOptionPane.showInputDialog("Digite seu nome: ");
        String dataStr = JOptionPane.showInputDialog("Data(dd/MM/yyyy)");
        String diasStr = JOptionPane.showInputDialog("Quantos dias a viagem vai durar: ");
        String valorStr = JOptionPane.showInputDialog("Valor da diária: ");
        
        if (nome.isEmpty() || dataStr.isEmpty() || diasStr.isEmpty() || valorStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            return;
        }

        LocalDate data = formatoData(dataStr);

        if (data == null) {
            return;
        }

        double total = calculoConversao(diasStr, valorStr);

        String situacao = verificarSituacao(LocalDate.now(), data);

        exibir(nome, dataStr, total, situacao);

    }

    public static LocalDate formatoData(String dataStr) {

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(dataStr, formatter);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data inválida!");
            return null;
        }
    }

    public static String verificarSituacao(LocalDate hoje, LocalDate dataViagem) {

        if (dataViagem.isBefore(hoje)) {
            return "Viagem passada";
        } else if (dataViagem.isEqual(hoje)) {
            return "Viagem é hoje!";
        } else {
            long diasRestantes = ChronoUnit.DAYS.between(hoje, dataViagem);
            return "Viagem futura\nFaltam " + diasRestantes + " dias";
        }
    }

    public static double calculoConversao(String diasStr, String valorStr) {
        try {
            int dias = Integer.parseInt(diasStr);
            double valorPorDia = Double.parseDouble(valorStr);

            if (dias <= 0 || valorPorDia < 0) {
                JOptionPane.showMessageDialog(null, "Valores não podem ser negativos!");
                return 0;
            }

            double total = dias * valorPorDia;

            return total;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite um número válido!");
            return 0;
        }

    }

    public static void exibir(String nome, String dataStr, double total, String situacao) {
        JOptionPane.showMessageDialog(null,
                nome + ", sua viagem será em " + dataStr
                + "\nTotal estimado: R$ " + total
                + "\nSituação: " + situacao);
    }

}
