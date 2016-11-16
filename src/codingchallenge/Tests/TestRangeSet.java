package codingchallenge.Tests;
import codingchallenge.RangeObject;
import codingchallenge.RangeSet;

/**
 *Tests composition, merging and ssorting on the RangeSet class.
 * 
 * @author Thomas Hodges
 */
public class TestRangeSet {

    /**
     *Creates a RangeSet, assigns 6 RangeObjects to it with varying
     * stages of overlap, and prints the result.
     * 
     * @param args an environment rariable in a java 'main' method
     */
    public static void main(String[] args) {
        RangeSet rangeSet = new RangeSet();
        rangeSet.addRange(new RangeObject(94133,94133));
        rangeSet.addRange(new RangeObject(94200,94299));
        rangeSet.addRange(new RangeObject(94226,94399));
        rangeSet.addRange(new RangeObject(94133,94133));
        rangeSet.addRange(new RangeObject(94130,94135));
        rangeSet.addRange(new RangeObject(94200,94399));
        System.out.println(rangeSet);
    }
    
}
