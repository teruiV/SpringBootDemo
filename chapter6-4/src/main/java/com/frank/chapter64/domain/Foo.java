package com.frank.chapter64.domain;

import java.io.Serializable;

/**
 * @author jianweilin
 * @date 2017/10/31
 */
public class Foo implements Serializable{
    private final long id;
    private final String location;
    private Status status;

    public Foo(long id, String location, Status status) {
        this.id = id;
        this.location = location;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", status=" + status +
                '}';
    }

    public enum Status{
        TODO,
        COMPLETED
    }
}
