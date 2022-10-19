package com.example.applicatriononclick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentActivity extends AppCompatActivity {
    Button btnIntent;
    Button btnWhatsapp;
    Button btnGoogle;
    Button btnContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        btnIntent = (Button) findViewById(R.id.btnIntent);
        btnWhatsapp = (Button) findViewById(R.id.btnWhatsapp);
        btnWhatsapp = (Button) findViewById(R.id.btnGoogle);
        btnGoogle = (Button) findViewById(R.id.btnContactos);

        btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent randomAct = new Intent(IntentActivity.this, RandomActivity.class);
                startActivity(randomAct);
            }
        });

        btnWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String applicationId = "com.whatsapp";
                try{
                    startActivity(getPackageManager().getLaunchIntentForPackage(applicationId));
                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(
                            "https://play.google.com/store/apps/details?id=com.whatsapp")));
                }
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.google.com/search?q=intents+y+activities&source=hp&ei=_VNQY_iiBIqh5NoPg7SAwAc&iflsig=AJiK0e8AAAAAY1BiDdGrTgJieQ9WEuLb6eJ6IB460bND&ved=0ahUKEwi4lcGsh-36AhWKEFkFHQMaAHgQ4dUDCAg&uact=5&oq=intents+y+activities&gs_lcp=Cgdnd3Mtd2l6EAMyCQgAEIAEEA0QEzIKCAAQHhAPEA0QEzoLCC4QgAQQsQMQgwE6CAgAEIAEELEDOgsIABCABBCxAxCDAToHCAAQgAQQAzoOCC4QgAQQsQMQgwEQ1AI6BQgAEIAEOgcIABCABBAKOggIABAWEB4QDzoGCAAQFhAeOgUIIRCgAToICCEQFhAeEB06BAghEBU6CggAEB4QDxANEApQAFjCJWCPJmgCcAB4AYABzQSIAdckkgELMS4wLjUuNC4yLjKYAQCgAQE&sclient=gws-wiz";
                Intent googleIntent = new Intent(Intent.ACTION_VIEW);
                googleIntent.setData(Uri.parse(url));
                startActivity(googleIntent);
            }
        });

        btnContactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "com.android.contacts";
                Intent contactIntent = new Intent(Intent.ACTION_VIEW);
                contactIntent.setData(Uri.parse(url));
                startActivity(contactIntent);
            }
        });
    }
}