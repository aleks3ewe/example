package ru.rsreu.vkr.datalayer;

import java.util.ArrayList;

import ru.rsreu.vkr.datalayer.data.Storage;

public interface StorageDAO {
	ArrayList<Storage> getStorage();
	int setStorage(int owner, float x1, float x2, float x3, float x4, int bunkrupt);
}