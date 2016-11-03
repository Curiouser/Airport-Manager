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
public class TableauVols {
    private List<Vol> ListeVols;

    public TableauVols() {
        this.ListeVols = new ArrayList();
    }

    public List<Vol> getListeVols() {
        return ListeVols;
    }
    
    public void addVol(Vol v) throws EquipageException {
        if (v.peutVoler()){
            this.ListeVols.add(v);
            System.out.println("Le vol " + v.toString() + " a été ajouté au tableau de vols.");
        }
        else {
            throw new EquipageException("Le vol " + v.toString() + " ne peut pas voler.");
        }
        
    }
    
    
    
}
