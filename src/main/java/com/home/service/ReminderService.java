package com.home.service;

import com.home.entity.Remind;

import java.util.List;

public interface ReminderService {

    List<Remind> getALL();
    Remind getByID(long id);
    Remind save(Remind remind);
    void remove(long id);


}
