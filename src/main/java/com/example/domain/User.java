package com.example.domain;

import java.time.Instant;

public class User {

    private Long id;
    private String name;
    private Instant accessDate;
    private Instant creationDate;
    private Instant moodifiedDate;

    public Instant getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(Instant accessDate) {
        this.accessDate = accessDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public Instant getMoodifiedDate() {
        return moodifiedDate;
    }

    public void setMoodifiedDate(Instant moodifiedDate) {
        this.moodifiedDate = moodifiedDate;
    }

    public User (Long id, String name){
        this.id=id;
        this.name = name;
        this.creationDate = Instant.now();
        this.moodifiedDate = Instant.now();
    }


    public User (Long id, String name, Instant accessDate){
        this.id=id;
        this.name = name;
        this.creationDate = Instant.now();
        this.moodifiedDate = Instant.now();
        this.accessDate = accessDate;
    }
}
