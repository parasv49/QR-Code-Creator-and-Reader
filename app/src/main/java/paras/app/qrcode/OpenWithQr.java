package paras.app.qrcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.widget.TextView;
import android.widget.Toast;

public class OpenWithQr extends AppCompatActivity {

    TextView link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_with_qr);
        link=(TextView)findViewById(R.id.link);
        Intent intent = getIntent();
        String a=intent.getStringExtra("code");
        link.setText(a);
        Toast.makeText(OpenWithQr.this,a,Toast.LENGTH_LONG).show();
    }
}
