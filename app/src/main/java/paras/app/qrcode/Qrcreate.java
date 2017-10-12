package paras.app.qrcode;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.File;

public class Qrcreate extends AppCompatActivity {

    ImageView qr;
    LinearLayout ll_create;
    EditText str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcreate);

        qr=(ImageView)findViewById(R.id.imageViewqr);
        str=(EditText)findViewById(R.id.editTextqr);
        ll_create=(LinearLayout)findViewById(R.id.ll_create);

        ll_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=str.getText().toString();
                QRCodeWriter writer = new QRCodeWriter();
                try {
                    BitMatrix bitMatrix = writer.encode(a, BarcodeFormat.QR_CODE, 512, 512);
                    int width = bitMatrix.getWidth();
                    int height = bitMatrix.getHeight();
                    Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
                    for (int x = 0; x < width; x++) {
                        for (int y = 0; y < height; y++) {
                            bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                        }
                    }
                    qr.setImageBitmap(bmp);

                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}

