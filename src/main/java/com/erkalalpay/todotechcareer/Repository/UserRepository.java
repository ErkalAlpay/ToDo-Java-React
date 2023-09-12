package com.erkalalpay.todotechcareer.Repository;


import com.erkalalpay.todotechcareer.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getById(Long id);
}
