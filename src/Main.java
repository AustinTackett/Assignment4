public class Main {
    public static void main(String[] args) {

        String brackets = "{{{}}}";
        String isBalanced = BalancedBrackets.isBalanced(brackets);
        System.out.println("Is the String " + brackets + " balanced?\n" + isBalanced + "\n");

        //---------------------------------------------------------------------------------

        String dna1 = "AGCTGGGAAACGTAGGCCTA";
        String dna2 = "TTTTTTTTTTGGCGCG";
        String dna3 = "T";

        String rna1 = DNAtoRNA.dnaToRna(dna1);
        String rna2 = DNAtoRNA.dnaToRna(dna2);
        String rna3 = DNAtoRNA.dnaToRna(dna3);

        System.out.println("DNA:\n" + dna1 + "\n" + dna2 + "\n" + dna3 + "\n"
                            + "RNA:\n" + rna1 + "\n" + rna2 + "\n" + rna3 + "\n");

        //---------------------------------------------------------------------------------
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        String postfix = InfixToPostfix.infixToPostFix(infix);
        System.out.println("Infix: " +infix);
        System.out.println("postFix: " +postfix + "\n");

        //---------------------------------------------------------------------------------
        //"AGC UGG GAA ACG UAG GCC UA"
        String rnaSeq = "AGCUGGGAAACGUAGGCCUA";
        String protSeq = RnaToProteins.rnaToProteins(rnaSeq);
        System.out.println("RNA Sequence: " + rnaSeq);
        System.out.println("Amino Acid Sequence: " + protSeq);


    }
}