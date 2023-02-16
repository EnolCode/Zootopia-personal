package com.zootopia.demo.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.zootopia.demo.entity.Authority;
import com.zootopia.demo.utils.AuthorityName;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    
    Optional<Authority> findByName(AuthorityName name);

}
