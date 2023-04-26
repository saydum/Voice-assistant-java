package ru.saydum;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Configuration config = new Configuration();

        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");//hard coded path
        config.setDictionaryPath("src/main/resources/5214.dic");//need to make file from sphinx knowledge base convertor
        config.setLanguageModelPath("src/main/resources/5214.lm");

        try {
            //making system understand you are speaking
            LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
            speech.startRecognition(true);

            SpeechResult speechResult = null;
            System.out.println("listening");
            //running until user is speaking
            while ((speechResult = speech.getResult()) != null) {
                String voiceCommandSp = speechResult.getHypothesis();
                System.out.println("Synthesizer Command is " + voiceCommandSp);

                if (voiceCommandSp.equalsIgnoreCase("Open chrome")) {
                    Runtime.getRuntime().exec("google-chrome");
                }

                if (voiceCommandSp.equalsIgnoreCase("Open youtube")) {
                    Runtime.getRuntime().exec("google-chrome youtube.com");
                }

                if (voiceCommandSp.equalsIgnoreCase("Open calculator")) {
                    Runtime.getRuntime().exec("gnome-calculator");
                }

                if (voiceCommandSp.equalsIgnoreCase("Open project")) {
//                    Runtime.getRuntime().exec("");
                    Runtime.getRuntime().exec("code .");
                }
                if (voiceCommandSp.equalsIgnoreCase("Play music")) {
//                    Runtime.getRuntime().exec("");
                    Runtime.getRuntime().exec("mplayer lofi.mp3");
                }
//

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (RuntimeException re) {
            throw new RuntimeException(re);
        }
    }
}
