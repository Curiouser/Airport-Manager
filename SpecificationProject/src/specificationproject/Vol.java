/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specificationproject;

import java.util.Date;
import java.util.ListIterator;

/**
 *
 * @author Sonia
 */
public class Vol {

    private String NumeroVol;
    private Date Date;
    
    private String Destination;
    private String Site; //départ
    
    private Equipage Equipage;
    private Avion Avion;

    public Vol(String NumeroVol, Date Date, String Destination, String Site, Avion Avion) {
        this.NumeroVol = NumeroVol;
        this.Date = Date;
        this.Destination = Destination;
        this.Site = Site;
        this.Avion = Avion;
    }


    public String getNumeroVol() {
        return NumeroVol;
    }

    public Date getDate() {
        return Date;
    }

    public String getDestination() {
        return Destination;
    }

    public String getSite() {
        return Site;
    }

    public Equipage getEquipage() {
        return Equipage;
    }

    public Avion getAvion() {
        return Avion;
    }

    public void addEquipage(Equipage e) throws EquipageException {
        
        if (e.getNBPNC() <= this.getAvion().getTypeAvion().getMaxPNC()) {
            this.Equipage = e;
            System.out.println("Equipage ajouté : " + e.toString());
        
        }
        
        else {
            throw new EquipageException("Trop de PNC");
        }
    }
    
    public void addPilote(Pilote p) throws EquipageException {
        this.Equipage.addPilote(p);
    }

    public void addCopilote(Copilote c) throws EquipageException {
        this.Equipage.addCopilote(c);
    }

    public void addPNC(PNC p) throws EquipageException {
        if (this.Equipage.getNBPNC() < this.getAvion().getTypeAvion().getMaxPNC())
        {
            this.Equipage.getListePNC().add(p);
            System.out.println("Ajouté : " + p.toString());
        }
        else {
            throw new EquipageException("PNC au complet");
        }

    }
    
    public void removePNC(PNC p) throws EquipageException {
        if (this.Equipage.getListePNC().contains(p)) {
            this.Equipage.getListePNC().remove(p);
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
    

    public boolean equipageAuComplet(){
        if(this.Equipage.getPilote() != null
                && this.Equipage.getCopilote() != null
                && this.Equipage.getNBPNC() == this.getAvion().getTypeAvion().getMaxPNC()
                && this.Equipage.getNBPNC() >= this.getAvion().getTypeAvion().getMinPNC())
        {
            return true;
        }
        
        else {
            if (this.Equipage.getPilote() == null){
            System.out.println("Pas de pilote");            
            }
            
            if (this.Equipage.getCopilote() == null) {
                System.out.println("Pas de copilote");
            }
            
            if (this.Equipage.getNBPNC() < this.Avion.getTypeAvion().getMaxPNC()) {
                System.out.println("Pas complet");
            }
            
            if (this.Equipage.getNBPNC() > this.Avion.getTypeAvion().getMaxPNC()) {
                System.out.println("Trop de PNC");
            }
            return false;
        }
    }
    
    public boolean peutVoler(){
        boolean PNCQualif = true;
        boolean result = false;
        PNC previous;
        if (!this.Equipage.getListePNC().isEmpty())
        {
            ListIterator<PNC> iter = this.Equipage.getListePNC().listIterator(this.Equipage.getListePNC().size()-1);    
            iter.next();
            while(iter.hasPrevious()) {
            
                previous = iter.previous();
                if (!this.Avion.getTypeAvion().QualifContains(previous)){
                    PNCQualif = false ;
                    System.out.println(" Le PNC " + previous.toString() + " n'est pas qualifié pour le type " + this.Avion.getTypeAvion().toString());
                }
            }   
        
        if(this.Equipage.getPilote() != null 
                && this.Avion.getTypeAvion().QualifContains(this.Equipage.getPilote())
                && this.Equipage.getCopilote() != null
                && this.Avion.getTypeAvion().QualifContains(this.Equipage.getCopilote())
                && this.Equipage.getNBPNC() <= this.getAvion().getTypeAvion().getMaxPNC()
                && this.Equipage.getNBPNC() >= this.getAvion().getTypeAvion().getMinPNC()
                && PNCQualif)
            
        {
            result = true;
            System.out.println(" Autorisation de voler pour le vol : " + this.toString());
        }
        
        else {
            if (this.Equipage.getPilote() == null){
            System.out.println("Pas de pilote");            
            }
            
            if (this.Equipage.getCopilote() == null) {
                System.out.println("Pas de copilote");
            }
            
            if (this.Equipage.getNBPNC() < this.Avion.getTypeAvion().getMinPNC()) {
                System.out.println("Pas assez de PNC pour voler");
            }
            
            if (this.Equipage.getNBPNC() > this.Avion.getTypeAvion().getMaxPNC()) {
                System.out.println("Trop de PNC");
            }
            result = false;
            System.out.println(" Pas d'autorisation de voler pour le vol : " + this.toString());
        }
        
        
        }
        return result;
    
    }

    @Override
    public String toString() {
        return "Vol{" + "NumeroVol=" + NumeroVol + ", Date=" + Date + ", Destination=" + Destination + ", Site=" + Site + ", Equipage=" + Equipage + ", Avion=" + Avion + '}';
    }
    
    
}

    
    

