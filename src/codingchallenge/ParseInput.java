package codingchallenge;

import codingchallenge.GUI.Emergency;

/**
 * Holds static methods to parse user input into RangeSets of RangeObjects.
 *
 * @author Thomas Hodges
 */
public class ParseInput {

    /**
     * overloaded static method to receive a string of range values enclosed in
     * brackets
     * <code>&quot;&#91;94133,94133&#93; &#91;94200,94299&#93; &#91;94226,94399&#93;&quot;</code>
     * and parse into a RangeSet of RangeObjects.
     *
     * @param inputString string of zip code ranges wrapped in brackets
     * @return RangeSet of RangeObjects of range values
     * @see RangeSet
     * @see RangeObject
     */
    public static RangeSet parseInput(String inputString) {
        String[] splitStrings = inputString.split("\\]\\s*\\[");
        splitStrings[0] = splitStrings[0].replaceAll("\\s*\\[", "");
        splitStrings[splitStrings.length - 1]
                = splitStrings[splitStrings.length - 1].replaceAll("\\]\\s*", "");

        RangeSet returnSet = new RangeSet();
        try {
            for (String pair : splitStrings) {
                String[] splitPair = pair.split("\\,\\s*");
                returnSet.addRange(new RangeObject(Integer.parseInt(splitPair[0]),
                        Integer.parseInt(splitPair[1])));
            }
        } catch (Exception ex) {
            Emergency.alert(ex);
        }
        return returnSet;
    }

    /**
     * overloaded static method to receive an array of strings of range values
     * enclosed in brackets
     * <code>&#91;&quot;&#91;94133,94133&#93;&quot;, &quot;&#91;94200,94299&#93;&quot;, &quot;&#91;94226,94399&#93;&quot;&#93;</code>
     * and parse into a RangeSet of RangeObjects.
     *
     * @param inputStringsArray array of strings of zip code ranges wrapped in
     * brackets
     * @return RangeSet of RangeObjects of range values
     * @see RangeSet
     * @see RangeObject
     */
    public static RangeSet parseInput(String[] inputStringsArray) {
        RangeSet returnSet = new RangeSet();
        for (String pair : inputStringsArray) {
            pair = pair.replaceAll("(\\s*\\[|\\]\\s*)", "");
            String[] splitPair = pair.split("\\,\\s*");
            returnSet.addRange(new RangeObject(Integer.parseInt(splitPair[0]),
                    Integer.parseInt(splitPair[1])));
        }
        return returnSet;
    }

}
