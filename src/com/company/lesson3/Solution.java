package com.company.lesson3;

import java.util.Arrays;

public class Solution {
    /**
     * Given two strings s and t
     * return true if t is an anagram of s, and false otherwise.
     * An Anagram is a word
     * or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once.
     * Example: Input: s = "anagram", t = "nagaram"; Output: true
     * Input: s = "rat", t = "car"; Output: false
     * Constraints: 1 <= s.length, t.length <= 5 * 104
     * s and t consist of lowercase English letters.
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sToChars = s.toCharArray();
        char[] tToChars = t.toCharArray();
        Arrays.sort(sToChars);
        Arrays.sort(tToChars);
        return Arrays.equals(sToChars, tToChars);
    }
}
