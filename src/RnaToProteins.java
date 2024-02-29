import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;

public class RnaToProteins {
    public static String rnaToProteins(String rna) {
        HashMap<String, Character> lookUpTable = createLookUpTable();
        Queue<Character> protQueue = new LinkedList<>();
        Queue<Character> rnaQueue = new LinkedList<>();
        for(int i = 0; i < rna.length(); i += 3) {
            if(i+3 > rna.length()) {
                protQueue.add('.');
                break;
            }
            for(int j = 0; j < 3; j++) {
                rnaQueue.add(rna.charAt(i + j));
            }
            char protein = protLookUpTable(rnaQueue, lookUpTable);
            protQueue.add(protein);

        }

        String protSeq = "";
        int len = protQueue.size();
        for(int i = 0; i < len; i++) {
            protSeq += protQueue.remove();
        }

        return protSeq;
    }

    private static char protLookUpTable(Queue<Character> rnaQueue, HashMap<String, Character> lookUpTable) {
        String rnaSeq = "";
        for(int i = 0; i < 3; i++) {
            rnaSeq += rnaQueue.remove();
        }

        char protein = lookUpTable.get(rnaSeq);
        return protein;
    }

    private static HashMap<String, Character> createLookUpTable() {
        // https://en.wikipedia.org/wiki/DNA_and_RNA_codon_tables
        HashMap<String, Character> LookUpTable = new HashMap<>();
        LookUpTable.put("UUU", 'F');
        LookUpTable.put("UUC", 'F');
        LookUpTable.put("UUA", 'L');
        LookUpTable.put("UUG", 'L');
        LookUpTable.put("CUU", 'L');
        LookUpTable.put("CUC", 'L');
        LookUpTable.put("CUA", 'L');
        LookUpTable.put("CUG", 'L');
        LookUpTable.put("AUU", 'I');
        LookUpTable.put("AUC", 'I');
        LookUpTable.put("AUA", 'I');
        LookUpTable.put("AUG", 'M');
        LookUpTable.put("GUU", 'V');
        LookUpTable.put("GUC", 'V');
        LookUpTable.put("GUA", 'V');
        LookUpTable.put("GUG", 'V');
        LookUpTable.put("UCU", 'S');
        LookUpTable.put("UCC", 'S');
        LookUpTable.put("UCA", 'S');
        LookUpTable.put("UCG", 'S');
        LookUpTable.put("CCU", 'P');
        LookUpTable.put("CCC", 'P');
        LookUpTable.put("CCA", 'P');
        LookUpTable.put("CCG", 'P');
        LookUpTable.put("ACU", 'T');
        LookUpTable.put("ACC", 'T');
        LookUpTable.put("ACA", 'T');
        LookUpTable.put("ACG", 'T');
        LookUpTable.put("GCU", 'A');
        LookUpTable.put("GCC", 'A');
        LookUpTable.put("GCA", 'A');
        LookUpTable.put("GCG", 'A');
        LookUpTable.put("UAU", 'Y');
        LookUpTable.put("UAC", 'Y');
        LookUpTable.put("UAA", '.');
        LookUpTable.put("UAG", '.');
        LookUpTable.put("CAU", 'H');
        LookUpTable.put("CAC", 'H');
        LookUpTable.put("CAA", 'Q');
        LookUpTable.put("CAG", 'Q');
        LookUpTable.put("AAU", 'N');
        LookUpTable.put("AAC", 'N');
        LookUpTable.put("AAA", 'K');
        LookUpTable.put("AAG", 'K');
        LookUpTable.put("GAU", 'D');
        LookUpTable.put("GAC", 'D');
        LookUpTable.put("GAA", 'E');
        LookUpTable.put("GAG", 'E');
        LookUpTable.put("UGU", 'C');
        LookUpTable.put("UGC", 'C');
        LookUpTable.put("UGA", '.');
        LookUpTable.put("UGG", 'W');
        LookUpTable.put("CGU", 'R');
        LookUpTable.put("CGC", 'R');
        LookUpTable.put("CGA", 'R');
        LookUpTable.put("CGG", 'R');
        LookUpTable.put("AGU", 'S');
        LookUpTable.put("AGC", 'S');
        LookUpTable.put("AGA", 'R');
        LookUpTable.put("AGG", 'R');
        LookUpTable.put("GGU", 'G');
        LookUpTable.put("GGC", 'G');
        LookUpTable.put("GGA", 'G');
        LookUpTable.put("GGG", 'G');

        return LookUpTable;
    }

}
