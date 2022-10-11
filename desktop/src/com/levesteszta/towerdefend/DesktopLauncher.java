package com.levesteszta.towerdefend;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
//import com.levesteszta.towerdefend.TowerDefend;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		System.setProperty("user.name", "Public");
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Tower Defend");

		config.setWindowSizeLimits(1000, 720, 1000, 720);
		config.setWindowedMode(1000, 720);
		
		new Lwjgl3Application(new TowerDefend(), config);
	}
}
