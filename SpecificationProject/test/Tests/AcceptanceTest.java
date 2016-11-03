/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import specificationproject.Avion;
import specificationproject.Avion;
import specificationproject.Copilote;
import specificationproject.Copilote;
import specificationproject.Equipage;
import specificationproject.Equipage;
import specificationproject.PNC;
import specificationproject.Pilote;
import specificationproject.TypeAvion;
import specificationproject.Vol;
import specificationproject.EquipageException;
import specificationproject.EquipageException;
import specificationproject.PNC;
import specificationproject.Pilote;
import specificationproject.TypeAvion;
import specificationproject.Vol;

/**
 *
 * @author Sonia
 */
public class AcceptanceTest {
    
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
    
    /*private Date d2;
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
    private String site2;*/
    
    private Vol Vol1;
    //private Vol Vol2;
    
    public AcceptanceTest() {
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
               a1 = new Avion(t1,"13562");              
               d1 = new Date(11/10/3006);
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
               
               E1.addPilote(p1);
               E1.addCopilote(c1);
               E1.addPNC(pnc11);
               E1.addPNC(pnc12);
               E1.addPNC(pnc13);
               
               ListePNC = new ArrayList();
               
               ListePNC.add(pnc11);
               ListePNC.add(pnc12);
               ListePNC.add(pnc13);
               
               Vol1.addEquipage(E1);
               /*
               TypeAvion t2 = new TypeAvion("B747",1,3);
               Avion a2 = new Avion(t2,"32156");
               Date d2 = new Date(12/10/3006);
               String numVol2 = "AF545";
               String dest2 = "New-York";
               String site2 = "Roissy";
        
               Vol Vol2 = new Vol(numVol2, d2, dest2, site2, a2);
               Equipage E2 = new Equipage();
               Pilote p2 = new Pilote("Jacques", "Vlisside");
               Copilote c2 = new Copilote("Jean-Louis", "Dupont");
               PNC pnc21 = new PNC("Ségolène", "Orval");
               PNC pnc22 = new PNC("François", "Saadi");
               PNC pnc23 = new PNC("Nicolas", "Harper");
               E2.addPilote(p2);
               E2.addCopilote(c2);
               E2.addPNC(pnc21);
               E2.addPNC(pnc22);
               E2.addPNC(pnc23);*/
               
               t1.addQualifie(p1);
               t1.addQualifie(c1);
               t1.addQualifie(pnc11);
               t1.addQualifie(pnc12);
               t1.addQualifie(pnc13);
        }
        catch(EquipageException e)
        {
            System.out.println(e.toString());
        }
               
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testPeutVoler() throws Exception {
        System.out.println("test peutVoler");
        
        assertEquals(Vol1.getEquipage().getPilote(), p1);
        assertEquals(Vol1.getEquipage().getCopilote(), c1);
        assertEquals(Vol1.getEquipage().getListePNC(), ListePNC);
        assertTrue(Vol1.getEquipage().getNBPNC() <= Vol1.getAvion().getTypeAvion().getMaxPNC());
        assertTrue(Vol1.getEquipage().getNBPNC() >= Vol1.getAvion().getTypeAvion().getMinPNC());
        
        assertTrue(Vol1.getAvion().getTypeAvion().QualifContains(p1));
        assertTrue(Vol1.getAvion().getTypeAvion().QualifContains(c1));
        assertTrue(Vol1.getAvion().getTypeAvion().QualifContains(pnc11));
        assertTrue(Vol1.getAvion().getTypeAvion().QualifContains(pnc12));
        assertTrue(Vol1.getAvion().getTypeAvion().QualifContains(pnc13));
        
        assertTrue(Vol1.peutVoler()); 
                               
    }
}
