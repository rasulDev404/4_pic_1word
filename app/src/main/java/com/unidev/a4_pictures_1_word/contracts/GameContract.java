package com.unidev.a4_pictures_1_word.contracts;

import com.unidev.a4_pictures_1_word.GameData;

public interface GameContract {
    int MAX_ANSWER_SIZE = 6;
     int MAX_VARIANT_COUNT = 14;
    interface Model{
        GameData get(int index);
    }
    interface View{
        void loadImage(GameData data);
        void hideAnswer(int index);
        void showAnswer(int index);
        void clearAnswer(int index);
        void wrideAnswer(int index,String text);
        void hideVariant(int index);
        boolean showVariant(int index);
        boolean isShownVariant(int index);
        void writeVariant(int index , String text);
    }
    interface Presenter{
        void init();
        void onClickAnswer(int index);
        void  onClickVariant(int index);
    }
}
