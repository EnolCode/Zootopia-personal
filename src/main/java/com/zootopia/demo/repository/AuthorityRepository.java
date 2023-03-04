package com.zootopia.demo.repository;
// import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.zootopia.demo.entity.Role;
// import com.zootopia.demo.utils.RoleName;

public interface AuthorityRepository extends JpaRepository<Role, Long> {
    
    // Optional<Role> findByName(Role role);

}
