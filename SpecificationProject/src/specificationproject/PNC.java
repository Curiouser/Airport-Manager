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
public class PNC extends Personne {


    public PNC(String FirstName, String LastName) {
        super(FirstName, LastName);
    }

    @Override
    public String toString() {
        return "PNC{" + "FirstName=" + FirstName + ", LastName=" + LastName + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (!(o.getClass() == PNC.class)) return false ;
        
        PNC p = (PNC) o;
        
        return (p.getFirstName() == this.FirstName);
       
        //return super.equals(o); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
