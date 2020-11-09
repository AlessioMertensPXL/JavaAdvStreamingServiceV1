package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayDeque;
import java.util.HashSet;

public class Profile {
    private String name;
    private LocalDate dateOfBirth;
    private HashSet<Content> currentlyWatching = new HashSet<>();
    private ArrayDeque<Content> recentlyWatched = new ArrayDeque<>();
    private String avatar;
    private HashSet<Content> myList = new HashSet<>();

    public Profile(String name, String avatar) {
        setName(name);
        this.avatar = avatar;


    }

    public Profile(String name) {
        this.setName(name);
        avatar = "profile1";
        // default datum (moet mogenlijk later aangepast worden):
        //this.setDateOfBirth(LocalDate.now());
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getAvatar() {
        return avatar;
    }

    public HashSet<Content> getMyList() {
        return myList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new InvalidDateException(dateOfBirth, "birthDate", "Birthday can not be in the future");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        if (this.dateOfBirth == null) {
            return 0;
        }
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public HashSet<Content> getCurrentlyWatching() {
        return currentlyWatching;
    }

    public ArrayDeque<Content> getRecentlyWatched() {
        return recentlyWatched;
    }

    public boolean allowedToWatch(Content content) {
        return content.getMaturityRating().getMinimumAge() < this.getAge();
    }

    public void startWatching(Content content) {
        recentlyWatched.remove(content);
        recentlyWatched.addFirst(content);
        currentlyWatching.add(content);
    }

    public void finishWatching(Content content) {
        recentlyWatched.remove(content);
        recentlyWatched.addFirst(content);
        currentlyWatching.remove(content);
    }

    public void addToMyList(Content content) {
        myList.add(content);
    }

    public void removeFromMyList(Content content) {
        myList.remove(content);
    }

    public boolean isInMyList(Content content){
        return myList.contains(content);
    }
}
