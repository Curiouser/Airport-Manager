/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specificationproject;

import java.util.List;

/**
 *
 * @author Sonia
 */
public class Personne {

   

    protected String FirstName; // je l'avais mis en private et du coup les classes filles ne le connaissaient pas et les champs n'étaient pas initialisés par les sous constructeurs
    protected String LastName;
    
    private List<TypeAvion> ListeTypeVols;

    //en réalité, la classe Personne correspond à MembreEquipage dans le sujet en français
    public Personne(String FirstName, String LastName) {
        this.FirstName = FirstName;
        this.LastName = LastName;
    }
    
/*
public boolean peutVoler(TypeAvion t)
public boolean addQualification(TypeAvion type) throws EquipageException, InvariantBroken
public boolean delQualification(TypeAvion type, boolean fromType) */

    @Override
    public String toString() {
        return "Personne{" + "FirstName=" + FirstName + ", LastName=" + LastName + '}';
    }

    
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (!(o.getClass() == PNC.class)) return false ;
        
        Personne p = (Personne) o;
        
        return (p.getFirstName() == this.FirstName && p.getLastName() == this.LastName);
       
        //return super.equals(o); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
