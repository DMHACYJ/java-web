package com.example.cs.repository;

import com.example.cs.entity.Invitation;
import com.example.cs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvitationRepository extends JpaRepository<Invitation,Integer>, JpaSpecificationExecutor<Invitation> {
    Invitation findById(int id );
    List<Invitation> findAllByTitleLike(String title);
}
