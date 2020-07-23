package com.example.cs.service;

import com.example.cs.entity.Invitation;

import java.util.List;

public interface InvitationService {
    /**
     * 查询全部帖子
     */
    List<Invitation> findAll();
    List<Invitation> findAllByTitleLike(String title);

    Invitation findById(int id);
    void delete(int id);
    void save(Invitation invitation);
}
