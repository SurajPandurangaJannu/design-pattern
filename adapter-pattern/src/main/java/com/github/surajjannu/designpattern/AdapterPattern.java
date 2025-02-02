package com.github.surajjannu.designpattern;

import com.github.surajjannu.designpattern.example1.JsonProcessorAdapter;
import com.github.surajjannu.designpattern.example1.XMLProcessor;

/**
 * Hello world!
 *
 */
public class AdapterPattern
{
    public static void main( String[] args )
    {
        XMLProcessor xmlProcessor = new XMLProcessor();
        System.out.println(xmlProcessor.processXML("example1"));

        JsonProcessorAdapter jsonProcessor = new JsonProcessorAdapter(xmlProcessor);
        System.out.println(jsonProcessor.processJSON("example1"));
    }
}
