package ru.saydum;

import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Synthesizer synthesizer = new Synthesizer();

        // Set Command
        List<String> voiceCommandRun = new ArrayList<>();
        List<String> runCommand = new ArrayList<>();

        voiceCommandRun.add("Open chrome");
        runCommand.add("google-chrome");

        voiceCommandRun.add("Open project");
        runCommand.add("code .");

        voiceCommandRun.add("Open calculator");
        runCommand.add("gnome-calculator");
        // End Set command

        VoiceCommand voiceCommand = new VoiceCommand();

        Config config = new Config();


        try {
            LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config.make());
            speech.startRecognition(true);

            SpeechResult speechResult = null;

            synthesizer.voice("Welcome sir");
            System.out.println("listening");

            while ((speechResult = speech.getResult()) != null) {
                System.out.println("listening");
                String voiceCommandSp = speechResult.getHypothesis();
                System.out.println("Synthesizer Command is " + voiceCommandSp);

                for (int i = 0; i < voiceCommandRun.size(); i++) {
                    voiceCommand.run(voiceCommandSp, voiceCommandRun.get(i), runCommand.get(i));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (RuntimeException re) {
            throw new RuntimeException(re);
        }
    }
}