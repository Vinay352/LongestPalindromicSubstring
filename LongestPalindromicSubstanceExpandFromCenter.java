package Leetcode.Medium;

/**
 *
 * Author: Vinay Jain
 * Contact: vinay.j3097@gmail.com
 *
 */

public class LongestPalindromicSubstanceExpandFromCenter {

    public static void main(String[] args) {
        String test = "aaaaa";

        System.out.println(longestPalindrome(test));
    }

    public static String longestPalindrome(String test){

        int leftIndex = 0;
        int rightIndex = 0;
        int curLen = 0;
        int maxLen = 0;
        int len = test.length();
        int finalLeftIndex = 0;
        int finalRightIndex = 0;

        for(int i = 0; i < len; i++){

            // odd length cases
            leftIndex = i;
            rightIndex = i+1;
            curLen = 0;
            while(leftIndex >= 0 && rightIndex < len && test.charAt(leftIndex) == test.charAt(rightIndex)){
                curLen = rightIndex - leftIndex + 1;
                if(curLen > maxLen){
                    maxLen = curLen;
                    finalLeftIndex = leftIndex;
                    finalRightIndex = rightIndex;
                }
                leftIndex--;
                rightIndex++;
            }

            // even length cases
            leftIndex = i;
            rightIndex = i;
            curLen = 0;
            while(leftIndex >= 0 && rightIndex < len && test.charAt(leftIndex) == test.charAt(rightIndex)){
                curLen = rightIndex - leftIndex + 1;
                if(curLen > maxLen){
                    maxLen = curLen;
                    finalLeftIndex = leftIndex;
                    finalRightIndex = rightIndex;
                }
                leftIndex--;
                rightIndex++;
            }

        }

        return test.substring(finalLeftIndex, finalRightIndex + 1);
    }

}
