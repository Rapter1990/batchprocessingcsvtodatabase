package com.example.batchprocessingcsvtodatabase.repository;

import com.example.batchprocessingcsvtodatabase.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

}
