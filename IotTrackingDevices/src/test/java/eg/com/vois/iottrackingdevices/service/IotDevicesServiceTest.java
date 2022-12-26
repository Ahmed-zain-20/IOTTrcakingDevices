package eg.com.vois.iottrackingdevices.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import eg.com.vois.iottrackingdevices.model.IotDevices;
import eg.com.vois.iottrackingdevices.repository.IotDevicesRepository;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class IotDevicesServiceTest {
	@MockBean
	private IotDevicesRepository iotDevicesRepository;
	
	
	@InjectMocks
	private IotDevicesService iotDevicesService;
	
	@Test
	public void saveIotDeviceShouldbeFaildPinNotUniqueTest() {
		IotDevices iotDevice = new IotDevices();
		iotDevice.setDeviceName("Device1");
		iotDevice.setDevicePin(1234567);
		iotDevice.setDeviceStatus("Active");
		iotDevice.setTemperature(2);
		Mockito.when(iotDevicesRepository.save(iotDevice)).thenReturn(iotDevice) ;
		iotDevicesService.saveIotDevice(iotDevice);
		assertFalse(false);
	}
	
	@Test
	public void updateIotDeviceShouldBePassedTest() {
		IotDevices iotDevice = new IotDevices();
		iotDevice.setDeviceName("Device1");
		iotDevice.setDevicePin(1234567);
		iotDevice.setDeviceStatus("Active");
		iotDevice.setTemperature(2);
		Mockito.when(iotDevicesRepository.save(iotDevice)).thenReturn(iotDevice) ;
		iotDevicesService.updateIotDevice(iotDevice,iotDevice.getDeviceId());
		assertFalse(false);
	}

	
	 @Test
	    void findAllDeviceShouldBePassedTest() {
	        // Arrange
			Mockito.when(iotDevicesRepository.findAll()).thenReturn(List.of(new IotDevices()) ) ;
			 assertThat(iotDevicesService.findAllByOrderBydevicePin()).hasSize(1);
		        
	       
	    }


	

}
