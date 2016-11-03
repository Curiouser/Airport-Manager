/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specificationproject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sonia
 */
public class VolTest {
    
    TypeAvion t1;
    Avion a1;
    Pilote p1;
    Copilote c1;
    PNC pnc1;
    PNC pnc2;
    PNC pnc3;
    ArrayList<PNC> ListePNC;
    private Equipage E1;
    String numVol1;
    String dest1;
    String site1;
    Date d1;
    Date d2;
    
    TypeAvion t2;
    Avion a2;
    Pilote p2;
    Copilote c2;
    PNC pnc21;
    PNC pnc22;
    PNC pnc23;
    Equipage E2;
    String numVol2;
    String dest2;
    String site2;
    
    Vol Vol1;
    Vol Vol2;
    
    public VolTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
          try{
              
              t1 = new TypeAvion("A320",1,3);
               t2 = new TypeAvion("B747",1,3);
        
               a1 = new Avion(t1,"13562");
               a2 = new Avion(t2,"32156");
        
               d1 = new Date(11/10/3006);
               d2 = new Date(12/10/3006);
                                              
               numVol1 = "AF347";
               
               dest1 = "Londres";
               site1 = "Orly";
        
               Vol1 = new Vol(numVol1, d1, dest1, site1, a1);
        
               
               E1 = new Equipage();
        
               p1 = new Pilote("Corinne", "Lancel");        
               c1 = new Copilote("Amy", "Bosch");
               pnc1 = new PNC("Maureen", "Gates");
               pnc2 = new PNC("Richard", "Tata");
               pnc3 = new PNC("Ben", "Gamma");
               
               ListePNC = new ArrayList<PNC>();
               
               ListePNC.add(pnc1);
               ListePNC.add(pnc2);
               ListePNC.add(pnc3);
               
               E1.addPilote(p1);
               E1.addCopilote(c1);
               E1.addPNC(pnc1);
               E1.addPNC(pnc2);
               E1.addPNC(pnc3);
               
               Vol1.addEquipage(E1);
        }
        catch(EquipageException e)
        {
            System.out.println(e.toString());
        } catch (Exception ex) {
            Logger.getLogger(EquipageTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
        Vol1 = null ;
    }

    /**
     * Test of getNumeroVol method, of class Vol.
     */
    @Test
    public void testGetNumeroVol() {
        assertEquals("AF347", Vol1.getNumeroVol());
    }
    
    /**
     * Test of getEquipage method, of class Vol.
     */
    @Test
    public void testGetEquipage() {
        System.out.println("getEquipage");
        assertEquals(p1, Vol1.getEquipage().getPilote());
        assertEquals(c1, Vol1.getEquipage().getCopilote());
        assertEquals(ListePNC, Vol1.getEquipage().getListePNC());
    }
    
    /**
    *  Test of the removePNC method of class Vol.
    */
    @Test
    public void testRemovePNC() {
        System.out.println("removePNC");
        try {
            Vol1.removePNC(pnc1);
            assertFalse(Vol1.getEquipage().contains(pnc1));
        }
        catch(EquipageException e)
        {
            System.out.println(e.toString());
        }
    }
    
   

    
}