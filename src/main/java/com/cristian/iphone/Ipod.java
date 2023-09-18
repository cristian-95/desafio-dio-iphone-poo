package com.cristian.iphone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ipod extends App {

    private Boolean isPlaying;
    private String nowPlaying;
    private List<String> musicList;

    public Ipod() {
        this.musicList = loadMusics();
        this.isPlaying = false;
        this.nowPlaying = "";
    }

    private List<String> loadMusics() {
        List<String> loadedSongs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(IphoneInfo.MUSIC_SOURCE))) {
            String song;
            while ((song = br.readLine()) != null) {
                loadedSongs.add(song);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedSongs;
    }

    private void play() {
        if (this.nowPlaying.equals("")) {
            selectMusic();
        } else {
            if (!this.isPlaying) {
                this.isPlaying = true;
            }
            System.out.println("Now playing: " + this.nowPlaying);
        }
    }

    private void pause() {
        if (this.isPlaying) {
            this.isPlaying = false;
            System.out.println("Paused");
        }
    }

    private void selectMusic() {
        int option = -1;
        System.out.println("\tMusics");
        for (int i = 1; i <= this.musicList.size(); i++) {
            System.out.println(i + " " + this.musicList.get(i - 1));
        }
        showIcons();
        System.out.print(": ");
        option = Iphone.input.nextInt();

        this.nowPlaying = this.musicList.get(option - 1);
        this.isPlaying = true;
        play();
    }


    @Override
    public void showOptions() {
        int option;
        System.out.println("Ipod");
        System.out.println("1. select a song.");
        System.out.println("2. play.");
        System.out.println("3. pause.");
        showIcons();
        System.out.print(": ");
        option = Iphone.input.nextInt();
        optionManager(option);
    }

    @Override
    public void optionManager(int option) {
        switch (option) {
            case 1 -> {
                selectMusic();
            }
            case 2 -> play();
            case 3 -> pause();
            default -> {
                System.out.println("Invalid option, try again");
                showOptions();
            }
        }
    }
}
