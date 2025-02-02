package com.github.surajjannu.designpattern.example1;

public class JsonProcessorAdapter {

    private final XMLProcessor xmlProcessor;

    public JsonProcessorAdapter(XMLProcessor xmlProcessor){
        this.xmlProcessor = xmlProcessor;
    }

    public String processJSON(String input){
        return xmlProcessor.processXML(input).replace("XML","JSON");
    }

}
