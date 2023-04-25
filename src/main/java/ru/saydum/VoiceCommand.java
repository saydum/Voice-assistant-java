package ru.saydum;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

import java.io.IOException;

public class VoiceCommand {
    private final Synthesizer synthesizer = new Synthesizer();

    public void run(
            String command,
            String runCommand,
            String synthesizerText
    ) {
        //configuration for the listening your voice
        Configuration config = new Configuration();

        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");//hard coded path
        config.setDictionaryPath("src/main/resources/1841.dic");//need to make file from sphinx knowledge base convertor
        config.setLanguageModelPath("src/main/resources/1841.lm");

        try {
            //making system understand you are speaking
            LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
            speech.startRecognition(true);

            SpeechResult speechResult = null;
            System.out.println("listening");
            //running until user is speaking
            while ((speechResult = speech.getResult()) != null) {
                String voiceCommand = speechResult.getHypothesis();
                System.out.println("Synthesizer Command is " + voiceCommand);

                if (voiceCommand.equalsIgnoreCase(command)) {
                    synthesizer.voice(synthesizerText);
                    Runtime.getRuntime().exec(runCommand);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (RuntimeException re) {
            throw new RuntimeException(re);
        }
    }
}
