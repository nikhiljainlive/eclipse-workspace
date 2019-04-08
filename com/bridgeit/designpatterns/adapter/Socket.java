package com.bridgeit.designpatterns.adapter;

public class Socket {

	public Volt getVolt(){
		return new Volt(120);
	}
}
