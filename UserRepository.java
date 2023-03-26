package com.jsp.tmr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jsp.tmr.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>
{
	@Query(value="select * from userentity where username=?1 or email=?2",nativeQuery = true)
	public UserEntity findByuserNameorEmail(String username,String email);
}
