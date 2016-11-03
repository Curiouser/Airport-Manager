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
public class Avion {
    TypeAvion TypeAvion;
    String ref;

    public Avion(TypeAvion TypeAvion, String ref) {
        this.TypeAvion = TypeAvion;
        this.ref = ref;
    }

    public TypeAvion getTypeAvion() {
        return TypeAvion;
    }

    public String getReference() {
        return ref;
    }

    @Override
    public String toString() {
        return "Avion{" + "TypeAvion=" + TypeAvion + ", ref=" + ref + '}';
    }
    
     
    
    
}
