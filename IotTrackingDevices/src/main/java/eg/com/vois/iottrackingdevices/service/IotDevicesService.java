package eg.com.vois.iottrackingdevices.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import eg.com.vois.iottrackingdevices.model.IotDevices;
import eg.com.vois.iottrackingdevices.repository.IotDevicesRepository;

@Service
public class IotDevicesService {
	@Autowired
	private IotDevicesRepository iotDevicesRepository;

	public String saveIotDevice(IotDevices iotDevice) {
		try {

			if (iotDevice != null) {
				if (iotDevice.getDevicePin() != null) {
					int length = String.valueOf(iotDevice.getDevicePin()).length();
					if (length != 7) {

						return "PIN-ERROR";

					} else {

						IotDevices resSearch = iotDevicesRepository.findByDevicePin(iotDevice.getDevicePin());
						if (resSearch == null) {
							IotDevices iotResult = iotDevicesRepository.save(iotDevice);
							if (iotResult != null && iotResult.getDeviceId() != null && iotResult.getDeviceId() > 0)
								return "SAVED";
						}

						return "PIN-EXISTS";

					}
				}

			}
			return "ERROR";
		} catch (Exception e) {
			return "ERROR";
		}
	}

	public IotDevices updateIotDevice(IotDevices iotDevice, Integer deviceId) {
		try {
			IotDevices iotDeviceDB = iotDevicesRepository.findById(deviceId).get();

			if (iotDeviceDB != null) {
				iotDeviceDB.setDeviceName(iotDevice.getDeviceName());
				iotDeviceDB.setDevicePin(iotDevice.getDevicePin());
				iotDeviceDB.setDeviceStatus(iotDevice.getDeviceStatus());
				iotDeviceDB.setTemperature(iotDevice.getTemperature());
			}
			return iotDevicesRepository.save(iotDeviceDB);

		} catch (Exception e) {
			return null;
		}

	}

	public String deleteIotDeviceById(Integer deviceId) {
		if (iotDevicesRepository.existsById(deviceId)) {
			iotDevicesRepository.deleteById(deviceId);
			return "OK";
		}
		return "ERROR";

	}

	public List<IotDevices> findAllByOrderBydevicePin() {
		return iotDevicesRepository.findAll(Sort.by(Sort.Direction.DESC, "devicePin"));
	}

	public String deviceConfigurationService(Integer deviceId) {
		Random rand = new Random();
		int maxBound = 10;
		int random = rand.nextInt(maxBound);

		if (!iotDevicesRepository.existsById(deviceId)) {
			return "ERROR";
		}
		try {
			IotDevices iotDeviceDB = iotDevicesRepository.findById(deviceId).get();

			if (iotDeviceDB != null) {

				iotDeviceDB.setDeviceStatus("ACTIVE");
				iotDeviceDB.setTemperature(random);
			}
			iotDevicesRepository.save(iotDeviceDB);
			return "OK";
		} catch (Exception e) {
			return "ERROR";
		}

	}

}
