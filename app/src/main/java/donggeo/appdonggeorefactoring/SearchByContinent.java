package donggeo.appdonggeorefactoring;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import org.json.JSONArray;
import org.json.JSONException;

import donggeo.appdonggeorefactoring.HttpRequest.GetData;

public class    SearchByContinent extends AppCompatActivity {


    public static Context context;
    String conti_num = "0";
    String result = "";
    public JSONArray jsonArray;

    ImageView Main_img = null;
    ImageView Asia_img= null;
    ImageView Africa_img = null;
    ImageView Oceania_img = null;
    ImageView NorthAmerica_img = null;
    ImageView SouthAmerica_img = null;
    ImageView Europe_img = null;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        Intent intent;
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_main:
                    intent = new Intent(SearchByContinent.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_search:
                    intent = new Intent(SearchByContinent.this, SearchByContinent.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_write:
                    intent = new Intent(SearchByContinent.this, WritePostActivity.class);
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
        setContentView(R.layout.activity_search_by_continent);

        Main_img = (ImageView)findViewById(R.id.continent_main_img);
        Asia_img = (ImageView)findViewById(R.id.continent_Asia_img);
        Africa_img = (ImageView)findViewById(R.id.continent_Africa_img);
        Oceania_img = (ImageView)findViewById(R.id.continent_Oceania_img);
        NorthAmerica_img = (ImageView)findViewById(R.id.continent_NorthAmerica_img);
        SouthAmerica_img = (ImageView)findViewById(R.id.continent_SouthAmerica_img);
        Europe_img = (ImageView)findViewById(R.id.continent_Europe_img);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

//    public void onClick(View v) throws JSONException {
//        switch (v.getId()) {
//            case R.id.imageButton1:
//                Intent intent = new Intent(SearchByContinent.this, SearchByValue.class);
//                //1: 유럽, 2: 아시아, 3: 오세아니아, 4: 아메리카, 5:아프리카
//
//                conti_num = "1";
//                context = SearchByContinent.this;
////                JSONObject jsonObject = new JSONObject(); //파라미터 데이터
////                jsonObject.put("request_state", "0");
////                jsonObject.put("request_continent", conti_num);
//                GetData getData = new GetData(SearchByContinent.this,null);
//                getData.execute("http://13.124.152.254/dong_geo/search_continent.php?request_continent="+conti_num+"&request_state=0");
//                startActivity(intent);
//            case R.id.imageButton2:
//                Intent intent2 = new Intent(SearchByContinent.this, SearchByValue.class);
//                conti_num = "2";
//                context = SearchByContinent.this;
//                GetData getData2 = new GetData(SearchByContinent.this,null);
//                getData2.execute("http://13.124.152.254/dong_geo/search_continent.php?request_continent="+conti_num+"&request_state=0");
//                startActivity(intent2);
//            case R.id.imageButton3:
//                Intent intent3 = new Intent(SearchByContinent.this, SearchByValue.class);
//                conti_num = "3";
//                context = SearchByContinent.this;
//                GetData getData3 = new GetData(SearchByContinent.this,null);
//                getData3.execute("http://13.124.152.254/dong_geo/search_continent.php?request_continent="+conti_num+"&request_state=0");
//                startActivity(intent3);
//
//            case R.id.imageButton4:
//                Intent intent4 = new Intent(SearchByContinent.this, SearchByValue.class);
//                conti_num = "4";
//                context = SearchByContinent.this;
//                GetData getData4 = new GetData(SearchByContinent.this,null);
//                getData4.execute("http://13.124.152.254/dong_geo/search_continent.php?request_continent="+conti_num+"&request_state=0");
//                startActivity(intent4);
//
//            case R.id.imageButton5:
//                Intent intent5 = new Intent(SearchByContinent.this, SearchByValue.class);
//                conti_num = "5";
//                context = SearchByContinent.this;
//                GetData getData5 = new GetData(SearchByContinent.this,null);
//                getData5.execute("http://13.124.152.254/dong_geo/search_continent.php?request_continent="+conti_num+"&request_state=0");
//                startActivity(intent5);
//
//        }
//    }

    public void onClickContinent(View v){
        switch (v.getId()) {
            case R.id.continent_Asia:
                Main_img.setVisibility(View.INVISIBLE);
                Asia_img.setVisibility(View.VISIBLE);
                Africa_img.setVisibility(View.INVISIBLE);
                Oceania_img.setVisibility(View.INVISIBLE);
                NorthAmerica_img.setVisibility(View.INVISIBLE);
                SouthAmerica_img.setVisibility(View.INVISIBLE);
                Europe_img.setVisibility(View.INVISIBLE);
                break;
            case R.id.continent_Africa:
                Main_img.setVisibility(View.INVISIBLE);
                Asia_img.setVisibility(View.INVISIBLE);
                Africa_img.setVisibility(View.VISIBLE);
                Oceania_img.setVisibility(View.INVISIBLE);
                NorthAmerica_img.setVisibility(View.INVISIBLE);
                SouthAmerica_img.setVisibility(View.INVISIBLE);
                Europe_img.setVisibility(View.INVISIBLE);
                break;
            case R.id.continent_Oceania:
                Main_img.setVisibility(View.INVISIBLE);
                Asia_img.setVisibility(View.INVISIBLE);
                Africa_img.setVisibility(View.INVISIBLE);
                Oceania_img.setVisibility(View.VISIBLE);
                NorthAmerica_img.setVisibility(View.INVISIBLE);
                SouthAmerica_img.setVisibility(View.INVISIBLE);
                Europe_img.setVisibility(View.INVISIBLE);
                break;
            case R.id.continent_NorthAmerica_1:
                Main_img.setVisibility(View.INVISIBLE);
                Asia_img.setVisibility(View.INVISIBLE);
                Africa_img.setVisibility(View.INVISIBLE);
                Oceania_img.setVisibility(View.INVISIBLE);
                NorthAmerica_img.setVisibility(View.VISIBLE);
                SouthAmerica_img.setVisibility(View.INVISIBLE);
                Europe_img.setVisibility(View.INVISIBLE);
                break;
            case R.id.continent_NorthAmerica_2:
                Main_img.setVisibility(View.INVISIBLE);
                Asia_img.setVisibility(View.INVISIBLE);
                Africa_img.setVisibility(View.INVISIBLE);
                Oceania_img.setVisibility(View.INVISIBLE);
                NorthAmerica_img.setVisibility(View.VISIBLE);
                SouthAmerica_img.setVisibility(View.INVISIBLE);
                Europe_img.setVisibility(View.INVISIBLE);
                break;
            case R.id.continent_SouthAmerica:
                Main_img.setVisibility(View.INVISIBLE);
                Asia_img.setVisibility(View.INVISIBLE);
                Africa_img.setVisibility(View.INVISIBLE);
                Oceania_img.setVisibility(View.INVISIBLE);
                NorthAmerica_img.setVisibility(View.INVISIBLE);
                SouthAmerica_img.setVisibility(View.VISIBLE);
                Europe_img.setVisibility(View.INVISIBLE);
                break;
            case R.id.continent_Europe:
                Main_img.setVisibility(View.INVISIBLE);
                Asia_img.setVisibility(View.INVISIBLE);
                Africa_img.setVisibility(View.INVISIBLE);
                Oceania_img.setVisibility(View.INVISIBLE);
                NorthAmerica_img.setVisibility(View.INVISIBLE);
                SouthAmerica_img.setVisibility(View.INVISIBLE);
                Europe_img.setVisibility(View.VISIBLE);
                break;


        }

    }

    public static Context getContext() {
        return context;
    }
}
