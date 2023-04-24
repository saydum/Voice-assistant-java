package ru.saydum;

import java.io.IOException;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class Main {
    //declaring voice
    public static void main(String[] args) {


        //configuration for the listening your voice
        Configuration config = new Configuration();

        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");//hard coded path
        config.setDictionaryPath("/home/saydum/Projects/Voice Assistent/src/main/resources/1841.dic");//need to make file from sphinx knowledge base convertor
        config.setLanguageModelPath("/home/saydum/Projects/Voice Assistent/src/main/resources/1841.lm");

        try {
            //making system understand you are speaking
            LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
            speech.startRecognition(true);

            SpeechResult speechResult = null;
            System.out.println("listening");
            //running until user is speaking
            while ((speechResult = speech.getResult()) != null) {
                String voiceCommand = speechResult.getHypothesis();
                System.out.println("Voice Command is " + voiceCommand);

                if (voiceCommand.equalsIgnoreCase("Open Chrome")) {
                    Runtime.getRuntime().exec("google-chrome");
                }
                else if (voiceCommand.equalsIgnoreCase("oliver Close chrome")){
                    Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
                }
                else if (voiceCommand.equalsIgnoreCase("open youtube")){
                    Runtime.getRuntime().exec("google-chrome youtube.com");
                }
                else if (voiceCommand.equalsIgnoreCase("oliver Close youtube")) {
                    Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
                }
                else if (voiceCommand.equalsIgnoreCase("open calculator")) {
                    Runtime.getRuntime().exec("gnome-calculator");
                }
                else if (voiceCommand.equalsIgnoreCase("oliver Close calculator")) {
                    Runtime.getRuntime().exec("cmd.exe /c /T TASKKILL /IM calculator.exe");
                }
                else if (voiceCommand.equalsIgnoreCase("oliver open sublimetext")) {

                    Runtime.getRuntime().exec("cmd.exe /c start subl");
                }
                else if (voiceCommand.equalsIgnoreCase("oliver Close sublimetext")) {

                    Runtime.getRuntime().exec("cmd.exe /c taskkill  /IM sublime_text.exe");
                }
                else if (voiceCommand.equalsIgnoreCase("oliver terminate")) {
                    System.exit(0);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (RuntimeException re) {
            throw new RuntimeException(re);
        }

    }
}
