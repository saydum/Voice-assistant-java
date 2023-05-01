package ru.saydum;

import edu.cmu.sphinx.api.Configuration;

public class Config {
    public Configuration make() {
        Configuration config = new Configuration();
        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");//hard coded path
        config.setDictionaryPath("src/main/resources/5214.dic");//need to make file from sphinx knowledge base convertor
        config.setLanguageModelPath("src/main/resources/5214.lm");

        return config;
    }
}
