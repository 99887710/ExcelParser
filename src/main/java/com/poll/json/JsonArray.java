package com.poll.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class JsonArray extends JsonBase {
    private ArrayNode array;

    public JsonArray() {
        this.array = mapper.createArrayNode();
    }


    public void add(Json node) {
        array.add(node.toJsonNode());
    }

    public int size(){
        return array.size();
    }

    @Override
    public String toJson() {
        try {
            jsonString = writer.writeValueAsString(array);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
