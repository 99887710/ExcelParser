package com.poll.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Json {
    private  ObjectMapper mapper = new ObjectMapper();
    private  ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
    private  JsonNode root;
    private  String jsonString;

    public Json() {
        root = mapper.createObjectNode();
    }

    public void put(String key, String val) {
        ((ObjectNode)root).put(key, val);
    }

    public String output(){
        try {
            jsonString =  writer.writeValueAsString(root);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return jsonString;
    }
}
