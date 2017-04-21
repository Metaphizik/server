package com.home.controller;

import com.home.entity.Remind;
import com.home.repository.RemindRepository;
import com.home.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController

public class ReminderController {

    @Autowired
    private ReminderService service;

    @RequestMapping(value = "/reminders", method = RequestMethod.GET)
    @ResponseBody
    /*public List<Remind> getALLReminders(){
        return service.getALL();
    }*/



        public Remind getReminder() {
                List<Remind> list = service.getALL();
                return createMockRemid();        }

            private Remind createMockRemid() {
                Remind remind = new Remind();
                remind.setId(1);
                remind.setRemindDate(new Date());
                remind.setTitle("My first reminder");
                return remind;
            }




    @RequestMapping(value = "/reminders/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Remind getRemind(@PathVariable("id") long remindID) {
        return service.getByID(remindID);
    }

    @RequestMapping(value = "/reminders", method = RequestMethod.POST)
    @ResponseBody
    public Remind saveRemind(@RequestBody Remind remind) {
        return service.save(remind);
    }

    @RequestMapping(value = "/remindDEL/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void delete(@PathVariable long id) {
        service.remove(id);
    }

}
