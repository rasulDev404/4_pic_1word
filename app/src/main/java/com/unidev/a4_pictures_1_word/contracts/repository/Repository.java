package com.unidev.a4_pictures_1_word.contracts.repository;

import com.unidev.a4_pictures_1_word.GameData;
import com.unidev.a4_pictures_1_word.R;
import com.unidev.a4_pictures_1_word.contracts.GameContract;

import java.util.ArrayList;

public class Repository implements GameContract.Model {
    private ArrayList<GameData>  question = new ArrayList<>();
    public Repository(){
        question.add(new GameData(R.drawable.imag_lev1_1,R.drawable.imeg_lev1_2,R.drawable.imeg_lev1_3,R.drawable.imag_lev1_4,"box","absdeaofxitwrq"));
        question.add(new GameData(R.drawable.mouse1,R.drawable.mouse2,R.drawable.mouse3,R.drawable.mouse4,"mouse","sbcmfjxeoleour"));
        question.add(new GameData(R.drawable.tv1,R.drawable.tv2,R.drawable.tv3,R.drawable.tv4,"tv","mtoknvivatrohr"));
        question.add(new GameData(R.drawable.car1,R.drawable.car2,R.drawable.car3,R.drawable.car4,"car","plcrtgavmfyuaf"));
        question.add(new GameData(R.drawable.watch1,R.drawable.watch2,R.drawable.watch3,R.drawable.watch4,"watch","thngfwodrahbic"));
        question.add(new GameData(R.drawable.x_ray1,R.drawable.x_ray2,R.drawable.x_ray3,R.drawable.x_ray4,"x-ray","kdxsu-ygrtaqwp"));


        question.add(new GameData(R.drawable.math1,R.drawable.math2,R.drawable.math3,R.drawable.math4,"math","atworqhrqmotpi"));
        question.add(new GameData(R.drawable.art1,R.drawable.art2,R.drawable.art3,R.drawable.art4,"art","matqpitshrelrw"));
    }
    @Override
    public GameData get(int index) {
        return question.get(index);
    }
}
