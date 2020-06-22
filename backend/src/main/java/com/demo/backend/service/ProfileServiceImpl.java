package com.demo.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.backend.dao.ProfileMapper;
import com.demo.backend.model.Profile;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileMapper profileMapper;

    @Override
    public List<Profile> searchAllId() {
        List<Profile> profiles = profileMapper.findAll();
        return profiles;
    }

}