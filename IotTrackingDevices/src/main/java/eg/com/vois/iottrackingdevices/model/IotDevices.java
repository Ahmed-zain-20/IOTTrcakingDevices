package eg.com.vois.iottrackingdevices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "IOT_DEVICES")
public class IotDevices {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "IOT_DEVICES_SEQ")
	@SequenceGenerator(name = "IOT_DEVICES_SEQ", sequenceName = "IOT_DEVICES_SEQ",  allocationSize = 1)
	@Column(name = "DEVICE_ID")
	private Integer deviceId;

	@Column(name = "DEVICE_NAME")
	private String deviceName;

	@Column(name = "DEVICE_PIN")
	private Integer devicePin;

	@Column(name = "DEVICE_STATUS")
	private String deviceStatus;
	
	
	@Column(name = "TEMPERATURE")
	private Integer temperature;
	public IotDevices() {
		super();
	}



	public IotDevices(Integer deviceId, String deviceName, Integer devicePin, String deviceStatus,
			Integer temperature) {
		super();
		this.deviceId = deviceId;
		this.deviceName = deviceName;
		this.devicePin = devicePin;
		this.deviceStatus = deviceStatus;
		this.temperature = temperature;
	}



	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public Integer getDevicePin() {
		return devicePin;
	}

	public void setDevicePin(Integer devicePin) {
		this.devicePin = devicePin;
	}

	public String getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(String deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	public Integer getTemperature() {
		return temperature;
	}

	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}

}
