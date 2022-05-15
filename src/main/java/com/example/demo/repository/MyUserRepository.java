package com.example.demo.repository;

import com.example.demo.model.Myuser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface MyUserRepository extends PagingAndSortingRepository<Myuser, Long> {

    @Query("SELECT u FROM Myuser u WHERE u.login = :login")
    Optional<Myuser> findByLogin(@Param("login") String login);

}
