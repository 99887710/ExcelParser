package com.poll.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public abstract class JsonBase {
    protected ObjectMapper mapper = new ObjectMapper();
    protected ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
    protected String jsonString;

    public abstract String toJson();
}
