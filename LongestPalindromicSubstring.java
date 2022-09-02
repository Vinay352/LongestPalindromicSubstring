package Leetcode.Medium;

/**
 *
 * Author: Vinay Jain
 * Contact: vinay.j3097@gmail.com
 *
 */

public class LongestPalindromicSubstring {

    public static void main(String[] args) {

        String test = "aaaaa";

        System.out.println(longestPalindrome(test));
    }

    public static String longestPalindrome(String test) {
        int len = test.length();

        int[][] mat = new int[len][len];

        int finalLeftIndex = 0;

        int maxLength = 1;
        // maxlength = 1; single characters
        for(int i =0; i < len; i++){
            mat[i][i] = 1;
        }

        // maxLength = 2; adjacent characters if they are same
        for(int i = 0; i < len - 1; i++){
            if(test.charAt(i) == test.charAt(i+1)){
                mat[i][i+1] = 1;
                maxLength = 2;
                finalLeftIndex = i;
            }
        }

        // for string of length >= 3
        for(int substringLength = 3; substringLength <= len; substringLength++ ){ // for substring length >= 3
            for(int startIndex = 0; startIndex < len - substringLength + 1; startIndex++){ // for starting index from 0
                int endIndex = startIndex + substringLength - 1; // end index as per start index and substring length

                if(mat[startIndex + 1][endIndex - 1] == 1){ // if previous left character == previous right character
                    if(test.charAt(startIndex) == test.charAt(endIndex)){ // current left and right are equal or not
                        mat[startIndex][endIndex] = 1;
                        maxLength = substringLength;
                        finalLeftIndex = startIndex;
                    }
                }
            }
        }

        return test.substring(finalLeftIndex, finalLeftIndex + maxLength);
    }

}
