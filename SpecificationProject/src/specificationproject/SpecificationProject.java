/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specificationproject;

import java.util.Date;

/**
 *
 * @author Sonia
 */
public class SpecificationProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
            
        TypeAvion t1 = new TypeAvion("SolarImpulse",1,1);
        Avion a1 = new Avion(t1,"SIA");
        
        Date d1 = new Date(21/01/1515);
        Vol Vol1 = new Vol("01", d1, "Moon", "Londres", a1);
        Equipage E1 = new Equipage();
        
        Pilote p1 = new Pilote("André", "Borschberg");
        Copilote c1 = new Copilote("Bertrand", "Picard");
        PNC n1 = new PNC("Jean-Jacques", "Arnaud PNC1");
        PNC n2 = new PNC("Y", "Z PNC2");
        
        E1.addPilote(p1); 
        E1.addCopilote(c1);
        //E1.addPNC(n1);
        //E1.addPNC(n2);        
        //E1.removePNC(n2);             
        //E1.removePNC("Jean-Jacques", "Arnaud");        

        E1.contains(p1);
        E1.contains(c1);
        E1.contains(n1);
        E1.contains(n2);
        
        System.out.println("toto");
        
        Vol1.addEquipage(E1);
        Vol1.addPNC(n1);
        Vol1.getEquipage().contains(n1);
        System.out.println("test du addPNC de Vol et du contains");
        
        //Vol1.addPNC(n2);
        //Vol1.getEquipage().contains(n2);
        
        System.out.println("test qualif");
        t1.addQualifie(p1);
        t1.QualifContains(p1);
        t1.addQualifie(c1);
        t1.addQualifie(n1);
        
        Vol1.peutVoler();
        
        TableauVols tab = new TableauVols();
        tab.addVol(Vol1);
        
        }
        
        catch(EquipageException e)
        {
            System.out.println(e.toString());
            e.printStackTrace(System.out);
        }
    }
    
}
