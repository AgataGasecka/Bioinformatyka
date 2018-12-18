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
import org.biojava.nbio.core.exceptions.CompoundNotFoundException;
import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.compound.AmbiguityDNACompoundSet;
import org.biojava.nbio.core.sequence.compound.NucleotideCompound;
/**
 *
 * @author Agata
 */
public class BioBackend {
    
    ProteinSequence seq1;
    ProteinSequence seq2;
    String uniProtId1;
    String uniProtId2;
    String dna1;
    String dna2;
    int gep;
    int gop;
    PairwiseSequenceAlignerType type;
    SubstitutionMatrixHelper substitutionMatrix;
    String[] ProteinResults = new String[3];
    String[] DnaResults = new String[3];
    
    public String[] makeResultForProtein() {
        PairwiseSequenceAligner<ProteinSequence, AminoAcidCompound> aligner = Alignments.getPairwiseAligner(
                seq1,
                seq2,
                type,
                new SimpleGapPenalty(gop, gep),
                SubstitutionMatrixHelper.getBlosum62());
        
        SequencePair<ProteinSequence, AminoAcidCompound> alignment = aligner.getPair();
        ProteinResults[0] = "Alignment: " + alignment;
        ProteinResults[1] = "Distance: "+ aligner.getDistance();
        ProteinResults[2] = "Similarity: " + aligner.getSimilarity();

        return ProteinResults;
    }
    
    public String[] makeResultForDNA() throws CompoundNotFoundException {
        PairwiseSequenceAligner<DNASequence, NucleotideCompound> aligner = Alignments.getPairwiseAligner(
                new DNASequence(dna1, AmbiguityDNACompoundSet.getDNACompoundSet()),
                new DNASequence(dna2, AmbiguityDNACompoundSet.getDNACompoundSet()),
                type,
                new SimpleGapPenalty(gop, gep),
                SubstitutionMatrixHelper.getNuc4_4());
        
        SequencePair<DNASequence, NucleotideCompound> alignment = aligner.getPair();
        DnaResults[0] = "Alignment: " + "\n" +alignment;
        DnaResults[1] = "Distance: "+ aligner.getDistance();
        DnaResults[2] = "Similarity: " + aligner.getSimilarity();

        return DnaResults;
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
