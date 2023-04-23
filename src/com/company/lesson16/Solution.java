package com.company.lesson16;

import java.util.Map;

public class Solution {
    /**
     * Given a roman numeral
     * Convert it to an integer
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * <p>
     * Example 1:
     * Input: romanNumber = "III"
     * Output: 3
     * Explanation: III = 3.
     * <p>
     * Example 2:
     * Input: romanNumber = "LVIII"
     * Output: 58
     * Explanation: L = 50, V= 5, III = 3.
     * <p>
     * Example 3:
     * Input: romanNumber = "MCMXCIV"
     * Output: 1994
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     * <p>
     * Constraints:
     * 1 <= romanNumber.length <= 15
     * romanNumber contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
     * It is guaranteed that romanNumber is a valid roman numeral in the range [1, 3999].
     */
    public int romanToInt(String romanNumber) {
        Map<Character, Integer> romanNumbers = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );
        int previousValue = 0;
        int sum = 0;
        for (int i = romanNumber.length() - 1; i >= 0; i--) {
            int currentValue = romanNumbers.get(romanNumber.charAt(i));
            sum += currentValue < previousValue
                    ? -currentValue : currentValue;
            previousValue = currentValue;
        }
        return sum;
    }
}
