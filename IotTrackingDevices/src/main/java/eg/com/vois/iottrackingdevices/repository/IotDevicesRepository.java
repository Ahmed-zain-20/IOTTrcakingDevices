package eg.com.vois.iottrackingdevices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eg.com.vois.iottrackingdevices.model.IotDevices;

@Repository
public interface IotDevicesRepository extends JpaRepository<IotDevices, Integer>{

       public IotDevices findByDevicePin(Integer pinCode);
}
