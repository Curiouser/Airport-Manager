/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specificationproject;

/**
 *
 * @author Sonia
 */
public class Pilote extends Personne {
    
    /* private String FirstName;
    private String LastName; */

    public Pilote(String FirstName, String LastName) {
        super(FirstName, LastName);
    }

    @Override
    public String toString() {
        return "Pilote{" + "FirstName=" + FirstName + ", LastName=" + LastName + '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (!(o.getClass() == PNC.class)) return false ;
        
        Pilote p = (Pilote) o;
        
        return (p.getFirstName() == this.FirstName);
       
        //return super.equals(o); //To change body of generated methods, choose Tools | Templates.
    }
    
}
