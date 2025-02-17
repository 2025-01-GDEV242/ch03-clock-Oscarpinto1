
/**
 * 12 hour internal
 * 
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString; 
    private String maridean;
    
    
    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        maridean= "AM";
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute, String maridean)
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        this.maridean= maridean.toUpperCase();
        setTime(hour, minute);
        
        //maridean = "am"; This is incorrect because it is being passed as a specific string

        
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) 
        {  // it just rolled over!
            hours.increment();
        
        
        if(hours.getValue()==0 )
    
        {
        maridean = maridean.equals("AM") ? "PM" : "AM";
        }
       
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        if (hour==12)
        {
            hours.setValue(0);
        }
        else
        {
            hours.setValue(hour);
        }
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
       int displayHour = hours.getValue();
       
        
        
        
        if (displayHour==0 ) //original work am
        {
            displayHour=12;
           
           
        }
        
        displayString= displayHour + ":" + minutes.getDisplayValue()+ "" + maridean;
    }
}
