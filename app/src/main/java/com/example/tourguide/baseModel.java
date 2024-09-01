package com.example.tourguide;

public class baseModel {

    private int text1;
    private int image1;
    private String link;

    baseModel(int text1, int image1,String link) {
        this.image1 = image1;
        this.text1 = text1;
        this.link=link;
    }

    public int getText1() {
        return text1;
    }
    public String getLink(){ return link; }
    public int getImage1() {
        return image1;
    }
}
