package com.appers.ayvaz.myprefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {
ToggleButton toggleButton;
    EditText editText;
    SeekBar seekBar;
    Button button;
    String name = "Guest";
    Boolean sound = false;
    int thresh = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        editText = (EditText) findViewById(R.id.editText);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        button = (Button) findViewById(R.id.button1);
        SharedPreferences settings = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putString("Name", name);
        prefEditor.putBoolean("Sound", sound);
        prefEditor.putInt("Threshold", thresh);
        prefEditor.commit();
        SharedPreferences settings2 = getPreferences(MODE_PRIVATE);
        name = settings2.getString("Name","No Name value found");
        Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();
        sound = settings2.getBoolean("Sound", false);
        if(sound)
            Toast.makeText(getApplicationContext(),"ON",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(),"False",Toast.LENGTH_SHORT).show();

        thresh = settings2.getInt("Threshold",0);
        Toast.makeText(getApplicationContext(),Integer.toString(thresh),Toast.LENGTH_SHORT).show();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editText.getText().toString();
                thresh = seekBar.getProgress();
                if(toggleButton.isChecked())
                    sound = true;
                else
                    sound = false;
                SharedPreferences settings = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor prefEditor = settings.edit();
                prefEditor.putString("Name", name);
                prefEditor.putBoolean("Sound", sound);
                prefEditor.putInt("Threshold", thresh);
                prefEditor.commit();
                SharedPreferences settings2 = getPreferences(MODE_PRIVATE);
                name = settings2.getString("Name","No Name value found");
                Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();
                sound = settings2.getBoolean("Sound", false);
                if(sound)
                    Toast.makeText(getApplicationContext(),"ON",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"False",Toast.LENGTH_SHORT).show();

                thresh = settings2.getInt("Threshold",0);
                Toast.makeText(getApplicationContext(),Integer.toString(thresh),Toast.LENGTH_SHORT).show();
            }
        });



    }

}

