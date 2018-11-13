package tw.brad.mytimertask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Timer timer;
    private int i;
    private MyTask myTask;
    private TextView counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = findViewById(R.id.counter);

        timer = new Timer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (timer != null){
            timer.cancel();
            timer.purge();
            timer = null;
        }


    }

    private class MyTask extends TimerTask {
        @Override
        public void run() {
            i++;
            Log.v("brad", "i = " + i);
            counter.setText("i = " + i);
        }
    }

    public void test1(View view) {
        myTask = new MyTask();
        timer.schedule(myTask, 0, 3*1000);
    }

    public void test2(View view) {
        if (myTask != null){
            myTask.cancel();
            myTask = null;
        }
    }
}
