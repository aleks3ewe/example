package ru.rsreu.vkr.datalayer;

import java.util.ArrayList;

import ru.rsreu.vkr.datalayer.data.Users;

public interface UsersDAO {
	ArrayList<Users> getUsers();
}