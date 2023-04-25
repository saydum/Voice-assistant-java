package ru.saydum;

import ru.saydum.VoiceCommand;

import java.util.ArrayList;

public class Main {
    //declaring voice
    public static void main(String[] args) {
        VoiceCommand voiceCommand = new VoiceCommand();

        voiceCommand.run("Open chrome", "google-chrome", "Yes sir");
        voiceCommand.run("Open youtube", "google-chrome youtube.com", "Of course sir");
        voiceCommand.run("Open calculator", "gnome-calculator", "Yes sir");
    }
}
