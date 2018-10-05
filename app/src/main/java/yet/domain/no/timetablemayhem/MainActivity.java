package yet.domain.no.timetablemayhem;

import android.app.LauncherActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView myLV;

    public void genTimesTable(int timeTableNumber) {

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Times Table of " + timeTableNumber);

        ArrayList<String> myAL = new ArrayList<String>();

        for(int x=1;x<=100;x++) {
            myAL.add(timeTableNumber + " x " + x +" = " + Integer.toString(timeTableNumber*x));
        }

        ArrayAdapter<String> myAA = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myAL);
        myLV.setAdapter(myAA);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar mySB = findViewById(R.id.mySeekBar);
        int timeTableNumber=10;
        mySB.setMax(100);
        mySB.setProgress(timeTableNumber);
        myLV = findViewById(R.id.myListView);
        genTimesTable(timeTableNumber);

        mySB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min=1;
                int timeTableNumber;

                if (i<min){
                    timeTableNumber = min;
                } else {
                    timeTableNumber = i;
                }
            genTimesTable(timeTableNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
