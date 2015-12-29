package com.xianheh.skynet.businesslogic;

import com.xianheh.skynet.exception.EventException;
import com.xianheh.skynet.model.Event;
import org.joda.time.DateTime;

import javax.annotation.Nullable;

/**
 * @author Xianhe Huang (xianhehuang@gmail.com)
 */
public interface EventManager {

    public void registerEvent(String id, String name, String owner, String description, DateTime startTime,
                              DateTime endTime, String location);

    public void changeEventDetails(String id, String name, String owner, String description, DateTime startTime,
                                   DateTime endTime, String location) throws EventException;

    public void changeEventName(String id, String name) throws EventException;

    public void changeEventOwner(String id, String owner) throws EventException;

    public void changeEventDescription(String id, String description) throws EventException;

    public void changeEventTime(String id, @Nullable DateTime startTime, @Nullable DateTime endTime) throws EventException;

    public void changeEventLocation(String id, String location) throws EventException;

    public void cancelEvent(String id) throws EventException;

    public Event getEventDetail(String id) throws EventException;
}
