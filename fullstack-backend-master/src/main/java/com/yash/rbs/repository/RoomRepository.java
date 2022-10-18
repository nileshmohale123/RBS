package com.yash.rbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.rbs.model.Room;
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
	


}