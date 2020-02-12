package com.example.help_button;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String text;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar myToolbar = (Toolbar) findViewById(R.my_toolbar);
        //setSupportActionBar(myToolbar);

        Spinner spinner = findViewById(R.id.spinner_names);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                text = parent.getItemAtPosition(position).toString();

                switch (position) {
                    case 0:
                        phone = "0481394845";
                        break;
                    case 1:
                        phone = "0407576311";
                        break;
                    case 2:
                        phone = "0421019364";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });

        Button button = findViewById(R.id.btnSMS);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Sending SMS to " + text, Toast.LENGTH_LONG).show();

                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(phone, null, "Need Help - Mum", null, null);

                //Intent send = new Intent(Intent.ACTION_VIEW);
                //send.putExtra("address", phone);
                //send.putExtra("sms_body", "Need help - Mum");
                //send.setType("vnd.android-dir/mms-sms");
                //startActivity(send);
            }
        });

    }
}