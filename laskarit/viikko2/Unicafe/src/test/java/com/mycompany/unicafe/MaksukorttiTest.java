package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoPalauttaaOikein() {
        int saldo = 1000;
        assertEquals(saldo, kortti.saldo());
    }
    
    @Test
    public void saldoAlussaOikein() {
        assertEquals("saldo: 10.0", kortti.toString());
    }
    
    @Test
    public void voiLadataRahaa() {
        kortti.lataaRahaa(500);
        assertEquals("saldo: 15.0", kortti.toString());
    }
    
    @Test
    public void voiMaksaa() {
        kortti.otaRahaa(400);
        assertEquals("saldo: 6.0", kortti.toString());
    }
    
    @Test
    public void saldoEiMeneNegatiiviseksi() {
        kortti.otaRahaa(1100);
        assertEquals("saldo: 10.0", kortti.toString());
    }
    
    @Test
    public void otaRahaaToimiiOikein() {
        assertTrue(kortti.otaRahaa(500));
        assertFalse(kortti.otaRahaa(600));
    }
    
}
