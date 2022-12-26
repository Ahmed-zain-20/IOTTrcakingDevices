package eg.com.vois.iottrackingdevices.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import eg.com.vois.iottrackingdevices.model.IotDevices;

@DataJpaTest
public class IotDevicesRepositoryTest {
	@Autowired
	private IotDevicesRepository iotDevicesRepository;
//	IotDevices testingIotDevices;
//	
//	@Before
//	public void  intit(){
//		IotDevices iotDevice = new IotDevices();
//		iotDevice.setDeviceName("Device1");
//		iotDevice.setDevicePin(1234567);
//		iotDevice.setDeviceStatus("Active");
//		iotDevice.setTemperature(2);
//		this.testingIotDevices=iotDevice;
//	}

	@Test
	public void testSaveIotDevice() {

		IotDevices iotDevice = new IotDevices();
		iotDevice.setDeviceName("Device1");
		iotDevice.setDevicePin(1234577);
		iotDevice.setDeviceStatus("Active");
		iotDevice.setTemperature(2);
		
		
		IotDevices x=iotDevicesRepository.save(iotDevice);
		assertNotNull(x);
		assertTrue(x.getDeviceId() >0);
		assertThat(x.getDeviceName()).isEqualTo("Device1");

	}
	

	@Test
	public void testUpdateIotDevice() {

		IotDevices iotDevice = new IotDevices();
		iotDevice.setDeviceName("Device2");
		iotDevice.setDevicePin(1234587);
		iotDevice.setDeviceStatus("Active");
		iotDevice.setTemperature(2);
		iotDevicesRepository.save(iotDevice);
		assertNotNull(iotDevice);
		assertThat(iotDevice.getDeviceName()).isEqualTo("Device2");

	}
	
	

}
