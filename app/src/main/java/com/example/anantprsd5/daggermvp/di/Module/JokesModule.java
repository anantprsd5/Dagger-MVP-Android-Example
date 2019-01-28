package com.example.anantprsd5.daggermvp.di.Module;

import com.example.anantprsd5.daggermvp.Model.JokesModel;
import com.example.anantprsd5.daggermvp.Presenter.JokesPresenter;
import com.example.anantprsd5.daggermvp.View.JokesView;

import dagger.Module;
import dagger.Provides;

@Module
public class JokesModule{

    JokesView jokesView;

    public JokesModule(JokesView jokesView){
        this.jokesView = jokesView;
    }

    @Provides
    JokesPresenter getJokesPresenter(JokesModel jokesModel){
        return new JokesPresenter(jokesModel, jokesView);
    }
}
