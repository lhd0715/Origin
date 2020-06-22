package com.demo.backend.container;

import java.util.ArrayList;
import java.util.List;

import com.demo.backend.model.Profile;

public class ResponseForm implements WebResponseForm {

	private List<Profile> profiles = new ArrayList<>();

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }
}
