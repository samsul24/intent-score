package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {
    public static final String HASIL_KEY = "hasilnya";
    private TextView homeTeam;
    private TextView awayTeam;
    private ImageView homeLogo;
    private ImageView awayLogo;

    int scoreH, scoreA = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        homeTeam = findViewById(R.id.txt_home);
        awayTeam = findViewById(R.id.txt_away);
        homeLogo = findViewById(R.id.home_logo);
        awayLogo = findViewById(R.id.away_logo);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            Bundle extra = getIntent().getExtras();
            Bitmap bmp = extra.getParcelable("homeImage");
            Bitmap bmp2 = extra.getParcelable("awayImage");

            homeLogo.setImageBitmap(bmp);
            awayLogo.setImageBitmap(bmp2);

            homeTeam.setText(extras.getString("home"));
            awayTeam.setText(extras.getString("away"));
        }
    }

    public void addscoreH(int score){
        TextView scoreView = findViewById(R.id.score_home);
        scoreView.setText(String.valueOf(score));
    }

    public void addScoreHome(View view) {
        scoreH = scoreH + 1;
        addscoreH(scoreH);
    }

    public void addscoreA(int score){
        TextView scoreView = findViewById(R.id.score_away);
        scoreView.setText(String.valueOf(score));
    }

    public void addScoreAway(View view) {
        scoreA = scoreA + 1;
        addscoreA(scoreA);
    }

    public void handleCekScore(View view) {
        String hasil = null;

        if(scoreH == scoreA){
            hasil = "SERI";
        }
        else if(scoreH > scoreA){
            hasil = homeTeam.getText().toString();
        }
        else if(scoreA > scoreH){
            hasil = awayTeam.getText().toString();
        }
        Intent intent = new Intent (this, ResultActivity.class);
        intent.putExtra(HASIL_KEY, hasil);
        startActivity(intent);
        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
    }
}
