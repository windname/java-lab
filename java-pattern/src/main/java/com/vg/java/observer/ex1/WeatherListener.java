package com.vg.java.observer.ex1;

import java.util.Observable;
import java.util.Observer;

public class WeatherListener implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		WeatherManager manager = (WeatherManager) o;
		System.out.println("New weather is " + manager.getWeather());
	}

	public static void main(String[] str) {
		WeatherManager manager = new WeatherManager();
		manager.addObserver(new WeatherListener());
		manager.setWeather("Sunny");
		manager.setWeather("Rain");
	}

}
