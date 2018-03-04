package id.co.rezkiananda.learn.programminglanguage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CongratulationActivity extends AppCompatActivity {
    Button feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulation);

        feedback = findViewById(R.id.buttonFeedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goEmail();
            }
        });
    }

    private void goEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "muhammad.rezki.ananda@gmail.com", null));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Programming Language - Feedback");

        startActivity(Intent.createChooser(intent, "Send email..."));
    }
}
