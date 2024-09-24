package fr.unilim.iut.tirepressuremonitoringsystem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class AlarmTest {

	@Test
	void AlarmOnWhenLowPressureTest() {
		Sensor sensor = probeValue(16.0);
		Alarm alarm = new Alarm(sensor);
		
		
		alarm.check();
		
		assertTrue(alarm.isAlarmOn());
	}

	@Test
	void AlarmOffWhenPressureGoodTest() {
		Sensor sensor = probeValue(18.0);
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		
		assertFalse(alarm.isAlarmOn());
	}

	@Test
	void AlarmStayOnTest() {
		Sensor sensor = probeValue(16.0,18.0);
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		alarm.check();
		
		assertTrue(alarm.isAlarmOn());
	}

	@Test
	void AlarmOnWhenHighPressureTest() {
	
		Sensor sensor = probeValue(22.0);
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		
		assertTrue(alarm.isAlarmOn());
	}

	private Sensor probeValue(double value) {
		Sensor sensor = mock(PressureSensor.class);
		when(sensor.probeValue()).thenReturn(value);
		return sensor;
	}
	
	private Sensor probeValue(double value1,double value2) {
		Sensor sensor = mock(PressureSensor.class);
		when(sensor.probeValue()).thenReturn(value1,value2);
		return sensor;
	}
}
