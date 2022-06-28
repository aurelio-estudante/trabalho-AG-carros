import java.util.ArrayList;

import dump.DumpToFile;
import readFile.Gene;
import readFile.Leitor;

public class Main {
    public static void main(String[] args) {
        String lerFrom = "src/readFile/car.txt";
        Leitor ler = new Leitor(lerFrom);
        int[][] dados = ler.geraPop();
        ArrayList<Gene> aptitude = ler.aptitudeCalc(dados);
        Gene best = ler.getBest(aptitude);     
        for (Gene gene : aptitude) {
            System.out.println(gene);
        }
        System.out.println("Melhor Gene - "+best);
        //DumpToFile dump = new DumpToFile("/home/aluno/Documentos/trabalho-AG-carros/ag-carros/src/dump", lerFrom, "dump1.csv");
    }
}
