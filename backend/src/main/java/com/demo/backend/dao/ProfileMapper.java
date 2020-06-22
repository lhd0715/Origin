package com.demo.backend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.backend.model.Profile;

@Repository
public interface ProfileMapper {
    public List<Profile> findAll();
}