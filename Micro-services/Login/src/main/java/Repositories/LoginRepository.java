package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Login.Model.Login;

public interface LoginRepository extends JpaRepository<Login,String>{
    
}
