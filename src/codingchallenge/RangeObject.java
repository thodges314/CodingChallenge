package codingchallenge;

/**
 * Comparable object holding zip code ranges and lengths with methods
 * for detecting overlap with and merging with other instances of 
 * RangeObject.
 * @author Thomas Hodges
 */
public class RangeObject implements Comparable<RangeObject> {
    private int high;
    private int low;
    private int length;
    
    /**
     * contructs a range object from low and high range values, sets
     * the length value based on the number of values caontained
     * between the low and high values inclusive
     * @param low low value of zip code range
     * @param high high value of zip code range
     */
    public RangeObject(int low, int high){
        this.low = low;
        this.high = high;
        this.length = measureLength();
    }
    
    /**
     * getter for high value of zip code range
     * @return high value of zip code range
     */
    public int getHigh() {
        return high;
    }
    
    /**
     * getter for low value of zip code range
     * @return low value of zip code range
     */
    public int getLow() {
        return low;
    }
    
    /**
     * getter for length of zip code range - total number of possible
     * zip codes between low value and high value inclusive
     * @return length of zip code range
     */
    public int getLength() {
        return length;
    }
    
    private int measureLength(){
        return measureLength(low, high);
    }
    
    private int measureLength(int low, int high) {
        return high - low + 1;
    }
    
    /**
     * determines if overlaps the given RangeObject
     * @param rangeObject RangeObject to check for overlap with
     * @return wheather there is overlap with rangeObject
     */
    //note that overlap is computed by summing the lengths of the two ranges and
    //comparing that sum to the length between the lowest low point and the 
    //highest high point.  If this combined length is lesser than or equal to
    //the sum of the individual lengths than the ranges can be said to overlap.
    //To illustrate: [---[==]-] < [------] + [----]
    public boolean overlap(RangeObject rangeObject){
        int lowestPoint = Math.min(low, rangeObject.getLow());
        int highestPoint = Math.max(high, rangeObject.getHigh());
        int combinedLength = measureLength(lowestPoint, highestPoint);
        if (combinedLength <= length + rangeObject.getLength())
            return true;
        else
            return false;
    }
    
    /**
     * merges with another RangeObject instance
     * @param rangeObject the RangeObject to be merged with
     * @return a merged RangeObject
     */
    public RangeObject merge(RangeObject rangeObject){
        int lowestPoint = Math.min(low, rangeObject.getLow());
        int highestPoint = Math.max(high, rangeObject.getHigh());
        return new RangeObject(lowestPoint, highestPoint);
    }
    
    public String toString(){
        return "["+low+","+high+"]";
    }
    
    public int compareTo(RangeObject rangeObject){
        if (low < rangeObject.getLow())
            return -1;
        else if (low == rangeObject.getLow())
            return 0;
        else
            return 1;
    }
}
