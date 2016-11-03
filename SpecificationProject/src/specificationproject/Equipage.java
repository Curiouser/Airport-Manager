/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specificationproject;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Sonia
 */
public class Equipage {

    private Pilote Pilote;
    private Copilote Copilote;
    private ArrayList<PNC> ListePNC;


    public Equipage() {
        this.Pilote = null;
        this.Copilote = null;
        this.ListePNC = new ArrayList<>();
    }

    public Pilote getPilote() {
        return Pilote;
    }

    public Copilote getCopilote() {
        return Copilote;
    }
    
    public List<PNC> getListePNC() {
        return ListePNC;
    }
    
    public int getNBPNC() {
        return this.ListePNC.size();
    }

    public void addPilote(Pilote p) throws EquipageException {
        if (Pilote == null) {
            this.Pilote = p;
            System.out.println("Ajouté : " + p.toString());
        } else {
            throw new EquipageException("méthode addPilote");
        }
    }

    public void addCopilote(Copilote c) throws EquipageException {
        if (Copilote == null) {
            this.Copilote = c;
            System.out.println("Ajouté : " + c.toString());
        } else {
            throw new EquipageException("méthode addCopilote");
        }
    }

    public void addPNC(PNC p) throws EquipageException {
        if (!this.ListePNC.contains(p)) {
            this.ListePNC.add(p);
            System.out.println("Ajouté : " + p.toString());
        }  
        
        else {
            throw new EquipageException("Le PNC " + p.toString() + " est déjà présent dans l'équipage.");
        }
        
    }
    
    public void removePNC(PNC p) throws EquipageException {
        if (this.ListePNC.contains(p)) {
            this.ListePNC.remove(p);
            System.out.println("Le PNC a été éjecté de l'équipage : " + p.toString());
        }
        
        else {
            throw new EquipageException("Il n'y a pas ce PNC dans l'équipage " + p.toString());
        }
    }
    
    public void removePNC(String first, String last) throws EquipageException {
        PNC p = new PNC(first, last);
        this.removePNC(p);
    }
    

    public boolean contains(Personne membre) {
        boolean result = false;
        
        // ce n'est pas un bon plan de lancer une exception à chaque if parce que du coup si le mec est copilote l'exception est déjà lancée

        if (this.Pilote == membre) {
            result = true;
            System.out.println("L'équipage contient le membre " + membre.toString() + " en tant que pilote");
        }

        if (this.Copilote == membre) {
            result = true;
            System.out.println("L'équipage contient le membre " + membre.toString() + " en tant que copilote");
        }
        
        if (membre.getClass() == PNC.class) {
            
            if(listContains((PNC)membre)){
                result = true;
                System.out.println("L'équipage contient le membre " + membre.toString() + " en tant que PNC");
            }
        }
       
        
        if(result == false)
        {
            System.out.println("L'équipage ne contient pas ce membre. " + membre.toString());
        }
        
        return result;
    }
    
    /*public boolean contains(String first, String last) {
        Personne p = new Personne(first, last);
        boolean result;
        result = this.contains(p);
        return result;
    }*/
    
    public boolean listContains(PNC membre){
        boolean result = false;
        PNC previous;
        if (!this.ListePNC.isEmpty())
        {
            ListIterator<PNC> iter = this.ListePNC.listIterator(this.ListePNC.size()-1);    
            iter.next();
            while(iter.hasPrevious()) {
            
                previous = iter.previous();
                if ((previous.getFirstName().equals(membre.getFirstName())) 
                        && (previous.getLastName().equals(membre.getLastName()))){
                    result = true ;
                }
            }   
        }
                     
        return result;
    }
    
    @Override
    public String toString() {
        return "Equipage{" + "Pilote=" + Pilote + ", Copilote=" + Copilote + ", ListePNC=" + ListePNC + '}';
    }
}
