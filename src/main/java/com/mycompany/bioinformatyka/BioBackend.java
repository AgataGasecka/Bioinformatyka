/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
/**
 *
 * @author Agata
 */
public class BioBackend {
    
    ProteinSequence seq1;
    ProteinSequence seq2;
    String uniProtId1;
    String uniProtId2;
    int gep;
    int gop;
    PairwiseSequenceAlignerType type;
    SubstitutionMatrixHelper substitutionMatrix;
    String[] results = new String[3];
    
    public String[] makeResult() {
        PairwiseSequenceAligner<ProteinSequence, AminoAcidCompound> aligner = Alignments.getPairwiseAligner(
                seq1,
                seq2,
                type,
                new SimpleGapPenalty(gop, gep),
                SubstitutionMatrixHelper.getBlosum62());
        
        SequencePair<ProteinSequence, AminoAcidCompound> alignment = aligner.getPair();
        results[0] = "Alignment: " + alignment;
        results[1] = "Distance: "+ aligner.getDistance();
        results[2] = "Similarity: " + aligner.getSimilarity();

//        System.out.println("Alignment: "+ alignment);
//
//        System.out.println("Distance: "+ aligner.getDistance());
//        
//        System.out.println("Similarity: " + aligner.getSimilarity());
//        
//        System.out.println("Max score: " + aligner.getMaxScore());
//        
//        System.out.println("Min score: " + aligner.getMinScore());
        return results;
    }
    
    public ProteinSequence getFastaSequenceFromId(String uniProtId) throws Exception {
        ClassLoader classLoader = Bioinfa2.class.getClassLoader();
	File file = new File(classLoader.getResource(uniProtId +".fasta.txt").getFile());
        InputStream in = new FileInputStream(file);
        ProteinSequence seq = FastaReaderHelper.readFastaProteinSequence(in).get(uniProtId);
        System.out.printf("Sequence loaded: %s\n\n", seq);

        return seq;
    }
}
