/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import specificationproject.Avion;
import specificationproject.Copilote;
import specificationproject.Equipage;
import specificationproject.EquipageException;
import specificationproject.EquipageTest;
import specificationproject.PNC;
import specificationproject.Pilote;
import specificationproject.TypeAvion;
import specificationproject.Vol;

/**
 *
 * @author Sonia
 */
public class IntegrationTest {
    
    private TypeAvion t1;
    private Avion a1;
    private Pilote p1;
    private Copilote c1;
    private PNC pnc11;
    private PNC pnc12;
    private PNC pnc13;
    private ArrayList<PNC> ListePNC;
    private Equipage E1;
    private String numVol1;
    private String dest1;
    private String site1;
    private Date d1;
    
    private Date d2;
    private TypeAvion t2;
    private Avion a2;
    private Pilote p2;
    private Copilote c2;
    private PNC pnc21;
    private PNC pnc22;
    private PNC pnc23;
    private PNC pnc24;
    private Equipage E2;
    private String numVol2;
    private String dest2;
    private String site2;
    
    private Vol Vol1;
    private Vol Vol2;
    
    
    public IntegrationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws EquipageException {
        try {
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
               
               Vol1.addEquipage(E1);
               
               numVol2 = "AF545";
               dest2 = "New-York";
               site2 = "Roissy";
        
               Vol2 = new Vol(numVol2, d2, dest2, site2, a2);
               
               E2 = new Equipage();
               
               p2 = new Pilote("Jacques", "Vlisside");
               c2 = new Copilote("Jean-Louis", "Dupont");
               pnc21 = new PNC("Ségolène", "Orval");
               pnc22 = new PNC("François", "Saadi");
               pnc23 = new PNC("Nicolas", "Harper");
               pnc24 = new PNC("Surplus", "Surplus"); 
               
               E2.addPilote(p2);
               E2.addCopilote(c2);
               E2.addPNC(pnc21);
               E2.addPNC(pnc22);
               E2.addPNC(pnc23); 
               //E2.addPNC(pnc24);
               
               Vol2.addEquipage(E2);
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
    }
    
    /*
        Ce test vérifie qu'un équipage valide est bien ajouté à la classe Vol
    */
    @Test
    public void testAddEquipage() throws Exception {
        System.out.println("test addEquipage");
        assertEquals(E1, Vol1.getEquipage());
        assertEquals(p1, Vol1.getEquipage().getPilote());
        assertEquals(c1, Vol1.getEquipage().getCopilote());
        assertEquals(ListePNC, Vol1.getEquipage().getListePNC());
    }
    
    /*
        Ce test vérifie qu'un équipage avec trop de PNC n'est pas accepté en Vol
    */
    @Test
    public void testAddEquipage2() throws Exception {
        System.out.println("test addEquipage2");
        try{
            Vol2.addPNC(pnc24);
            fail("No EquipageException"); // FAIL when no exception is thrown
            } 
        
        catch (EquipageException e) {
            assertTrue(e.hasMessage());
            }       
       
    }
   
    
    /*
        Ce test vérifie que la méthode getEquipage de la classe Vol réussit à récupérer 
        les membres de l'équipage qui lui a été ajouté
    */
    @Test
    public void testGetEquipage() throws Exception {
        System.out.println("test getEquipage");
        assertEquals(p1, Vol1.getEquipage().getPilote()); 
        assertEquals(c1, Vol1.getEquipage().getCopilote());
        assertEquals(ListePNC , Vol1.getEquipage().getListePNC());
      
    }
    
     /**
     * Test of addPNC method, of class Vol.
     */
    @Test
    public void testAddPNC() {
        System.out.println("addPNC");
        
        try {
            Vol1.removePNC(pnc11); // méthode déjà testée
            Vol1.addPNC(pnc11);
            assertTrue(Vol1.getEquipage().contains(pnc11));
            
        }
        catch(EquipageException e)
        {
            System.out.println(e.toString());
        }
    }
    
        /**
     * Test 2 of addPNC method, of class Vol. We expect it to fail.
     */
    @Test
    public void testAddPNC2() {
        System.out.println("addPNC");
        
        try {
            Vol1.addPNC(pnc11);
            fail("EquipageException not thrown in testAddPNC2 ");
            
        }
        catch(EquipageException e)
        {
            assertTrue(e.hasMessage());
        }
    }
    
}

    
