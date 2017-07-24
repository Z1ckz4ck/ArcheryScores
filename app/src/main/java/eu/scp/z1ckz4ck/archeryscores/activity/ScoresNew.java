package eu.scp.z1ckz4ck.archeryscores.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import eu.scp.z1ckz4ck.archeryscores.R;
import eu.scp.z1ckz4ck.archeryscores.services.ScoreTrackerService;

public class ScoresNew extends AppCompatActivity {
    private static final String TAG = "Scores New";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "Create Activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores_new);



    }
}
