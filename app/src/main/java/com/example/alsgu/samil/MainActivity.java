package com.example.alsgu.samil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);    //레이아웃 인스턴트화
        web = new WebView(this);   //웹뷰 인스턴트화
        WebSettings webSet = web.getSettings();   //웹뷰 설정 인스턴트화
        webSet.setJavaScriptEnabled(true);   //자바스크립트 활성화
        webSet.setUseWideViewPort(true);   //뷰 포트 활성화
        webSet.setBuiltInZoomControls(false);   //줌인 기능 비활성화
        webSet.setAllowUniversalAccessFromFileURLs(true);    //HTML 파일 로드를 위한 소스. 이 부분 대문에 젤리빈 이상만 지원
        webSet.setJavaScriptCanOpenWindowsAutomatically(true);   //window.open 메소드 사용을 위한 부분 1
        webSet.setSupportMultipleWindows(true);   //window.open 메소드 사용을 위한 부분 2
        webSet.setSaveFormData(false);   //폼 데이터 저장 안함
        webSet.setSavePassword(false);   //비번 저장 안함
        webSet.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);   //웹뷰 크기랑 화면 크기랑 맞추는 거라던데...
        web.setWebChromeClient(new WebChromeClient());
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("file:///android_asset/index.html");  //aeests 폴더에 있는 index.html 파일을 띄움
        layout.addView(web);
        setContentView(layout);
    }

    public void onBackPressed() {    //이전 키 눌렀을 때,
        if(web.canGoBack()) web.goBack();   //뒤로가기가 가능하면 뒤로 가고
        else finish();   //아니면 앱 종료
    }

}
