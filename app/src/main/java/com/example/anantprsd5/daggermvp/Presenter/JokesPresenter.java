package com.example.anantprsd5.daggermvp.Presenter;

import com.example.anantprsd5.daggermvp.Model.JokesModel;
import com.example.anantprsd5.daggermvp.View.JokesView;

import javax.inject.Inject;

public class JokesPresenter implements JokesModel.Quote {

    private JokesModel jokesModel;
    private JokesView jokesView;

    @Inject
    public JokesPresenter(JokesModel jokesModel, JokesView jokesView){
        this.jokesModel = jokesModel;
        this.jokesView = jokesView;
    }

    public void getJokes(){
        jokesModel.getNextQuote(this);
    }

    @Override
    public void getQuote(String s) {
        jokesView.onJokesFetched(s);
    }
}
