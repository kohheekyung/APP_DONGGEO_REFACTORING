package donggeo.appdonggeorefactoring;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class SearchByContinent extends AppCompatActivity {

    public Context context;

    public SearchByContinent(Context context) {
        this.context = context;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_main:
                    Intent intent1 = new Intent(context, MainActivity.class);
                    context.startActivity(intent1);
                case R.id.navigation_search:
                    Intent intent2 = new Intent(context, SearchByValue.class);
                    context.startActivity(intent2);
                /*case R.id.navigation_write:
                    Intent intent3 = new Intent(context, WritePostActivity.class);
                    context.startActivity(intent3);
                case R.id.navigation_mypage:
                    Intent intent4 = new Intent(context, MypageActivity.class);
                    context.startActivity(intent4);*/
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_continent);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
