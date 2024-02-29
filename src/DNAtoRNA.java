import java.util.Stack;

public class DNAtoRNA {
    public static String dnaToRna(String dna) {
        String rna = "";

        char base;
        for(int i = 0; i < dna.length(); i++){
            base = dna.charAt(i); // this line is O(1) time and space
            if(base == 'T') {
                rna = rna + "U"; // this line is O(N) and space
            } else {
                rna = rna + base; // this line is O(N) and space
            }
        }

        return rna;
    }
}
