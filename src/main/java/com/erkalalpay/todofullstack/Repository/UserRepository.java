package com.erkalalpay.todofullstack.Repository;


import com.erkalalpay.todofullstack.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getById(Long id);
    User findByUseremail(String useremail);

}
