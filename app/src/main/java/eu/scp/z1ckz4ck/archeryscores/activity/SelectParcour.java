package eu.scp.z1ckz4ck.archeryscores.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import eu.scp.z1ckz4ck.archeryscores.R;
import eu.scp.z1ckz4ck.archeryscores.entity.Parcour;
import eu.scp.z1ckz4ck.archeryscores.services.ScoreTrackerService;

import java.util.List;

public class SelectParcour extends AppCompatActivity {

    private static final String TAG = "SelectPacour";

    private List<Parcour> pacours;
    private ScoreTrackerService sts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_parcour);
        sts = (ScoreTrackerService) getApplication();

       // TextView title = (TextView) findViewById(R.id.txt_pacourlist);
       Button btn_createNew = (Button) findViewById(R.id.btn_create_new_parcour);
       btn_createNew.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent newPacour = new Intent(SelectParcour.this, ParcourNew.class);

               startActivityForResult(newPacour, 30);
           }
       });



    }




}
