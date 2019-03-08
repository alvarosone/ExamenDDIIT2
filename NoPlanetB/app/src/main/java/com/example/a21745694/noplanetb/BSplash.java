package com.example.a21745694.noplanetb;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class BSplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bsplash);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.
                LayoutParams.FLAG_FULLSCREEN);

        TextView pTitle = (TextView)findViewById(R.id.tvTitulo);
        TextView pSubtitle = (TextView)findViewById(R.id.tvSubtitulo);
        final ImageView img = findViewById(R.id.imgLogoM);

        ImageView imgPlanet = findViewById(R.id.bgPlanet);

        Glide.with(this)
                .load(R.drawable.planetearth)
                .apply(new RequestOptions()

//                        .override(50, 50)
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .into(imgPlanet);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation myanim2 = AnimationUtils.loadAnimation(this, R.anim.despegue);

        pSubtitle.startAnimation(myanim);

        img.startAnimation(myanim2);
        openApp(true);
    }

    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(BSplash
                        .this, BLogin.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
