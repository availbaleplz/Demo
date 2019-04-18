package com.example.randomapple.demo;

public class Record {

    private int imageId;
    private String start;
    private  String end;

    public Record(int imageId, String start, String end){
        this.imageId = imageId;
        this.start = start;
        this.end = end;
    }

    public int getImageId() {
        return imageId;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }
}
