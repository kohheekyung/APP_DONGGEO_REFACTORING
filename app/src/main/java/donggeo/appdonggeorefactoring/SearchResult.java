package donggeo.appdonggeorefactoring;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

public class SearchResult extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private boolean isDragged;
    TextView kakaonic;
    Handler handler = new Handler();
//    public static JSONObject jsonObject;
    public String state = "";
    public String continent = "";
    public JSONArray jsonArray;
    TabPagerAdapter pagerAdapter;
    static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        context = SearchResult.this;

        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("거래전"));
        tabLayout.addTab(tabLayout.newTab().setText("거래중"));
        tabLayout.addTab(tabLayout.newTab().setText("거래끝"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //Initializing ViewPager
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        Intent intent = getIntent();
        String  temp= intent.getStringExtra("jsonArray");

        pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), SearchResult.this, tabLayout.getTabCount());
        try {
            jsonArray = new JSONArray(temp);
            Log.d("Tab", String.valueOf(jsonArray));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        pagerAdapter.setJsonArray(jsonArray);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //Set TabSelectedListener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_DRAGGING)
                    isDragged= true;
            }

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d(getClass().getName(),"onPageSelected : "+tab);

                if (!isDragged) {
                    viewPager.setCurrentItem(tab.getPosition());
                }

                isDragged = false;
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if (tab.getPosition() != viewPager.getCurrentItem()) {
                    viewPager.setCurrentItem(tab.getPosition());
                }
            }
        });
    }


    public void setJsonArray(JSONArray jsonArray){
        this.jsonArray = jsonArray;
    }

    public JSONArray getJsonArray() {
        return jsonArray;
    }

    public static Context getContext() {
        return context;
    }
}
