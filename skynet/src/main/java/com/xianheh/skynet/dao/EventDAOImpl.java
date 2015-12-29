package com.xianheh.skynet.dao;

import com.google.common.collect.Lists;
import com.xianheh.skynet.exception.EventException;
import com.xianheh.skynet.model.Event;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */

@Component(value = EventDAO.CONTEXT_ID)
public class EventDAOImpl implements EventDAO {

    private static List<Event> eventDB;

    @PostConstruct
    public void initIt() {
        eventDB = Lists.newArrayList();
    }

    @Override
    public void insertEvent(String id, String name, String owner, String description, DateTime startTime, DateTime
            endTime, String location) {
        if (id == null) {
            throw new NullPointerException("Event id is null");
        }

        Event event = new Event(id, name, owner, description, startTime, endTime, location);
        eventDB.add(event);
    }

    @Override
    public void updateEvent(String id, @Nullable String name, @Nullable String owner,
                            @Nullable String description, @Nullable DateTime startTime,
                            @Nullable DateTime endTime, @Nullable String location) throws EventException {
        int eventIndex = findEventIndexById(id);
        Event event = eventDB.get(eventIndex);

        if (name != null) {
            event.setName(name);
        }
        if (owner == null) {
            event.setOwner(owner);
        }

        if (description != null) {
            event.setDescription(description);
        }

        if (startTime != null) {
            event.setStartTime(startTime);
        }

        if (endTime != null) {
            event.setEndTime(endTime);
        }

        if (location != null) {
            event.setLocation(location);
        }

        eventDB.set(eventIndex, event);
    }

    @Override
    public void deleteEvent(String id) throws EventException {
        int eventIndex = findEventIndexById(id);
        Event event = eventDB.get(eventIndex);
        event.setActive(false);
        eventDB.set(eventIndex, event);
    }

    @Override
    public Event getEvent(String id) throws EventException {
        return eventDB.get(findEventIndexById(id));
    }

    @Override
    public List<String> getEventsByOwner(String owner) {
        List<String> eventIds = Lists.newArrayList();
        if (owner == null) {
            throw new NullPointerException("Event owner is null");
        }

        for (int eventIndex = 0; eventIndex < eventDB.size(); eventIndex++) {
            Event event = eventDB.get(eventIndex);
            if (event.getOwner().equals(owner)) {
                eventIds.add(event.getId());
            }
        }
        return eventIds;
    }

    private int findEventIndexById(String id) throws EventException {
        if (id == null) {
            throw new NullPointerException("Event id is null");
        }

        for (int eventIndex = 0; eventIndex < eventDB.size(); eventIndex++) {
            Event event = eventDB.get(eventIndex);
            if (event.getId().equals(id)) {
                return eventIndex;
            }
        }
        throw new EventException("Event id does not exist");
    }
}
