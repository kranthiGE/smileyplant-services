package com.iot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iot.domain.Device;
import com.iot.services.DeviceService;

/**
 * Created by Kranthi Kiran on 28-May-16
 */
@RestController
public class IrrigationController {

	private DeviceService irrigationService;
	
	@Autowired
	public void setIrrigationService(DeviceService irrigationService){
		this.irrigationService = irrigationService;
	}
	
	@CrossOrigin(origins = "https://smiley-plant.run.aws-usw02-pr.ice.predix.io")
    @RequestMapping("/startsignal")
    public void startPlantWatering(){
    	irrigationService.start();
    }
    
	@CrossOrigin(origins = "https://smiley-plant.run.aws-usw02-pr.ice.predix.io")
    @RequestMapping("/stopsignal")
    public void stopPlantWatering(){
    	irrigationService.stop();
    }
    
    @RequestMapping("/devicestate/{deviceid}")
    public Device getDeviceDetails(@RequestParam(value = "deviceid", defaultValue = "101") int deviceid){
    	return irrigationService.getDeviceDetails(deviceid);
    }
    
}
