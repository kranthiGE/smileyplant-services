package com.iot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.iot.domain.Device;
import com.iot.repositories.DeviceRepository;

public class MotorServiceImpl implements DeviceService {

	private DeviceRepository repo;
	
	@Override
	public void start() {
		repo.getDevices().get(101).setState(1);
	}

	@Override
	public void stop() {
		repo.getDevices().get(101).setState(0);
	}

	@Override
	public Device getDeviceDetails(int deviceid) {
		return repo.getDevices().get(deviceid);
	}

	public List<Device> listAllDevices(){		
		return new ArrayList<>(repo.getDevices().values());
	}

	@Autowired
	public void setRepo(DeviceRepository repo) {
		this.repo = repo;
	}
	
}
