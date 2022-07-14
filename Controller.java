package clock;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


/*
* This was pre-coded but had to be amended to allow the check alarm method.  I have referenced
* a conversation with a tutor regarding how best to construct this class - 
* I have put it in references section.
* (Augusto, S. (2022) Conversation with Lauren Smart, 11 July 2022) 
* 
* @author Lauren Smart 19016480
*/
public class Controller {

    // class variables
    ActionListener listener;
    Timer timer;
    Model model;
    View view;

    // create an alarm list as an array list from alarm table model
    public static List<AlarmTableModel> ALARM_LIST = new ArrayList<>();
    // create a hashmap as they store arrays in an ordered collection and 
    // store data in key and value pairs 
    private Map<String, Boolean> alarmCheck = new HashMap<>();

    /*
    * constructor for controller
    */
    public Controller(Model m, View v) {
        model = m;
        view = v;

        // This section is based on an algorithm by - https://1bestcsharp.blogspot.com/2017/10/java-import-and-export-text-file-to-jtable.html
        // load alarms from saved file
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\PC\\Documents\\NetBeansProjects\\ClockForGraham_3\\ClockForGraham_3\\clock.txt"))) {
                String line = null;
                // clears the array list 
                Controller.ALARM_LIST.clear();
                
                while ((line = reader.readLine()) != null) {
                    String[] splitString = line.split(",");
                    if (splitString == null || splitString.length < 4) {
                        continue;
                    }
                    String name = splitString[0];
                    String date = splitString[1];
                    String hour = splitString[2];
                    String minute = splitString[3];
                    
                    //read alarm from file and save it to alarm list
                    AlarmTableModel alarmTableModel = new AlarmTableModel(name, date, hour, minute);
                    Controller.ALARM_LIST.add(alarmTableModel);
                }
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }
        listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.update();
                // call method to check alarm
                checkAlarm();
            }
        };

        timer = new Timer(100, listener);
        timer.start();
    }
    
    /*
    * This method checks the system clock against the set alarm time and outputs if
    * matches.  I have referenced assistance from a conversation with a 
    * I have referenced the enhanced for loop section in order to code this section:
    * https://stackoverflow.com/questions/13967499/convert-string-into-date-format
    * 
    * 
    */ 
    private void checkAlarm() 
    {
     
        // checks current time using date import
        Date now = new Date(System.currentTimeMillis());
        // create a new date and time format
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
        // format the string
        String date = sdf.format(now);
        
        // (Augusto,S, 2022)
        // enhanced for loop (on code suggestion)
        for(AlarmTableModel item : ALARM_LIST)
        {
            // set alarm date and hour and minute to string 
            String alarmTime = item.getDate() + " " + item.getHour() + ":" + item.getMinute();  //.trim();
            if(alarmTime.equals(date)){
                String checkArrayKey = date + " " + item.getName();
                //check this alarm is checked before or not
                if(alarmCheck.get(checkArrayKey) == null || !alarmCheck.get(checkArrayKey)){
                      JPanel panel = new JPanel();
                    JOptionPane.showMessageDialog(panel,"Alarm at " + date + " : " + item.getName());
                
                   // this stops the recurring output of confirm dialog alarm popup
                    alarmCheck.put(date + " " + item.getName(), true);
               
                    alarmCheck.remove(checkArrayKey);
                }
                
            }
        }
    }
}
