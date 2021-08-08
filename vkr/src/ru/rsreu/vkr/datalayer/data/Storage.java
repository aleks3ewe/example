package ru.rsreu.vkr.datalayer.data;

import java.io.Serializable;

public class Storage implements Serializable {
	private static final long serialVersionUID = 1L;
	 
    private int id;
    private int owner;
    private float x1;
    private float x2;
    private float x3;
    private float x4;
    private int bunkrupt;
    
    public Storage(int id, int owner, float x1, float x2, float x3, float x4, int bunkrupt){
         
        this.id = id;
        this.owner = owner;
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.bunkrupt = bunkrupt;
    }
     
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
     
    public int getOwner() {
        return owner;
    }
 
    public void setOwner(int owner) {
        this.owner = owner;
    }
    
    public float getX1() {
        return x1;
    }
 
    public void setX1(float x1) {
        this.x1 = x1;
    }
    
    public float getX2() {
        return x2;
    }
 
    public void setX2(float x2) {
        this.x2 = x2;
    }
    
    public float getX3() {
        return x3;
    }
 
    public void setX3(float x3) {
        this.x3 = x3;
    }
    
    public float getX4() {
        return x4;
    }
 
    public void setX4(float x4) {
        this.x4 = x4;
    }
    
    public int getBunkrupt() {
        return bunkrupt;
    }
 
    public void setBunkrupt(int bunkrupt) {
        this.bunkrupt = bunkrupt;
    }
}
