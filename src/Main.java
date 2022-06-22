import java.util.ArrayList;

import dump.DumpToFile;
import readFile.Leitor;

public class Main {
    public static void main(String[] args) {
        String lerFrom = "src/readFile/car.txt";
        Leitor ler = new Leitor(lerFrom);
        int[][] dados = ler.geraPop();
        int[][] aptitude = ler.aptitudeCalc(dados);
        for(int i=0;i<dados.length;i++){
            System.out.print("Gene: ");
            for(int j=0; j<dados[i].length;j++){
                System.out.print(dados[i][j]);
            }
            System.out.print(" Aptitude: "+aptitude[i][0]);
            if(aptitude[i][0]<27){
                System.out.print(" Tipo: Ruim");
            }else{
                System.out.print(" Tipo: Bao");
            }
            System.out.println();
        }
        
        //DumpToFile dump = new DumpToFile("/home/aluno/Documentos/trabalho-AG-carros/ag-carros/src/dump", lerFrom, "dump1.csv");
    }
}
