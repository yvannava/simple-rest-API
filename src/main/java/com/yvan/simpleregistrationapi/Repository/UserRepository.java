package com.yvan.simpleregistrationapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.yvan.simpleregistrationapi.Model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
   
}
