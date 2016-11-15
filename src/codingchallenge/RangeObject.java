/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingchallenge;

/**
 *
 * @author thodges
 */
public class RangeObject implements Comparable<RangeObject> {
    private int high;
    private int low;
    private int length;
    
    public RangeObject(int low, int high){
        this.low = low;
        this.high = high;
        this.length = measureLength();
    }
    
    public int getHigh() {
        return high;
    }
    
    public int getLow() {
        return low;
    }
    
    public int getLength() {
        return length;
    }
    
    private int measureLength(){
        return measureLength(low, high);
    }
    
    private int measureLength(int low, int high) {
        return high - low + 1;
    }
    
    public boolean overlap(RangeObject rangeObject){
        int lowestPoint = Math.min(low, rangeObject.getLow());
        int highestPoint = Math.max(high, rangeObject.getHigh());
        int combinedLength = measureLength(lowestPoint, highestPoint);
        if (combinedLength <= length + rangeObject.getLength())
            return true;
        else
            return false;
    }
    
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
