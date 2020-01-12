package com.poll.json;

//Basic Usage of Json class
public class Demo {

    public static void main(String[] args) {
        //Create JSON Object
        Json json = new Json();
        json.put("name", "Jeff");
        json.put("gender","Male");

        Json json1 = new Json();
        json1.put("name", "Alice");
        json1.put("gender","Female");

        //Create Json Array
        JsonArray array = new JsonArray();
        array.add(json);
        array.add(json1);

        System.out.println(json.toJson());
        System.out.println(array.toJson());
    }
}
