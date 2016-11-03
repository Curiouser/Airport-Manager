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
public class EquipageException extends Exception {

    private String message;
    
    /*public EquipageException() {
    }*/
    // that way an Exception always has a message

    public EquipageException(String msg) {
        super(msg);
        message = msg;
    }
    
    public boolean hasMessage() {
        boolean result = true;
        if (this.message == null) {
            result = false;
        }
        
        return result;
    }

    @Override
    public String toString() {
        return "EquipageException{" + "message=" + message + '}';
    }
    
    
    
}
