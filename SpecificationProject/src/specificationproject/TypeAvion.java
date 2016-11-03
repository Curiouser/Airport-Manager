/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specificationproject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sonia
 */
public class TypeAvion {
    
    private String Nom;
    private ArrayList<Personne> PersonnesQual;
    private Integer minPNC;
    private Integer maxPNC;

    
    public TypeAvion(String Nom, Integer minPNC, Integer maxPNC) {
        this.Nom = Nom;
        this.minPNC = minPNC;
        this.maxPNC = maxPNC;
        this.PersonnesQual = new ArrayList();
    }
    
    public String getNom() {
        return Nom;
    }

    public ArrayList<Personne> getPersonnesQual() {
        return PersonnesQual;
    }

    public Integer getMinPNC() {
        return minPNC;
    }

    public Integer getMaxPNC() {
        return maxPNC;
    }
    
    
    
    
    public void addQualifie(Personne p) throws EquipageException
    {
        if ( p != null && !this.PersonnesQual.contains(p)) // pas tester cela, par contre tester si la personne est null et pas dans la liste 
        {
            PersonnesQual.add(p);
            System.out.println("La personne " + p.toString() + " est qualifiée pour le type " + this.Nom);
        }
        
        else
        {
            throw new EquipageException(" La personne est null ou déjà présente");
        }
    }
    
    public void delQualifie(Personne p) throws EquipageException
    {
        if  (p != null && this.PersonnesQual.contains(p))  // pas tester ça
        {
            PersonnesQual.remove(p);
            System.out.println("La personne " + p.toString() + " n'est plus qualifiée pour le type " + this.Nom);
        }
        
        else
        {
            throw new EquipageException(" La personne est nulle ou pas dans la liste");
        }
    }
    
    public boolean QualifContains(Personne p) {
        boolean result = false;
        
        if (this.PersonnesQual.contains(p)) {
            result = true;
            System.out.println("La personne " + p.toString() + " est qualifiée pour le type " + this.Nom);
        }
        
        return result;
    }
    
    
    /*
 
public void purgeQualifies() throws EquipageException, InvariantBroken

    */

    @Override
    public String toString() {
        return "TypeAvion{" + "Nom=" + Nom + ", PersonnesQual=" + PersonnesQual + ", minPNC=" + minPNC + ", maxPNC=" + maxPNC + '}';
    }
}
