package com.mycompany.unicafe;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
    
    Kassapaate kassa;
    Maksukortti kortti;
    
    public KassapaateTest() {
    }
    
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti (1000);
    }
    
    @Test
    public void luotuKassaOlemassa() {
        assertTrue(kassa!=null);
    }
    
    @Test
    public void kassaTaysi () {
        int saldo = 100000;
        assertEquals(saldo, kassa.kassassaRahaa());
    }
    
    @Test
    public void eiMyytyjaLounaita() {
        int maukkaat = 0;
        int edulliset = 0;
        assertEquals(maukkaat, kassa.maukkaitaLounaitaMyyty());
        assertEquals(edulliset, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void voiSyodaEdullisesti() {
        int maksu = 0;
        int toinenmaksu = 260;
        int saldo = 100480;
        int myydyt = 2;
        assertEquals(maksu, kassa.syoEdullisesti(240));
        assertEquals(toinenmaksu, kassa.syoEdullisesti(500));
        assertEquals(saldo, kassa.kassassaRahaa());
        assertEquals (myydyt, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void voiSyodaMaukkasti() {
        int maksu = 0;
        int toinenmaksu = 100;
        int saldo = 100800;
        int myydyt = 2;
        assertEquals(maksu, kassa.syoMaukkaasti(400));
        assertEquals(toinenmaksu, kassa.syoMaukkaasti(500));
        assertEquals(saldo, kassa.kassassaRahaa());
        assertEquals(myydyt, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void eiVoiSyodaEdullisestiIlmanRahaa() {
        int maksu = 230;
        int saldo = 100000;
        int myydyt = 0;
        assertEquals(maksu, kassa.syoEdullisesti(maksu));
        assertEquals(saldo, kassa.kassassaRahaa());
        assertEquals(myydyt, kassa.edullisiaLounaitaMyyty());
    }
    
        @Test
    public void eiVoiSyodaMaukkaastiIlmanRahaa() {
        int maksu = 230;
        int saldo = 100000;
        int myydyt = 0;
        assertEquals(maksu, kassa.syoMaukkaasti(maksu));
        assertEquals(saldo, kassa.kassassaRahaa());
        assertEquals(myydyt, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullisestiKortillaToimii() {
        int myydyt = 1;
        int saldo = 760;
        int kassanSaldo = 100000;
        assertTrue(kassa.syoEdullisesti(kortti));
        assertEquals(saldo, kortti.saldo());
        assertEquals(myydyt, kassa.edullisiaLounaitaMyyty());
        assertEquals(kassanSaldo, kassa.kassassaRahaa());
    }
    
        @Test
    public void maukkaastiKortillaToimii() {
        int myydyt = 1;
        int saldo = 600;
        int kassanSaldo = 100000;
        assertTrue(kassa.syoMaukkaasti(kortti));
        assertEquals(saldo, kortti.saldo());
        assertEquals(myydyt, kassa.maukkaitaLounaitaMyyty());
        assertEquals(kassanSaldo, kassa.kassassaRahaa());
    }
    
    @Test
    public void eiVoiSyodaEdullisestiIlmanRahaaKortilla() {
        int myydyt = 0;
        int saldo = 200;
        int kassanSaldo = 100000;
        kortti.otaRahaa(800);
        assertFalse(kassa.syoEdullisesti(kortti));
        assertEquals(saldo, kortti.saldo());
        assertEquals(myydyt, kassa.edullisiaLounaitaMyyty());
        assertEquals(kassanSaldo, kassa.kassassaRahaa());
    }
    
    @Test
    public void eiVoiSyodaMaukkaastiIlmanRahaaKortilla() {
        int myydyt = 0;
        int saldo = 200;
        int kassanSaldo = 100000;
        kortti.otaRahaa(800);
        assertFalse(kassa.syoMaukkaasti(kortti));
        assertEquals(saldo, kortti.saldo());
        assertEquals(myydyt, kassa.maukkaitaLounaitaMyyty());
        assertEquals(kassanSaldo, kassa.kassassaRahaa());
    }
    
    @Test
    public void voiLadataKortille() {
        int saldo = 2000;
        int lataus = 1000;
        int kassanSaldo = 101000;
        kassa.lataaRahaaKortille(kortti, lataus);
        assertEquals(saldo, kortti.saldo());
        assertEquals(kassanSaldo, kassa.kassassaRahaa());
    }
    
    @Test
    public void eiVoiLadataNegatiivista() {
        int saldo = 1000;
        int lataus = -500;
        int kassanSaldo = 100000;
        kassa.lataaRahaaKortille(kortti, lataus);
        assertEquals(saldo, kortti.saldo());
        assertEquals(kassanSaldo, kassa.kassassaRahaa());
    }
    
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
