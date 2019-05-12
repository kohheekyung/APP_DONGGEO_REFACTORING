package donggeo.appdonggeorefactoring;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import org.json.JSONObject;

public class WritePostActivity extends AppCompatActivity {

    private static Context context;

    String[] exchangeRate = {
            "유럽연합 EUR", "독일 EUR", "프랑스 EUR", "이탈리아 EUR", "스페인 EUR", "포르투갈 EUR", "그리스 EUR", "네덜란드 EUR", "오스트리아 EUR", "벨기에 EUR", "아일랜드 EUR", "슬로바키아 EUR", "리투아니아 EUR", "핀란드 EUR", //유럽 코드 1
            "영국 GBP", "스위스 CHF", "스웨덴 SEK", "체코 CZK", "덴마크 DKK", "노르웨이 NOK", "러시아 RUB", "폴란드 PLN", //유럽 코드 1
            "일본 JPY", "중국 CNY", "홍콩 HKD", "대만 TWD", "몽골 MNT", "카자흐스탄 KZT", "인도 INR", "파키스탄 PKR", // 동아시아 코드 2
            "태국 THB", "싱가포르 SGD", "말레이시아 MYR", "인도네시아 IDR", "브루나이 BND", "베트남 VND",// 동남 아시아 코드 3
            "오만 OMR", "터키 TRY", "이스라엘 ILS", "사우디아라비아 SAR", "쿠웨이트 KWD", "바레 BHD", "아랍에미리트 AED", "요르단 JOD", "카타르 QAR", //중동 코드 4
            "호주 AUD", "뉴질랜드 NZD", //오세아니아 코드 5
            "캐나다 CAD", "미국 USD", //북아메리카 코드 6
            "칠레 CLP", "브라질 BRL",  // 남아메리카 코드 7
            "이집트 EGP", "남아공 ZAR", // 아프리카 코드 8
    };

    String[] school_item = { "가톨릭대학교", "감리교신학대학교", "건국대학교", "경희대학교", "고려대학교", "광운대학교", "국민대학교",
            "덕성여자대학교", "동국대학교", "동덕여자대학교", "명지대학교", "삼육대학교", "상명대학교", "서강대학교",
            "서경대학교", "서울과학기술대학교", "서울교육대학교", "서울기독대학교", "서울대학교", "서울시립대학교",
            "서울여자대학교", "서울한영대학교", "성공회대학교", "성균관대학교", "성신여자대학교", "세종대학교", "숙명여자대학교",
            "숭실대학교", "연세대학교", "이화여자대학교", "장로회신학대학교", "중앙대학교", "총신대학교", "추계예술대학교",
            "한국성서대학교", "한국외국어대학교", "한국체육대학교", "한성대학교", "한양대학교", "홍익대학교"};
    EditText exchangeInput;
    EditText priceInput;
    EditText schoolInput;
    InputMethodManager im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_post);

        exchangeInput = (EditText)findViewById(R.id.exchangeInput);
        priceInput = (EditText)findViewById(R.id.priceInput);
        schoolInput = (EditText)findViewById(R.id.schoolInput);
        AutoCompleteTextView exchangeView = (AutoCompleteTextView) findViewById(R.id.exchangeInput);

        exchangeView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, exchangeRate));

        MultiAutoCompleteTextView schoolView =
                (MultiAutoCompleteTextView) findViewById(R.id.schoolInput);
        schoolView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        schoolView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, school_item));
        context = WritePostActivity.this;
        im = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.writeButton:
                String exchange = exchangeInput.getText().toString();
                //선택한 국가 대륙판단하기
                int continent = checkState(exchange);
                Log.d("continent", String.valueOf(continent));
                int amount = Integer.parseInt(priceInput.getText().toString());
                String school =  schoolInput.getText().toString(); //지금은 한개지만, 향후 여러개로 수정해야할듯

                Toast.makeText(this, "통화 " + exchange + " 금액 " + amount + " 학교 " + school, Toast.LENGTH_LONG).show();
                break;
        }
    }

    private int checkState(String exchange) {

        if( exchange.equals("유럽연합 EUR") ||  exchange.equals("영국 GBP") ||  exchange.equals("스위스 CHF") ||  exchange.equals("스웨덴 SEK") ||  exchange.equals("체코 CZK") ||  exchange.equals("덴마크 DKK") ||  exchange.equals("노르웨이 NOK") ||  exchange.equals("러시아 RUB") ||  exchange.equals("폴란드 PLN") )
            return  1;//유럽 코드 1
        else if( exchange.equals("일본 JPY") ||  exchange.equals("중국 CNY") ||  exchange.equals("홍콩 HKD") ||  exchange.equals("대만 TWD") ||   exchange.equals("몽골 MNT") ||  exchange.equals("카자흐스탄 KZT") ||  exchange.equals("인도 INR") ||  exchange.equals("파키스탄 PKR"))
            return  2; // 북아시아 코드 2
        else if( exchange.equals("태국 THB") ||  exchange.equals("싱가포르 SGD") ||  exchange.equals("말레이시아 MYR") ||  exchange.equals("인도네시아 IDR") ||   exchange.equals("브루나이 BND") ||  exchange.equals("베트남 VND"))
            return  3;// 동남 아시아 코드 3
        else if( exchange.equals("오만 OMR") ||  exchange.equals("터키 TRY") ||  exchange.equals("이스라엘 ILS") ||  exchange.equals("사우디아라비아 SAR") ||  exchange.equals("쿠웨이트 KWD") ||  exchange.equals("바레 BHD") ||   exchange.equals("아랍에미리트 AED") ||  exchange.equals("요르단 JOD") ||  exchange.equals( "카타르 QAR"))
            return 4;//중동 코드 4
        else if ( exchange.equals("호주 AUD") ||  exchange.equals("뉴질랜드 NZD"))
            return 5;//오세아니아 코드 5
        else if (  exchange.equals("캐나다 CAD") ||  exchange.equals("미국 USD"))
            return 6;//북아메리카 코드 6
        else if( exchange.equals("칠레 CLP") ||  exchange.equals("브라질 BRL"))
            return 7;// 남아메리카 코드 7
        else if(  exchange.equals("이집트 EGP") ||  exchange.equals("남아공 ZAR"))
            return 8;// 아프리카 코드 8
        else
            return 0;

    }
}
