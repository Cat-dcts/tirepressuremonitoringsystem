package fr.unilim.iut.tirepressuremonitoringsystem;

public class Alarm
{
    private final double lowPressureThreshold = 17;
    private final double highPressureThreshold = 21;

    Sensor sensor = new Sensor();

    boolean alarmOn = false;

    public Alarm(Sensor sensor){
    	this.sensor = sensor;
    }
    
    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (isNotSafe(psiPressureValue))
        {
            activateAlarm(); 
        }
    }

	private boolean isNotSafe(double psiPressureValue) {
		return psiPressureValue < lowPressureThreshold || highPressureThreshold < psiPressureValue;
	}

	private void activateAlarm() {
		alarmOn = true;
	}

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
