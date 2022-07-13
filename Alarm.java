
package clock;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import javax.swing.Timer;
/**
 *
 * @author PC
 */
public class Alarm {
    
    private Alarm loadAlarms;
   
    
    public void init()
    {

        this.loadAlarms(loadAlarms);

        //Set up the timer to call update every 1 second
        Timer updateTimer = new javax.swing.Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                this.update();
            }

            private void update() {
               
            }
        });
        //set the initial delay to be the number of remaining milliseconds in the
        //current second
        updateTimer.setInitialDelay(1000 - new DateTime().getMillisOfSecond());
        
        updateTimer.start();
    }

    private Alarm getLoadAlarms() {
      return loadAlarms;
    }

    private void loadAlarms(Alarm loadAlarms) {
       
    }
}
