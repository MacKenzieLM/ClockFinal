/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

/**
 *
 * @author PC
 */
public class DateTime {

    private int millisOfSecond;
    private String dayOfMonth;
    DateTime dateTime;
    DateTime setSpinner;
    
    public DateTime(DateTime value) {
   
    }

    DateTime() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public boolean isBeforeNow() {
        return false;
        
    }

     public String getDayOfMonth() {
     
        return dayOfMonth;
        
    }

    public int getMillisOfSecond() {
        return millisOfSecond;
       
    }
    
     public DateTime getDateTime() {
        return dateTime;
       
    }

    Object dayOfMonth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Object millisOfDay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
