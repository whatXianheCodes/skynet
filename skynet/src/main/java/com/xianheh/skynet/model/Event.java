package com.xianheh.skynet.model;

import lombok.Data;
import org.joda.time.DateTime;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */
@Data
public class Event {
    private String id;
    private String name;
    //TODO: owner should be a person object later
    private String owner;
    private String description;
    private DateTime startTime;
    private DateTime endTime;
    //TODO: location should be represented differently
    private String location;
    private boolean active;

    public Event(String id, String name, String owner, String description, DateTime startTime,
                 DateTime endTime, String location) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.active = true;
    }

}
