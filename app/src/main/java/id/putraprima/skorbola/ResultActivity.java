package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        hasil = findViewById(R.id.textView3);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String h = getIntent().getExtras().getString("hasilnya");
            hasil.setText(h);
        }
    }
}
