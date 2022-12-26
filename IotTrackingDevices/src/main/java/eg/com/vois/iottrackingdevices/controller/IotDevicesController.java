package eg.com.vois.iottrackingdevices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eg.com.vois.iottrackingdevices.model.IotDevices;
import eg.com.vois.iottrackingdevices.response.GeneralResponse;
import eg.com.vois.iottrackingdevices.service.IotDevicesService;

@RequestMapping(value = "/IOTDevices")
@RestController
public class IotDevicesController {

	@Autowired
	private IotDevicesService iotDevicesService;

	@Autowired
	GeneralResponse genRes;

	@PostMapping(value = "/add")
	public GeneralResponse addDevice(@RequestBody IotDevices iotDevice) {
		String iotDevicesStatus = iotDevicesService.saveIotDevice(iotDevice);

		if (iotDevicesStatus != null) {
			if (iotDevicesStatus.equalsIgnoreCase("SAVED")) {
				genRes.setStatus(200);
				genRes.setMessage("Devices added successfully ");
				return genRes;
			} else if (iotDevicesStatus.equalsIgnoreCase("PIN-ERROR")) {
				genRes.setStatus(401);
				genRes.setMessage("failed to add device pin code should be seven digit");
				return genRes;

			}

		}

		genRes.setStatus(401);
		genRes.setMessage("failed to add device");
		return genRes;
	}

	@PostMapping(value = "/update/{id}")
	public GeneralResponse updateDevice(@RequestBody IotDevices iotDevice, @PathVariable("id") Integer deviceId) {

		IotDevices iotDevices = iotDevicesService.updateIotDevice(iotDevice, deviceId);
		if (iotDevices != null && iotDevices.getDeviceId() != null) {
			if (iotDevice.getDevicePin() != null) {
				int length = String.valueOf(iotDevice.getDevicePin()).length();
				if (length != 7) {
					genRes.setStatus(401);
					genRes.setMessage("failed to add device pin code should be seven digit");
					return genRes;
				}
			}
			genRes.setStatus(200);
			genRes.setMessage("Devices update successfully ");
			return genRes;
		}
		genRes.setStatus(401);
		genRes.setMessage("failed to update device");
		return genRes;
	}

	@DeleteMapping(value = "/delete/{id}")
	public GeneralResponse deleteDevice(@PathVariable("id") Integer deviceId) {
		String res = iotDevicesService.deleteIotDeviceById(deviceId);
		if (res.equalsIgnoreCase("OK")) {

			genRes.setStatus(200);
			genRes.setMessage("Devices deleted successfully ");
			return genRes;
		}
		genRes.setStatus(401);
		genRes.setMessage("failed to deleted device");
		return genRes;
	}

	@GetMapping(value = "/getAllDevices")
	public List<IotDevices> addDevice() {
		return iotDevicesService.findAllByOrderBydevicePin();
	}

	@PostMapping(value = "/deviceConfigurationService/{id}")
	public GeneralResponse deviceConfigurationService(@PathVariable("id") Integer deviceId) {
		String res = iotDevicesService.deviceConfigurationService(deviceId);
		if (res != null && res.equalsIgnoreCase("OK")) {
			genRes.setStatus(200);
			genRes.setMessage("Devices configured successfully ");
			return genRes;
		}
		genRes.setStatus(401);
		genRes.setMessage("failed to configure device");
		return genRes;
	}
}
