package fr.unilim.iut.tirepressuremonitoringsystem;

public class Alarm
{
    private final double lowThreshold = 17;
    private final double highThreshold = 21;

    private Sensor sensor = new PressureSensor();

    private boolean alarmOn = false;

    public Alarm() {
    	this(new PressureSensor());
    }
    
    public Alarm(Sensor sensor){
    	this.sensor = sensor;
    	this.alarmOn = false;
    }
    
    public void check()
    {
        double value = probe();

        if (isNotSafe(value))
        {
            activateAlarm(); 
        }
    }

	private boolean isNotSafe(double value) {
		return value < lowThreshold || highThreshold < value;
	}

	private void activateAlarm() {
		alarmOn = true;
	}

	private double probe() {
		return sensor.probeValue();
	}
	
    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
