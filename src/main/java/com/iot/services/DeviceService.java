package com.iot.services;

import java.util.List;

import com.iot.domain.Device;

public interface DeviceService {

	void start();
	
	void stop();
	
	Device getDeviceDetails(int deviceid);
	
	List<Device> listAllDevices();
}
