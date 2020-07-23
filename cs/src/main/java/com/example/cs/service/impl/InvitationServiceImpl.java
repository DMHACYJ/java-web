package com.example.cs.service.impl;

import com.example.cs.entity.Invitation;
import com.example.cs.repository.InvitationRepository;
import com.example.cs.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvitationServiceImpl implements InvitationService {
    @Autowired
    private InvitationRepository invitationRepository;

    @Override
    public List<Invitation> findAll() {
        return invitationRepository.findAll();
    }

    @Override
    public List<Invitation> findAllByTitleLike(String title) {
        return invitationRepository.findAllByTitleLike("%"+title+"%");
    }

    @Override
    public Invitation findById(int id) {
        return invitationRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        invitationRepository.deleteById(id);
    }

    @Override
    public void save(Invitation invitation) {
        invitationRepository.save(invitation);
    }
}
