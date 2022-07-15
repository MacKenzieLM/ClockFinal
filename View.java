package clock;

import static clock.Controller.ALARM_LIST;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;
import java.util.Observer;
import java.util.Observable;

/**
 * This class uses a table to output the alarm times and alarm names. I have
 * used a YouTube tutorial as a template and adjusted with my own labels and
 * spinners. References - https://www.youtube.com/watch?v=5MW9DEK_oTw (going
 * from menu button to opening classes)
 * @author Lauren Smart 19016480
 */
public class View implements Observer {

    // class variables
    ClockPanel panel;
    JMenuBar menuBar;
    JMenu menu;
    JMenu menu2;
    JMenuItem setAlarm;
    JMenuItem about;
    JMenuItem exit;
    // call the classes from menu buttons
    static SetAlarm3 alarm;
    boolean editAlarmString;
    String alarmTimeString;
    JButton nextButton;
    
   
    /**
     * Constructor
     * @param model 
     */
    public View(Model model) 
    {
        super();
        
        JFrame frame = new JFrame();
        panel = new ClockPanel(model);
       
        frame.setTitle("Java Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Container pane = frame.getContentPane();
    
        // create new menu bar
        menuBar = new JMenuBar();
        // set the menu bar  colour to green
        menuBar.setBackground(Color.green);
        // first section of menu bar
        menu = new JMenu("Menu");
        // next section of menu bar
        menu2 = new JMenu("About");
        //add items to first section of menu bar
        setAlarm = new JMenuItem("Set Alarm");
     //   alarmList = new JMenuItem("Alarm List");
   
        // add items to second section of menu bar
        about = new JMenuItem("About");
        exit = new JMenuItem("Exit");
       
        // add items to menu
        menu.add(setAlarm);
     
      //  menu.add(alarmList);
        
        // add items to file menu
        menu2.add(about);
        menu2.add(exit);
        
    /**
     * Set alarm button
     *
     */
        setAlarm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                    
                     if (e.getSource().equals(setAlarm)) 
                     {
                        // calls set alarm
                        SetAlarm3 setAlarm3 = new SetAlarm3();
                     
                        setAlarm3.setVisible(true);
        }
             
         }
        });
        
    /**
     * About page button
     *  
     */
          // menu item to take user to about page
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                     if (e.getSource().equals(about)) {
          
                        // calls iCalendar 
                        About file = new About();
                   }   
                }
        }); 
         
  
     /**
     * exit button
     *  
     */
        class exit implements ActionListener{
            
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        }
        exit.addActionListener(new exit());
                          
        // add menu to menu bar
        menuBar.add(menu);
        menuBar.add(menu2);
  
         
        // adds menu bar to start of page
        pane.add(menuBar, BorderLayout.PAGE_START);
        // brings the clock panel to frame
        panel.setPreferredSize(new Dimension(500, 500));
        pane.add(panel, BorderLayout.CENTER);
        AlarmTableModel date = null;
        AlarmTableModel name = null;
       
     
        // End of borderlayout code
        
        frame.pack();
        frame.setVisible(true);
     
    }
    
    /**
    * Method to repaint the clock panel 
    */
    @Override
    public void update(Observable o, Object arg) {
        panel.repaint();
        
    }
}
