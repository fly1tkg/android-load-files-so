package com.fly1tkg.answer;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        try {
            InputStream inputStream = getAssets().open("armeabi-v7a/libanswer.so");
            FileOutputStream fileOutputStream = openFileOutput("libanswer.so", MODE_PRIVATE);
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buffer)) >= 0) {
                fileOutputStream.write(buffer, 0, length);
            }
            fileOutputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File(getFilesDir(), "libanswer.so");
        Log.d("", file.getAbsolutePath() + ": " + file.exists());

        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(Answer.calculate() + "");
    }
}
