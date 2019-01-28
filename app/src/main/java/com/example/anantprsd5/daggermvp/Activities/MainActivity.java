package com.example.anantprsd5.daggermvp.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.anantprsd5.daggermvp.Presenter.JokesPresenter;
import com.example.anantprsd5.daggermvp.R;
import com.example.anantprsd5.daggermvp.View.JokesView;
import com.example.anantprsd5.daggermvp.di.Component.DaggerJokesComponent;
import com.example.anantprsd5.daggermvp.di.Component.JokesComponent;
import com.example.anantprsd5.daggermvp.di.Module.JokesModule;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements JokesView {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @Inject
    JokesPresenter jokesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        button.setOnClickListener(v -> {
            jokesPresenter.getJokes();
            toggleProgressView(true);
        });

        JokesComponent jokesComponent = DaggerJokesComponent.builder()
                .jokesModule(new JokesModule(this::onJokesFetched))
                .build();

        jokesComponent.addActivity(this);

    }

    @Override
    public void onJokesFetched(String joke) {
        toggleProgressView(false);
        textView.setText(joke);
    }

    private void toggleProgressView(boolean visible){
        if(visible) {
            progressBar.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);
        } else {
            progressBar.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        }
    }
}
