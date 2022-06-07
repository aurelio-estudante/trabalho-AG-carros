package readFile;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Leitor {
    String arquivo = "";
    public Leitor(String arquivo) {
        this.arquivo = arquivo;
    }

    public ArrayList lerArquivo(){
        ArrayList dados = new ArrayList<String>();
        try {
            File carros = new File(this.arquivo);
            Scanner leitor = new Scanner(carros);
            while(leitor.hasNextLine()){
                dados.add(leitor.nextLine());
            }
            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return dados;
    }
    public int[][] converte(){
        ArrayList<String> dados = lerArquivo();
        int numLinhas = dados.size();
        int[][] dadosConvertidos = new int[6][numLinhas];
        for(int i=0; i<numLinhas;i++){
            String[] partes = dados.get(i).split(",");
            for(int j=0;j<6;j++){
                switch (j) {
                    case 0:
                        if(partes[j] == "vhigh"){
                            dadosConvertidos[j][i] = 1;
                        }else if(partes[j] == "high"){
                            dadosConvertidos[j][i] = 2;
                        }else if(partes[j] == "med"){
                            dadosConvertidos[j][i] = 3;
                        }else if(partes[j] == "low"){
                            dadosConvertidos[j][i] = 4;
                        }
                        break;
                    case 1:
                        if(partes[j] == "vhigh"){
                            dadosConvertidos[j][i] = 1;
                        }else if(partes[j] == "high"){
                            dadosConvertidos[j][i] = 2;
                        }else if(partes[j] == "med"){
                            dadosConvertidos[j][i] = 3;
                        }else if(partes[j] == "low"){
                            dadosConvertidos[j][i] = 4;
                        }
                        break;
                    case 2:
                        if(partes[j] == "2"){
                            dadosConvertidos[j][i] = 1;
                        }else if(partes[j] == "3"){
                            dadosConvertidos[j][i] = 2;
                        }else if(partes[j] == "4"){
                            dadosConvertidos[j][i] = 3;
                        }else if(partes[j] == "5-more"){
                            dadosConvertidos[j][i] = 4;
                        }
                        break;
                    case 3:
                        if(partes[j] == "2"){
                            dadosConvertidos[j][i] = 1;
                        }else if(partes[j] == "4"){
                            dadosConvertidos[j][i] = 2;
                        }else if(partes[j] == "more"){
                            dadosConvertidos[j][i] = 3;
                        }
                        break;
                    case 4:
                        if(partes[j] == "small"){
                            dadosConvertidos[j][i] = 1;
                        }else if(partes[j] == "med"){
                            dadosConvertidos[j][i] = 2;
                        }else if(partes[j] == "big"){
                            dadosConvertidos[j][i] = 3;
                        }
                        break;
                    case 5:
                        if(partes[j] == "low"){
                            dadosConvertidos[j][i] = 1;
                        }else if(partes[j] == "med"){
                            dadosConvertidos[j][i] = 2;
                        }else if(partes[j] == "high"){
                            dadosConvertidos[j][i] = 3;
                        }
                        break;
                }
            }
        }
        return dadosConvertidos;
    }
}