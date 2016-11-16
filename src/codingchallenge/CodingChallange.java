package codingchallenge;

import java.util.*;
import codingchallenge.GUI.*;

/**
 * <h1>Coding Challange</h1>
 * Created as a coding challange presented by a potential employer, this program
 * accepts pairs of zip-code values representing ranges such as
 * &#91;94133,94133&#93; &#91;94200,94299&#93; &#91;94226,94399&#93;, combines
 * them and presents them as the minimal number of ranges required to express
 * the same net ranges of values as the original list.<p>
 * This program accepts values either truncated onto the command line, such as
 * <code>java CodingChallange &#91;94133,94133&#93; &#91;94200,94299&#93;</code>
 * <code>&#91;94226,94399&#93;</code> or
 * <code>java CodingChallange &lt; test.txt</code>, or values can be entered
 * directly after starting the program.
 *
 * @author Thomas Hodges
 */
public class CodingChallange {

    /**
     * manages the initial state of the program based on the data it may have
     * received on the command line when run.
     *
     * @param args command line arguments - set of formatted zip code ranges
     */
    public static void main(String[] args) {
        if (args.length != 0) {
            displayRanges(ParseInput.parseInput(args));
        } else {
            DrawWindow.launch(args);
        }
    }

    /**
     * displays a RangeSet object on the terminal
     *
     * @see RangeSet
     * @param rangeSet
     */
    private static void displayRanges(RangeSet rangeSet) {
        for (RangeObject rangeObject : rangeSet) {
            System.out.print(rangeObject + " ");
        }
        System.out.println();
    }

}
