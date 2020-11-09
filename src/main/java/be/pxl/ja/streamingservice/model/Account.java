package be.pxl.ja.streamingservice.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Account {
    private static final int MINIMUM_PASSWORD_STRENGTH = 5;
    private String email;
    private String password;
    private PaymentInfo paymentInfo;
    private StreamingPlan streamingPlan;
    private ArrayList<Profile> profiles = new ArrayList<Profile>();

    public Account() {
        Profile profile = new Profile("profile1");
        //voorlopig basic streamingplan by default
        setStreamingPlan(StreamingPlan.BASIC);
        addProfile(profile);
    }

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
        Profile profile = new Profile(email);
        //voorlopig basic streamingplan by default
        setStreamingPlan(StreamingPlan.BASIC);
        addProfile(profile);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public void setStreamingPlan(StreamingPlan streamingPlan) {
        this.streamingPlan = streamingPlan;
    }

    public String getEmail() {
        return this.email;
    }

    public Profile getFirstProfile() {
        return profiles.get(0);
    }

    public void addProfile(Profile profile) {
        if (profiles.size() < streamingPlan.getNumberOfProfiles()) {
            profiles.add(profile);
        } else {
            //throw new TooManyProfilesException();
        }

    }

    public ArrayList<Profile> getProfiles() {
        return profiles;
    }

    public Profile getProfile(String name){
        for (Profile profile: profiles) {
            if (profile.getName().equals(name)){
                return profile;
            }
        }
        return null;
    }
    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }

    public int getNumberOfProfiles() {
        return profiles.size();
    }
}