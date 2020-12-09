package com.general;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 */
public class DetectCapital
{
    private static final String UPPER = "[A-Z]+";
    private static final String LOWER = "[a-z]+";
    private static final Pattern UPPER_PATTER = Pattern.compile(UPPER);
    private static final Pattern LOWER_PATTER = Pattern.compile(LOWER);

    public boolean detectCapitalUse(String word)
    {
        int upperCount = 0;
        int lowerCount = 0;
        for (char wordChar: word.toCharArray())
        {
            if (Character.isUpperCase(wordChar))
            {
                upperCount++;
            } else
            {
                lowerCount++;
            }
        }
        int wordLength = word.length();
        if (upperCount == wordLength)
        {
            return true;
        }
        if (upperCount == 1)
        {
            return Character.isUpperCase(word.charAt(0));
        }
        return lowerCount == wordLength;
    }
    public boolean detectCapitalUseRegex(String word)
    {
        Matcher matcher = UPPER_PATTER.matcher(word);
        int upperCount = 0;
        int lowerCount = 0;
        while (matcher.find())
        {
            upperCount+=matcher.group(0).length();
        }
        if (upperCount == word.length())
        {
            return true;
        }
        if (upperCount == 1)
        {
            return Character.isUpperCase(word.charAt(0));
        }
        matcher = LOWER_PATTER.matcher(word);
        while (matcher.find())
        {
            lowerCount+=matcher.group(0).length();
        }

        return lowerCount == word.length();
    }

    public static void main( String[] args )
    {
        String str = String.valueOf(Integer.MAX_VALUE);
        if (str.startsWith("+"))
        {
            str = str.substring(1);
        }
        String.valueOf(Integer.MIN_VALUE);
        Integer.parseInt("-91283472332");
        System.out.println(new DetectCapital().detectCapitalUse("USA"));
        System.out.println(new DetectCapital().detectCapitalUse("leetcode"));
        System.out.println(new DetectCapital().detectCapitalUse("Google"));
        System.out.println(new DetectCapital().detectCapitalUse("FlaG"));
    }

}
