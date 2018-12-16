/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.mycompany.bioinformatyka;


import org.biojava.nbio.alignment.Alignments;
import org.biojava.nbio.alignment.Alignments.PairwiseSequenceAlignerType;
import org.biojava.nbio.alignment.SimpleGapPenalty;
import org.biojava.nbio.core.alignment.matrices.SubstitutionMatrixHelper;
import org.biojava.nbio.alignment.template.*;
import org.biojava.nbio.core.alignment.template.SequencePair;
import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.compound.AmbiguityDNACompoundSet;
import org.biojava.nbio.core.sequence.compound.NucleotideCompound;
import org.biojava.nbio.structure.align.gui.*;

public class BioInformatics {

    public static void main(String[] args) throws Exception {
        
        
      // AlignmentGui.getInstance();
       
        String seq1 = "ATAAGC";
        String seq2 = "AAAAACG";
        SimpleGapPenalty gapPenalty= new SimpleGapPenalty();
        int gop =0;
        int gep =0;
        gapPenalty.setOpenPenalty(gop);
        gapPenalty.setExtensionPenalty(gep);
        

        PairwiseSequenceAligner<DNASequence, NucleotideCompound> aligner = Alignments.getPairwiseAligner(
                new DNASequence(seq1, AmbiguityDNACompoundSet.getDNACompoundSet()),
                new DNASequence(seq2, AmbiguityDNACompoundSet.getDNACompoundSet()),
                PairwiseSequenceAlignerType.GLOBAL,
                gapPenalty,
                SubstitutionMatrixHelper.getNuc4_4());
        

        SequencePair<DNASequence, NucleotideCompound> alignment = aligner.getPair();

        System.out.println("Alignment: \n"+ alignment);

        System.out.println("Distance: "+ aligner.getDistance());

    }
}
