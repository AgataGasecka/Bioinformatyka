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
    PairwiseSequenceAlignerType type;
    SimpleGapPenalty gapPenalty;
    SubstitutionMatrixHelper substitutionMatrix;
    
    public void makeResult() {
        PairwiseSequenceAligner<ProteinSequence, AminoAcidCompound> aligner = Alignments.getPairwiseAligner(
                seq1,
                seq2,
                type,
                gapPenalty,
                SubstitutionMatrixHelper.getBlosum62());
    }
}
