package com.example.anantprsd5.daggermvp.di.Component;

import com.example.anantprsd5.daggermvp.Activities.MainActivity;
import com.example.anantprsd5.daggermvp.di.Module.JokesModule;

import dagger.Component;

@Component(modules = JokesModule.class)
public interface JokesComponent {
    void addActivity(MainActivity mainActivity);
}
