package com.xianheh.skynet.dao;

import com.xianheh.skynet.exception.EventException;
import com.xianheh.skynet.model.Event;
import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */

public interface EventDAO {
    public static final String CONTEXT_ID = "EventDAO";

    public void insertEvent(String id, String name, String owner, String description, DateTime startTime,
                            DateTime endTime, String location);

    public void updateEvent(String id, String name, String owner, String description, DateTime startTime,
                          DateTime endTime, String location) throws EventException;

    public void deleteEvent(String id) throws EventException;

    public Event getEvent(String id) throws EventException;

    public List<String> getEventsByOwner(String owner);
}
