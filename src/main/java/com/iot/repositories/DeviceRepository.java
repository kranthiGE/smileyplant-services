package com.iot.repositories;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.iot.domain.Device;

@Repository
public class DeviceRepository {

	static Map<Integer, Device> devices;
	
	static {
		devices = new HashMap<Integer, Device>();
		
		//Motor device
		Device motor = new Device();
		motor.setName("Water Pump");
		motor.setId(101);
		motor.setState(0);
		
		devices.put(101, motor);
	}
	
	public Map<Integer, Device> getDevices(){
		return devices;
	}
}
