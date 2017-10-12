package paras.app.qrcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    LinearLayout ll;
    TextView tv;

    private IntentIntegrator qrScan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll=(LinearLayout)findViewById(R.id.ll);
        tv=(TextView)findViewById(R.id.textView2);
        qrScan = new IntentIntegrator(this);

        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrScan.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        String go;
        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
               // Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
               //  Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
               // tv.setText(result.getContents());
                go=result.getContents();

                Intent in=new Intent(MainActivity.this,OpenWithQr.class);
                in.putExtra("code",go);
                startActivity(in);
                }
            }
         else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
