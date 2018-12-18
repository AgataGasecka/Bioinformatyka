package com.mycompany.bioinformatyka;


import java.io.File;
import org.biojava.nbio.alignment.Alignments;
import org.biojava.nbio.alignment.Alignments.PairwiseSequenceAlignerType;
import org.biojava.nbio.alignment.SimpleGapPenalty;
import org.biojava.nbio.core.alignment.matrices.SubstitutionMatrixHelper;
import org.biojava.nbio.alignment.template.PairwiseSequenceAligner;
import org.biojava.nbio.core.alignment.template.SequencePair;
import org.biojava.nbio.core.sequence.ProteinSequence;
import org.biojava.nbio.core.sequence.compound.AminoAcidCompound;
import org.biojava.nbio.core.sequence.io.FastaReaderHelper;

import java.io.FileInputStream;
import java.io.InputStream;

public class Bioinfa2 {

    public static void main(String[] args) throws Exception {        
        ProteinSequence query = getFastaSequenceForId("P69905");
        ProteinSequence target = getFastaSequenceForId("P68871");

        PairwiseSequenceAligner<ProteinSequence, AminoAcidCompound> aligner = Alignments.getPairwiseAligner(
                query,
                target,
                PairwiseSequenceAlignerType.LOCAL,
                new SimpleGapPenalty(-14, -4),
                SubstitutionMatrixHelper.getBlosum62());

        SequencePair<ProteinSequence, AminoAcidCompound> alignment = aligner.getPair();

        System.out.println("Alignment: \n"+ alignment);

        System.out.println("Distance: "+ aligner.getDistance());
        
        System.out.println("Similarity: " + aligner.getSimilarity());
        
        System.out.println("Max score: " + aligner.getMaxScore());
        
        System.out.println("Min score: " + aligner.getMinScore());
    }

    private static ProteinSequence getFastaSequenceForId(String uniProtId) throws Exception {
        ClassLoader classLoader = Bioinfa2.class.getClassLoader();
	File file = new File(classLoader.getResource(uniProtId +".fasta.txt").getFile());
        InputStream in = new FileInputStream(file);
        ProteinSequence seq = FastaReaderHelper.readFastaProteinSequence(in).get(uniProtId);
        System.out.printf("Sequence loaded: %s\n\n", seq);

        return seq;
    }
}
