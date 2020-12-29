package com.james.android.Objects;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityManagerCompat;

public interface UIHandler {
    public abstract void LinkButtonPressed(View v);
    public abstract void ButtonPressed(View v);
    public abstract void AnimatedButtonPressed(View v) throws InterruptedException;
    public abstract void SetActivity(AppCompatActivity activity);
}
