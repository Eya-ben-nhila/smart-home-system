package com.smarthome.repository;

import com.smarthome.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    List<Device> findByRoom(String room);
    List<Device> findByType(String type);
    List<Device> findByStatus(String status);
    List<Device> findByRoomAndType(String room, String type);
}
