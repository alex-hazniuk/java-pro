package com.company.lesson8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));
        int[] indices = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(indices));
    }

    /**
     * A phrase is a palindrome if, after converting all uppercase letters
     * into lowercase letters and removing all non-alphanumeric characters,
     * it reads the same forward and backward.
     * Alphanumeric characters include letters and numbers.
     * Given a string s, return true if it is a palindrome, or false otherwise.
     * <p>
     * Example 1:
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     * <p>
     * Example 2:
     * Input: s = "race a car"
     * Output: false
     * Explanation: "raceacar" is not a palindrome.
     * <p>
     * Example 3:
     * Input: s = " "
     * Output: true
     * Explanation: s is an empty string "" after removing non-alphanumeric characters.
     * Since an empty string reads the same forward and backward, it is a palindrome.
     */
    private static boolean isPalindrome(String phrase) {
        if (phrase != null) {
            char[] phraseToChars = phrase.toLowerCase().toCharArray();
            StringBuilder builder = new StringBuilder();
            for (char value : phraseToChars) {
                if (Character.isLetter(value) || Character.isDigit(value)) {
                    builder.append(value);
                }
            }
            return builder.toString().equals(builder.reverse().toString());
        }
        return false;
    }

    /**
     * Given an integer array nums, return true if any value appears
     * at least twice in the array, and return false if every element is distinct.
     * <p>
     * Example 1:
     * Input: nums = [1,2,3,1]
     * Output: true
     * <p>
     * Example 2:
     * Input: nums = [1,2,3,4]
     * Output: false
     * <p>
     * Example 3:
     * Input: nums = [1,1,1,3,3,4,3,2,4,2]
     * Output: true
     */
    private static boolean containsDuplicate(int[] numbers) {
        if (numbers != null) {
            Set<Integer> uniqueNumbers = new HashSet<>();
            for (int number : numbers) {
                if (uniqueNumbers.contains(number)) {
                    return true;
                }
                uniqueNumbers.add(number);
            }
        }
        return false;
    }

    /**
     * Given an array of integers nums and an integer target,
     * return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution,
     * and you may not use the same element twice.
     * You can return the answer in any order.
     * <p>
     * Example 1:
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     * <p>
     * Example 2:
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     * <p>
     * Example 3:
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     */
    private static int[] twoSum(int[] numbers, int target) {
        if (numbers != null) {
            List<Integer> integers = new ArrayList<>();
            Set<Integer> uniqueNumbers = new HashSet<>();
            for (int i = 0; i < numbers.length; i++) {
                if (uniqueNumbers.contains(target - numbers[i])) {
                    return new int[]{integers.indexOf(target - numbers[i]), i};
                }
                integers.add(numbers[i]);
                uniqueNumbers.add(numbers[i]);
            }
        }
        return new int[]{};
    }
}
