package com.demo.backend.dao;

import java.util.List;

import com.demo.backend.model.Profile;

public interface ProfileMapper {
    public List<Profile> findAll();
}