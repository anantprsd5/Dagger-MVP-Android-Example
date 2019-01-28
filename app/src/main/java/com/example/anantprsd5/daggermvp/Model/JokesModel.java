package com.example.anantprsd5.daggermvp.Model;

import android.os.Handler;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

public class JokesModel {

    @Inject
    public JokesModel(){

    }

    public void getNextQuote(final Quote quote) {
        new Handler().postDelayed(() -> quote.getQuote(getRandomQuote()), 1200);
    }

    private List<String> arrayList = Arrays.asList(
            "Be yourself. everyone else is already taken.",
            "A room without books is like a body without a soul.",
            "You only live once, but if you do it right, once is enough.",
            "Be the change that you wish to see in the world.",
            "If you tell the truth, you don't have to remember anything."
    );

    private String getRandomQuote() {

        Random random = new Random();
        int index = random.nextInt(arrayList.size());
        return arrayList.get(index);
    }

    public interface Quote{
        void getQuote(String s);
    }
}
