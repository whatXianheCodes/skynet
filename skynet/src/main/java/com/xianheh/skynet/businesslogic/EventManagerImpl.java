package com.xianheh.skynet.businesslogic;

import com.xianheh.skynet.dao.EventDAO;
import com.xianheh.skynet.exception.EventException;
import com.xianheh.skynet.model.Event;
import org.joda.time.DateTime;

import javax.annotation.Nullable;
import javax.annotation.Resource;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */
public class EventManagerImpl implements EventManager {

    @Resource
    private EventDAO eventDAO;

    @Override
    public void registerEvent(String id, String name, String owner, String description, DateTime startTime,
                              DateTime endTime, String location) {
        eventDAO.insertEvent(id, name, owner, description, startTime, endTime, location);
    }

    @Override
    public void changeEventDetails(String id, String name, String owner, String description, DateTime startTime,
                                   DateTime endTime, String location) throws EventException {
        eventDAO.updateEvent(id, name, owner, description, startTime, endTime, location);
    }

    @Override
    public void changeEventName(String id, String name) throws EventException {
        eventDAO.updateEvent(id, name, null, null, null, null, null);
    }

    @Override
    public void changeEventOwner(String id, String owner) throws EventException {
        eventDAO.updateEvent(id, null, owner, null, null, null, null);
    }

    @Override
    public void changeEventDescription(String id, String description) throws EventException {
        eventDAO.updateEvent(id, null, null, description, null, null, null);
    }

    @Override
    public void changeEventTime(String id, @Nullable DateTime startTime, @Nullable DateTime endTime)
            throws EventException {
        eventDAO.updateEvent(id, null, null, null, startTime, endTime, null);
    }

    @Override
    public void changeEventLocation(String id, String location) throws EventException {
        eventDAO.updateEvent(id, null, null, null, null, null, location);
    }

    @Override
    public void cancelEvent(String id) throws EventException {
        eventDAO.deleteEvent(id);
    }

    @Override
    public Event getEventDetail(String id) throws EventException {
        return eventDAO.getEvent(id);
    }
}
