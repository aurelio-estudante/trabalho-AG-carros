package dump;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import readFile.Leitor;

public class DumpToFile {
    String directory;
    String readFrom;
    String fileName;
    Leitor ler = new Leitor(readFrom);
    int[][] dados = ler.geraPop();
    int[][] aptitude = ler.aptitudeCalc(dados);

    public DumpToFile(String directory,String readFrom, String fileName){
        System.out.println("A");
        
        this.directory = directory;
        this.readFrom = readFrom;
        this.fileName = fileName;
    }

    public void createDump(){
        try {
            File dump = new File(directory+fileName);
            if (dump.createNewFile()) {
                System.out.println("File created: " + dump.getName());
              } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter(directory+fileName);
            //Writing
            for(int i=0; i<dados.length;i++){
                for(int j=0; j<dados[i].length;j++){
                    myWriter.write(dados[i][j]);
                }
                System.out.print(","+aptitude[i][0]);
                if(aptitude[i][0]<27){
                    System.out.print(",Ruim");
                }else{
                    System.out.print(",Bao");
                }
                System.out.println();
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

    }
}
