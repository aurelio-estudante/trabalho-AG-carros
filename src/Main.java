import java.util.ArrayList;

import readFile.Leitor;

public class Main {
    public static void main(String[] args) {
        Leitor ler = new Leitor("/home/aluno/Documentos/trabalho-AG-carros/ag-carros/src/readFile/car.txt");
        int[][] dados = ler.converte();
        for(int i=0; i<6;i++){
            System.out.println(dados[i][1]);
        }
        
    }
}
