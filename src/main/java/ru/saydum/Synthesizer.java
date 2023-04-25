package ru.saydum;

import javax.speech.AudioException;
import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.EngineStateError;
import javax.speech.synthesis.SynthesizerModeDesc;
import java.util.Locale;

public class Synthesizer {
    public void voice(String text) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

        try {
            Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
            javax.speech.synthesis.Synthesizer synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));

            synthesizer.allocate();
            synthesizer.resume();

            synthesizer.speakPlainText(text, null);
            synthesizer.waitEngineState(javax.speech.synthesis.Synthesizer.QUEUE_EMPTY);
            synthesizer.deallocate();
        } catch (EngineException | AudioException | InterruptedException e) {
            throw new RuntimeException(e);
        } catch (EngineStateError | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
