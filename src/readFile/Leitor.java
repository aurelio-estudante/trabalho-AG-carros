package readFile;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
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
        int[][] dadosConvertidos = new int[numLinhas][6];
        for(int i=0; i<numLinhas;i++){
            String[] partes = dados.get(i).split(",");
            for(int j=0;j<6;j++){
                partes[j].replaceAll("\\s+","");   
                switch (j) {
                    case 0:
                        if(partes[j].equals("vhigh")){
                            dadosConvertidos[i][j] = 1;
                        }else if(partes[j].equals("high")){
                            dadosConvertidos[i][j] = 2;
                        }else if(partes[j].equals("med")){
                            dadosConvertidos[i][j] = 3;
                        }else if(partes[j].equals("low")){
                            dadosConvertidos[i][j] = 4;
                        }
                        break;
                    case 1:
                        if(partes[j].equals("vhigh")){
                            dadosConvertidos[i][j] = 1;
                        }else if(partes[j].equals("high")){
                            dadosConvertidos[i][j] = 2;
                        }else if(partes[j].equals("med")){
                            dadosConvertidos[i][j] = 3;
                        }else if(partes[j].equals("low")){
                            dadosConvertidos[i][j] = 4;
                        }
                        break;
                    case 2:
                        if(partes[j].equals("2")){
                            dadosConvertidos[i][j] = 1;
                        }else if(partes[j].equals("3")){
                            dadosConvertidos[i][j] = 2;
                        }else if(partes[j].equals("4")){
                            dadosConvertidos[i][j] = 3;
                        }else if(partes[j].equals("5more")){
                            dadosConvertidos[i][j] = 4;
                        }
                        break;
                    case 3:
                        if(partes[j].equals("2")){
                            dadosConvertidos[i][j] = 1;
                        }else if(partes[j].equals("4")){
                            dadosConvertidos[i][j] = 2;
                        }else if(partes[j].equals("more")){
                            dadosConvertidos[i][j] = 3;
                        }
                        break;
                    case 4:
                        if(partes[j].equals("small")){
                            dadosConvertidos[i][j] = 1;
                        }else if(partes[j].equals("med")){
                            dadosConvertidos[i][j] = 2;
                        }else if(partes[j].equals("big")){
                            dadosConvertidos[i][j] = 3;
                        }
                        break;
                    case 5:
                        if(partes[j].equals("low")){
                            dadosConvertidos[i][j] = 1;
                        }else if(partes[j].equals("med")){
                            dadosConvertidos[i][j] = 2;
                        }else if(partes[j].equals("high")){
                            dadosConvertidos[i][j] = 3;
                        }
                        break;
                }
            }
        }
        return dadosConvertidos;
    }
    
    public ArrayList<Gene> aptitudeCalc(int[][] dados){
        int aptitude = 0;
        ArrayList<Gene> genes = new ArrayList<>();
        for(int i=0; i<dados.length;i++){
            int[] geneTemp = new int[6];
            for(int j=0; j<6;j++){
                geneTemp[j] = dados[i][j];
            }
            aptitude = (dados[i][0]*3)+(dados[i][1]*1)+(dados[i][2]*1)+(dados[i][3]*2)+(dados[i][4]*3)+(dados[i][5]*2);//(ValorPosição*Peso)
            Gene gene = new Gene(geneTemp, aptitude);
            genes.add(gene);
        }
        return genes;
    }
    
    public Gene getBest(ArrayList<Gene> genes){
        Gene melhor = new Gene();
        int maiorAptitude = -5;
        for (Gene gene : genes) {
            if(gene.getAptitude()>maiorAptitude){
                melhor = gene;
                maiorAptitude = melhor.getAptitude();
            }
        }
        return melhor;
    }

    public int[][] geraPop(){
        int[][] dados = converte();
        int[][] newPop = new int[dados.length][6];
        Random rand = new Random();
        for(int i=0;i<dados.length-1;i++){
            for(int j=0; j<2;j++){
                newPop[i][j] = dados[i][j];
            }
            for(int j=2; j<4;j++){
                newPop[i][j] = dados[i+1][j];
            }
            for(int j=4; j<6;j++){
                newPop[i][j] = dados[i][j];
            }
            int mutation = rand.nextInt(6);
            newPop[i][mutation] = dados[rand.nextInt(dados.length)][mutation];
        }
        for(int j=0; j<6;j++){
            newPop[dados.length-1][j] = dados[rand.nextInt(dados.length)][j];
        }
        return newPop;
    }

    public int[][] geraPop(int[][] pop){
        int[][] dados = pop;
        int[][] newPop = new int[dados.length][6];
        Random rand = new Random();
        for(int i=0;i<dados.length-1;i++){
            for(int j=0; j<2;j++){
                newPop[i][j] = dados[i][j];
            }
            for(int j=2; j<4;j++){
                newPop[i][j] = dados[i+1][j];
            }
            for(int j=4; j<6;j++){
                newPop[i][j] = dados[i][j];
            }
            int mutation = rand.nextInt(6);
            newPop[i][mutation] = dados[rand.nextInt(dados.length)][mutation];
        }
        for(int j=0; j<6;j++){
            newPop[dados.length-1][j] = dados[rand.nextInt(dados.length)][j];
        }
        return newPop;
    }

}