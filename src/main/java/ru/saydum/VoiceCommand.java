package ru.saydum;


import java.io.IOException;

public class VoiceCommand {
    public  void run(String voiceCommandSp, String voiceCommandRun, String runCommand) {
        try {
            if (voiceCommandSp.equalsIgnoreCase(voiceCommandRun)){
                Runtime.getRuntime().exec(runCommand);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (RuntimeException re) {
            throw new RuntimeException(re);
        }
    }
}
