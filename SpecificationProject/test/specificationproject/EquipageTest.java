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
public class EquipageTest extends TestCase {
    
    private Pilote p1;
    private Copilote c1;
    private PNC pnc11;
    private PNC pnc12;
    private PNC pnc13;
    private ArrayList<PNC> ListePNC;
    private Equipage E1;
    
    private Pilote p2;
    private Copilote c2;
    private PNC pnc21;
    private PNC pnc22;
    private PNC pnc23;
    private Equipage E2;      
    
    public EquipageTest() {
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
              
              super.setUp();                             
               E1 = new Equipage();        
               p1 = new Pilote("Corinne", "Lancel");        
               c1 = new Copilote("Amy", "Bosch");
               pnc11 = new PNC("Maureen", "Gates");
               pnc12 = new PNC("Richard", "Tata");
               pnc13 = new PNC("Ben", "Gamma");      
               
               ListePNC = new ArrayList<PNC>();               
               ListePNC.add(pnc11);
               ListePNC.add(pnc12);
               ListePNC.add(pnc13);  
               
               E1.addPilote(p1);
               E1.addCopilote(c1);
               E1.addPNC(pnc11);
               E1.addPNC(pnc12);
               E1.addPNC(pnc13);
               
               E2 = new Equipage();
               
               p2 = new Pilote("Jacques", "Vlisside");
               c2 = new Copilote("Jean-Louis", "Dupont");
               pnc21 = new PNC("Ségolène", "Orval");
               pnc22 = new PNC("François", "Saadi");
               pnc23 = new PNC("Nicolas", "Harper");
               
               E2.addPilote(p2);
               E2.addCopilote(c2);
               E2.addPNC(pnc21);
               E2.addPNC(pnc22);
               E2.addPNC(pnc23); 
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
        E1 = null;
        E2 = null;
        
    }
    
    @Test
    public void testEquipage() {
        assertNotNull("équipage not null", E1);
    }

    /**
     * Test of getPilote method, of class Equipage.
     */
    @Test
    public void testGetPilote() throws EquipageException {       
        assertEquals(p1, E1.getPilote());
    }

    /**
     * Test of getCopilote method, of class Equipage.
     */
    @Test
    public void testGetCopilote() {
        assertEquals("test getcopilote", E1.getCopilote(), c1);
    }

    /**
     * Test of getListePNC method, of class Equipage.
     */
    @Test
    public void testGetListePNC() {
        assertEquals("test getListe", ListePNC, E1.getListePNC() );
       
    }

    /**
     * Test of getNBPNC method, of class Equipage.
     */
    @Test
    public void testGetNBPNC() {
        assertEquals("test getNBPNC", ListePNC.size(),E1.getNBPNC());
    }

    /**
     * Test of addPilote method, of class Equipage.
     */
    @Test
    public void testAddPilote() throws Exception {
        assertEquals("test addPilote", p1, E1.getPilote());
    }

    /**
     * Test of addCopilote method, of class Equipage.
     */
    @Test
    public void testAddCopilote() throws Exception {
        assertEquals("test addCopilote", c1, E1.getCopilote());
    }

    /**
     * Test of contains method, of class Equipage.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        assertTrue(E1.contains(pnc11));
    }
    
}
