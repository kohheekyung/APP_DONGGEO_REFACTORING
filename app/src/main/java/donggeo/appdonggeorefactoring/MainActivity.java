package donggeo.appdonggeorefactoring;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    ViewPager viewPager;
    int images[] = {R.drawable.make, R.drawable.south_korea, R.drawable.north_korea, R.drawable.vietnam, R.drawable.united_kingdom};
    MyCustomPagerAdapter myCustomPagerAdapter;
    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;
    final long PERIOD_MS = 3000;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        Intent intent;
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_main:
                    intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_search:
                    intent = new Intent(MainActivity.this, SearchByContinent.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_write:
                    intent = new Intent(MainActivity.this, WritePostActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_mypage:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        viewPager = (ViewPager)findViewById(R.id.viewPager);

        myCustomPagerAdapter = new MyCustomPagerAdapter(MainActivity.this, images);
        viewPager.setAdapter(myCustomPagerAdapter);

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            @Override
            public void run() {
                if(currentPage == images.length - 1){
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);
    }

}
