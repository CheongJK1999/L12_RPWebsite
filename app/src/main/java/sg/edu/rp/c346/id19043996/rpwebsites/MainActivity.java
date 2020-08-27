package sg.edu.rp.c346.id19043996.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView tvCat, tvCatSub;
    Spinner spnCat, spnSubCat;
    Button btnGo;
    WebView wvRP;
    ArrayList<String> alURL;
    ArrayAdapter<String> aaURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCat = findViewById(R.id.textViewCategory);
        tvCatSub = findViewById(R.id.textView2SubCat);
        spnCat = findViewById(R.id.spinnerCat);
        spnSubCat = findViewById(R.id.spinnerSubCat);
        btnGo = findViewById(R.id.buttonGo);
        wvRP = findViewById(R.id.webViewRP);

        wvRP.setWebViewClient(new WebViewClient());
        wvRP.getSettings().setJavaScriptEnabled(true);
        wvRP.getSettings().setAllowFileAccess(false);
        wvRP.getSettings().setBuiltInZoomControls(true);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = null;
                if(spnCat.getSelectedItemPosition() == 0) {
                    if(spnSubCat.getSelectedItemPosition() == 0) {
                        url = "https//www.rp.edu.sg/";
                    }  else if (spnSubCat.getSelectedItemPosition() == 1) {
                        url = "https//www.rp.edu.sg/student-life";
                    }
                } else if (spnCat.getSelectedItemPosition() == 1){
                    if(spnSubCat.getSelectedItemPosition() == 1) {
                        url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                    } else if (spnSubCat.getSelectedItemPosition() == 1){
                        url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                    }
                }
            }
        });

        spnCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
                alURL.clear();

                if (pos == 0) {
                    String[] strMenu = getResources().getStringArray(R.array.SubCate_HP);
                    alURL.addAll(Arrays.asList(strMenu));
                } else if (pos == 1){
                    String[] strMenu = getResources().getStringArray(R.array.SubCate_soi);
                    alURL.addAll(Arrays.asList(strMenu));
                }
                aaURL.notifyDataSetChanged();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }
}
