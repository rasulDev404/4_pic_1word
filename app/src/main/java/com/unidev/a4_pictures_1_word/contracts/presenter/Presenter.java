package com.unidev.a4_pictures_1_word.contracts.presenter;

import android.util.Log;
import android.view.View;

import com.unidev.a4_pictures_1_word.GameData;
import com.unidev.a4_pictures_1_word.contracts.GameContract;

public class Presenter implements GameContract.Presenter {
    private GameContract.Model model;
    private GameContract.View view;
    private int level = 0;
    private GameData gameData;
    private String[] userAnswer;



    public Presenter(GameContract.Model model, GameContract.View view) {
        this.model = model;
        this.view = view;
    }
    @Override
   public void init(){
        gameData = model.get(level);
        view.loadImage(gameData);
        int size = gameData.getAnswer().length();
        for(int i = 0; i<GameContract.MAX_ANSWER_SIZE;i++){
            if(i<size){
                view.showAnswer(i);
                view.clearAnswer(i);
            }else {
                view.hideAnswer(i);
            }
        }

        for(int i = 0; i< GameContract.MAX_VARIANT_COUNT;i++){
            String text = getVariant(i);
            view.writeVariant(i,text);
            view.showVariant(i);
        }
        userAnswer = new String[gameData.getAnswer().length()];
    }

    @Override
    public void onClickAnswer(int index) {
        String text = userAnswer[index];
        for(int i = 0;i<GameContract.MAX_VARIANT_COUNT;i++){
            String textVariant = getVariant(i);
            if(text.equals(textVariant) && !view.isShownVariant(i)){
                view.showVariant(i);
                view.clearAnswer(index);
                userAnswer[index] = null;
                return;
            }
        }
    }

    @Override
    public void onClickVariant(int index) {
        String text = getVariant(index);
        int indexEmpty = findFirstEmptyIndex();
        if(indexEmpty!=-1) {
            view.hideVariant(index);
            userAnswer[indexEmpty] = text;
            view.wrideAnswer(indexEmpty, text);
            if(findFirstEmptyIndex() == -1 && getUserAnswer(userAnswer).equals(gameData.getAnswer())){
                init();
                level++;
            }
        }

    }
    private String getUserAnswer(String[] userAnswer){
       StringBuilder s = new StringBuilder();
        for(int i = 0; i<userAnswer.length;i++) {
            s.append(userAnswer[i]);
        }
        return s.toString();
    }

    private int findFirstEmptyIndex(){
        for(int i = 0; i<userAnswer.length;i++){
            if(userAnswer[i] == null){
                return i;
            }
        }
        return -1;
    }
    private String getVariant(int index){
        String variant = gameData.getVariant();
        return String.valueOf(variant.charAt(index));
    }
}
