package com.ibo.keyboard;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.EditText;

import com.erqal.keyboard.KeyboardUtil;

public class MainActivity extends Activity {

    private KeyboardUtil keyboardUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        keyboardUtil = new KeyboardUtil(this);

        EditText editText = (EditText) findViewById(R.id.ev2);
        EditText editText1 = (EditText) findViewById(R.id.ev1);
        EditText editText2 = (EditText) findViewById(R.id.ev3);

        Typeface typeface=Typeface.createFromAsset(getAssets(),"UKIJTuT.ttf");

        editText.setTypeface(typeface);
        editText1.setTypeface(typeface);
        editText2.setTypeface(typeface);

        keyboardUtil.setEditText(editText);
        keyboardUtil.setEditText(editText2);
        keyboardUtil.setEditText(editText1);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    @Override
    public void onBackPressed() {
        if (keyboardUtil.isShowing()) {
            keyboardUtil.hideKeyboard();
            return;
        }
        super.onBackPressed();
    }

}
