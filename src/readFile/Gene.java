package readFile;

public class Gene {
    int[] dna = new int[6];
    int aptitude;

    public Gene(){
        this.dna = null;
        this.aptitude = -1;
    }

    public Gene(int[] dna, int aptitude){
        this.dna = dna;
        this.aptitude = aptitude;
    }

    public int[] getDna() {
        return dna;
    }
    public void setDna(int[] dna) {
        this.dna = dna;
    }
    public int getAptitude() {
        return aptitude;
    }
    public void setAptitude(int aptitude) {
        this.aptitude = aptitude;
    }
    @Override
    public String toString(){
        String print = new String();
        print+="Gene: ";
        for(int i=0;i<6;i++){
            print+= this.dna[i];
        }
        print+=" Aptitude: ";
        print+= this.aptitude;
        return print;
    }
}
