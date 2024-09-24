package fr.unilim.iut.tirepressuremonitoringsystem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class AlarmTest {

	@Test
	void AlarmOnWhenLowPressureTest() {
		Alarm alarm = new Alarm();
		Sensor sensor = mock(Sensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(16.0);
		alarm.sensor = sensor;
		
		alarm.check();
		
		assertTrue(alarm.isAlarmOn());
	}

	@Test
	void AlarmOnWhenHighPressureTest() {
		Alarm alarm = new Alarm();
		Sensor sensor = mock(Sensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(22.0);
		alarm.sensor = sensor;
		
		alarm.check();
		
		assertTrue(alarm.isAlarmOn());
	}
	
	@Test
	void AlarmOffWhenPressureGoodTest() {
		Alarm alarm = new Alarm();
		Sensor sensor = mock(Sensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(18.0);
		alarm.sensor = sensor;
		
		alarm.check();
		
		assertFalse(alarm.isAlarmOn());
	}
	
	@Test
	void AlarmStayOnTest() {
		Alarm alarm = new Alarm();
		Sensor sensor = mock(Sensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(16.0,18.0);
		alarm.sensor = sensor;
		
		alarm.check();
		alarm.check();
		
		assertTrue(alarm.isAlarmOn());
	}
}
