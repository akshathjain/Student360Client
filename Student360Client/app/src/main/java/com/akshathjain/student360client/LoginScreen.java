package com.akshathjain.student360client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;

import org.jsoup.Jsoup;

public class LoginScreen extends AppCompatActivity {
    private EditText usernameEntry;
    private EditText passwordEntry;
    private String userName;
    private String password;
    private WebView tylerReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        usernameEntry = (EditText) findViewById(R.id.username_entry);
        passwordEntry = (EditText) findViewById(R.id.password_entry);

        tylerReference = (WebView) findViewById(R.id.webview);//new WebView(this);
        tylerReference.getSettings().setJavaScriptEnabled(true);
        tylerReference.loadUrl("https://portal.northallegheny.org/tsi_live/apphost/TylerSis#/login");
    }

    public void login(View v) {
        userName = usernameEntry.getText().toString();
        password = passwordEntry.getText().toString();

        tylerReference.evaluateJavascript("document.getElementById(\'inputUserName\').value = \"" + userName + "\";", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
                tylerReference.evaluateJavascript("document.getElementsByTagName(\'input\')[3].value=\"" + password + "\";", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        tylerReference.evaluateJavascript("document.getElementsByTagName(\'div\')[56].click();", new ValueCallback<String>() {
                            @Override
                            public void onReceiveValue(String value) {
                                System.out.println(tylerReference.getTitle());
                            }
                        });
                    }
                });
            }
        });

    }
}
