package com.framework.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class JsonReader {
    public static Map<String, String> readJson(String filePath) {
        Map<String, String> dataMap = new HashMap<>();
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(filePath));
            jsonObject.forEach((key, value) -> dataMap.put((String) key, (String) value));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataMap;
    }
}
