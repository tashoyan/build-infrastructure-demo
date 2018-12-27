package com.github.tashoyan.demo;

import org.junit.Test;
import static org.junit.Assert.*;
import static com.github.tashoyan.demo.JavaLib.upperCaseString;

public class JavaLibTest {

    @Test(expected = NullPointerException.class)
    public void upperCaseStringNullArg() {
        upperCaseString(null);
    }

    @Test
    public void upperCaseStringEmptyString() {
        String result = upperCaseString("");
        assertEquals("", result);
    }

    @Test
    public void upperCaseStringMixedCase() {
        String result = upperCaseString("aBc");
        assertEquals("ABC", result);
    }

    @Test
    public void upperCaseStringUpperCase() {
        String result = upperCaseString("ABC");
        assertEquals("ABC", result);
    }

    @Test
    public void upperCaseStringLowerCase() {
        String result = upperCaseString("abc");
        assertEquals("ABC", result);
    }

    @Test
    public void upperCaseStringSeveralWords() {
        String result = upperCaseString("abc def");
        assertEquals("ABC DEF", result);
    }

}
