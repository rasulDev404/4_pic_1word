package com.unidev.a4_pictures_1_word;

import java.util.List;

public class GameData {
    List<Integer> list;
    private final int pic1;
    private final int pic2;
    private final int pic3;
    private final int pic4;
    private final String answer;
    private final String variant;

    public GameData(int pic1, int pic2, int pic3, int pic4, String answer, String variant) {
        this.pic1 = pic1;
        this.pic2 = pic2;
        this.pic3 = pic3;
        this.pic4 = pic4;
        this.answer = answer;
        this.variant = variant;
        list = List.of(pic1, pic2, pic3, pic4);
    }

    public int getPic1() {
        return pic1;
    }

    public int getPic2() {
        return pic2;
    }

    public int getPic3() {
        return pic3;
    }

    public int getPic4() {
        return pic4;
    }

    public int getImageById(int id) {
        return list.get(id);
    }

    public String getAnswer() {
        return answer;
    }

    public String getVariant() {
        return variant;
    }


}
