package com.example.bit603_a3_tarrynt_whitty;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CakeUnitTests {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void login_isAdmin() {
        assertTrue("Failed to logg into admin", MainActivity.isAdmin("Admin", "CookieManagement84"));
        assertFalse("Logged into Admin, this is incorrect", MainActivity.isAdmin("notcorrect", "notcorrect"));
    }



}