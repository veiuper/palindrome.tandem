package org.tandem.test;

import org.tandem.test.api.PalindromeRulesHelper;

public class AlphanumericPalindromeRulesHelper implements PalindromeRulesHelper {

    @Override
    public boolean isPalindrome(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        String clearedString = getAlphanumericCharactersInUppercase(str);
        if ("".equals(clearedString)) {
            return false;
        }
        String reversed = new StringBuilder(clearedString).reverse().toString();
        return clearedString.equals(reversed);
    }

    @Override
    public int getPoints(String word) {
        String clearWord = getAlphanumericCharactersInUppercase(word);
        return clearWord.length();
    }

    private String getAlphanumericCharactersInUppercase(String s) {
        return s.replaceAll("[^A-Za-zА-я\\d]", "").toUpperCase();
    }
}
