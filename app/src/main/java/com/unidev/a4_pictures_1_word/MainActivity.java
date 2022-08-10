package com.unidev.a4_pictures_1_word;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.unidev.a4_pictures_1_word.contracts.GameContract;
import com.unidev.a4_pictures_1_word.contracts.presenter.Presenter;
import com.unidev.a4_pictures_1_word.contracts.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GameContract.View {
    private List<ImageView> question = new ArrayList<>();
    private GameContract.Presenter presenter;
    private ArrayList<Button> answerButtons = new ArrayList<>();
    private ArrayList<Button> variantButtons = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadView();
        presenter = new Presenter(new Repository(),this);
        loadButtons(answerButtons,R.id.group_answers,presenter::onClickAnswer);
        loadButtons(variantButtons,R.id.group_variants1,presenter::onClickVariant);
        loadButtons(variantButtons,R.id.group_variant2,presenter::onClickVariant);
        presenter.init();

    }
    private void loadButtons(List<Button> buttons, int groupId,OnClickListener listener){
        ViewGroup group = findViewById(groupId);
        int oldSize = buttons.size();
        for(int i = 0; i<group.getChildCount();i++){
            View view = group.getChildAt(i);
            if(view instanceof Button) {
            Button button = (Button) view;
            int index = oldSize+i;
            button.setOnClickListener(v->listener.OnClick(index));
            buttons.add(button);
            }
        }
    }
    private void loadView(){
        question.add(findViewById(R.id.image1));
        question.add(findViewById(R.id.image2));
        question.add(findViewById(R.id.image3));
        question.add(findViewById(R.id.image4));

    }
    interface OnClickListener{
        void OnClick(int index);
    }

    @Override
    public void loadImage(GameData data) {
        for(int i = 0; i<question.size();i++){
            question.get(i).setImageResource(data.getImageById(i));
        }
    }
    @Override
    public void hideAnswer(int index) {
        answerButtons.  get(index).setVisibility(View.GONE);
    }

    @Override
    public void showAnswer(int index) {
        answerButtons.get(index).setVisibility(View.VISIBLE);
    }

    @Override
    public void clearAnswer(int index) {
        answerButtons.get(index).setText("");
    }

    @Override
    public void wrideAnswer(int index, String text) {
        answerButtons.get(index).setText(text);
    }

    @Override
    public void hideVariant(int index) {
        variantButtons.get(index).setVisibility(View.INVISIBLE);
    }

    @Override
    public boolean showVariant(int index) {
        variantButtons.get(index).setVisibility(View.VISIBLE);
        return false;
    }

    @Override
    public boolean isShownVariant(int index) {
        return variantButtons.get(index).getVisibility() == View.VISIBLE;
    }

    @Override
    public void writeVariant(int index, String text) {
        variantButtons.get(index).setText(text);
    }

}