package org.tandem.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlphanumericPalindromeRulesHelperTest {

    @Test
    void isPalindrome_WithNullString_ShouldReturnFalse() {
        assertFalse(new AlphanumericPalindromeRulesHelper().isPalindrome(null));
    }

    @Test
    void isPalindrome_WithEmptyString_ShouldReturnFalse() {
        assertFalse(new AlphanumericPalindromeRulesHelper().isPalindrome(""));
    }

    @Test
    void isPalindrome_WithEmptyChangedString_ShouldReturnFalse() {
        String s = String.valueOf((char) 0) + (char) 1 + (char) 2;
        assertFalse(new AlphanumericPalindromeRulesHelper().isPalindrome(s));
    }

    @Test
    void isPalindrome_WithOnlyOneAlphanumericCharacter_ShouldReturnTrue() {
        assertTrue(new AlphanumericPalindromeRulesHelper().isPalindrome("0"));
    }

    @Test
    void isPalindrome_WithOnlyPalindrome_ShouldReturnTrue() {
        assertTrue(new AlphanumericPalindromeRulesHelper().isPalindrome("aba"));
    }

    @Test
    void isPalindrome_WithNotOnlyPalindrome_ShouldReturnTrue() {
        assertTrue(new AlphanumericPalindromeRulesHelper().isPalindrome((char) 0 + "aba" + (char) 1));
    }

    @Test
    void isPalindrome_WithNonPalindrome_ShouldReturnFalse() {
        assertFalse(new AlphanumericPalindromeRulesHelper().isPalindrome((char) 0 + "ab" + (char) 1));
    }
}