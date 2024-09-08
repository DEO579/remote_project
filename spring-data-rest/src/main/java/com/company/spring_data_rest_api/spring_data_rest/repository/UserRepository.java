package com.company.spring_data_rest_api.spring_data_rest.repository;

import com.company.spring_data_rest_api.spring_data_rest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
