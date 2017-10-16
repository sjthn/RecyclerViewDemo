package com.example.srijith.recyclerviewdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Srijith on 08-10-2017.
 */

public class UsersData {

    private List<User> usersList = new ArrayList<User>() {
        {
            add(new User(0, "Frederick Hoffman", "https://randomuser.me/api/portraits/men/52.jpg", "Developers"));
            add(new User(1, "Calvin Young", "https://randomuser.me/api/portraits/men/78.jpg", "Developers"));
            add(new User(2, "Jeanette Reid", "https://randomuser.me/api/portraits/women/37.jpg", "Developers"));
            add(new User(3, "Flenn Wilson", "https://randomuser.me/api/portraits/men/40.jpg", "Developers"));
            add(new User(4, "Martin Holland", "https://randomuser.me/api/portraits/men/0.jpg", "Developers"));
            add(new User(5, "Jeanette Simmmons", "https://randomuser.me/api/portraits/women/3.jpg", "Designers"));
            add(new User(6, "Wallace Lambert", "https://randomuser.me/api/portraits/men/53.jpg", "Designers"));
            add(new User(7, "Andy Clark", "https://randomuser.me/api/portraits/men/68.jpg", "Designers"));
            add(new User(8, "olivia obrien", "https://randomuser.me/api/portraits/women/93.jpg", "Designers"));
            add(new User(9, "Debbie Bennett", "https://randomuser.me/api/portraits/women/34.jpg", "Designers"));
            add(new User(10, "Bernice Lawson", "https://randomuser.me/api/portraits/women/20.jpg", "Team Leads"));
            add(new User(11, "Camila Elliott", "https://randomuser.me/api/portraits/women/60.jpg", "Team Leads"));
            add(new User(12, "Gerald Webb", "https://randomuser.me/api/portraits/men/55.jpg", "Team Leads"));
            add(new User(13, "Russell Hart", "https://randomuser.me/api/portraits/men/18.jpg", "Team Leads"));
            add(new User(14, "Joyce Mccoy", "https://randomuser.me/api/portraits/women/82.jpg", "Team Leads"));
            add(new User(15, "Daryl Banks", "https://randomuser.me/api/portraits/men/4.jpg", "Team Managers"));
            add(new User(16, "Veronica Vargas", "https://randomuser.me/api/portraits/women/14.jpg", "Team Managers"));
            add(new User(17, "Natalie Jacobs", "https://randomuser.me/api/portraits/women/0.jpg", "Team Managers"));
            add(new User(18, "Beverly Kennedy", "https://randomuser.me/api/portraits/women/30.jpg", "Team Managers"));
        }
    };

    private List<String> userTypeList = new ArrayList<String>() {
        {
            add("Developers");
            add("Designers");
            add("Team Leads");
            add("Team Managers");
        }
    };

    public List<User> getUsersList() {
        return usersList;
    }

    public List<String> getUserTypeList() {
        return userTypeList;
    }
}
