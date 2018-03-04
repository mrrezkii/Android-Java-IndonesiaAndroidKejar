package id.co.rezkiananda.learn.programminglanguage;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.co.rezkiananda.learn.programminglanguage.Model.Language;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Language language = (Language) getIntent().getSerializableExtra(MainActivity.LANGUAGE);
        setTitle(language.judul);
        ImageView ivFoto = findViewById(R.id.imageFoto);
        ivFoto.setImageURI(Uri.parse(language.gambar));

        TextView tvDeskripsi = findViewById(R.id.place_detail);
        tvDeskripsi.setText(language.deskripsi);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
