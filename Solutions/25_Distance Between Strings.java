/*
 *					******** IMPORTANT ********
 *
 * THIS IS SAMPLE SOLUTION. IF YOU FIND BETTER SOLUTION PLEASE CONSIDER USING SAME.
 * USE YOUR OWN VARIABLE NAMES - @@@ DO NOT COPY @@@ EXACT VARIABLE NAMES
 *
 */

public class Solution {

    public static double shortestDistance(String paragraph, String wordOne, String wordTwo) {
        String[] wordsFromParagraph = paragraph.split("[,. ]");

        int wordIndex = 0;
        double wordOneLocation = 0;
        double wordTwoLocation = 0;
        double shortestDistance = paragraph.length();

        for(String word : wordsFromParagraph) {
            if(word.equalsIgnoreCase(wordOne)) {
                wordOneLocation = wordIndex + (word.length()/2d);
            } else if(word.equalsIgnoreCase(wordTwo)) {
                wordTwoLocation = wordIndex + (word.length()/2d);
            }

            if(wordOneLocation > 0 && wordTwoLocation > 0) {
                double current = Math.abs(wordOneLocation - wordTwoLocation);
                if(current < shortestDistance) {
                    shortestDistance = current;
                }
            }

            wordIndex += word.length() + 1;
        }

        if(wordOneLocation == 0 || wordTwoLocation == 0) {
            return -1;
        }

        return shortestDistance;
    }

    /**
     * Returns true if the tests pass. Otherwise, false.
     */
    public static boolean doTestsPass() {
        // todo: implement more tests if you'd like
        return  shortestDistance(_paragraph, "and", "graphic") == 6d &&
                shortestDistance(_paragraph, "transfer", "it") == 14d &&
                shortestDistance(_paragraph, "Design", "filler" ) == 25d;
    }

    /**
     * Execution entry point.
     */
    public static void main(String[] args) {
        // Run the tests
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }
    }

    private static final String _paragraph;
    static{
        StringBuffer sb = new StringBuffer();
        sb.append("In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements");
        sb.append(" lorem ipsum text has been used in typesetting since the 1960s or earlier, when it was popularized by advertisements");
        sb.append(" for Letraset transfer sheets. It was introduced to the Information Age in the mid-1980s by Aldus Corporation, which");

        _paragraph = sb.toString();
    }
}