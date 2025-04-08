package com.vg.structural.facade;

// Subsystem Components
class Projector {
    void on() {
        System.out.println("Projector: Power ON");
    }

    void wideScreenMode() {
        System.out.println("Projector: Wide screen mode (16:9)");
    }

    void off() {
        System.out.println("Projector: Power OFF");
    }
}

class SoundSystem {
    void on() {
        System.out.println("Sound System: Power ON");
    }

    void setSurround() {
        System.out.println("Sound System: Dolby Surround 7.1 enabled");
    }

    void setVolume(int level) {
        System.out.println("Sound System: Volume set to " + level);
    }

    void off() {
        System.out.println("Sound System: Power OFF");
    }
}

class DVDPlayer {
    void on() {
        System.out.println("DVD Player: Power ON");
    }

    void play(String movie) {
        System.out.println("DVD Player: Playing '" + movie + "'");
    }

    void stop() {
        System.out.println("DVD Player: Stopped");
    }

    void off() {
        System.out.println("DVD Player: Power OFF");
    }
}

class Lights {
    void dim(int percent) {
        System.out.println("Lights: Dimmed to " + percent + "%");
    }

    void on() {
        System.out.println("Lights: Fully ON");
    }
}

// Facade
class HomeTheaterFacade {
    private Projector projector;
    private SoundSystem soundSystem;
    private DVDPlayer dvdPlayer;
    private Lights lights;

    public HomeTheaterFacade() {
        this.projector = new Projector();
        this.soundSystem = new SoundSystem();
        this.dvdPlayer = new DVDPlayer();
        this.lights = new Lights();
    }

    public void startMovie(String movieTitle) {
        System.out.println("\n=== Preparing home theater for movie ===");
        lights.dim(10);
        projector.on();
        projector.wideScreenMode();
        soundSystem.on();
        soundSystem.setSurround();
        soundSystem.setVolume(25);
        dvdPlayer.on();
        dvdPlayer.play(movieTitle);
        System.out.println("=== Enjoy your movie! ===\n");
    }

    public void endMovie() {
        System.out.println("\n=== Shutting down home theater ===");
        dvdPlayer.stop();
        dvdPlayer.off();
        soundSystem.off();
        projector.off();
        lights.on();
        System.out.println("=== Goodbye! ===\n");
    }
}

// Client
public class HomeTheaterDemo {
    public static void main(String[] args) {
        HomeTheaterFacade theater = new HomeTheaterFacade();

        // Simplified interface
        theater.startMovie("The Matrix");

        // After movie ends
        theater.endMovie();
    }
}