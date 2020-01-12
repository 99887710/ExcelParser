package com.poll.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Json extends JsonBase {
    private  JsonNode root;

    public Json() {
        root = mapper.createObjectNode();
    }

    public void put(String key, String val) {
        ((ObjectNode)root).put(key, val);
    }

    public JsonNode toJsonNode(){
        return root;
    }

    @Override
    public String toJson(){
        try {
            jsonString =  writer.writeValueAsString(root);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return jsonString;
    }
}
