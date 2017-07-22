package eu.scp.z1ckz4ck.archeryscores.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import eu.scp.z1ckz4ck.archeryscores.R;
import eu.scp.z1ckz4ck.archeryscores.customAdapter.TargetAdapter;
import eu.scp.z1ckz4ck.archeryscores.entity.Parcour;
import eu.scp.z1ckz4ck.archeryscores.entity.Target;
import eu.scp.z1ckz4ck.archeryscores.enums.ScoreType;

import java.util.*;


public class ParcourNew extends AppCompatActivity {


    private Parcour parcour;
    private EditText parcourName;
    private EditText parcourTargetCount;
    private Button parcourCreate;
    private ListView listViewTargets;
    private Spinner spScoreType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcour_new);
        parcour = new Parcour("Name");
        init();
    }


    public void init() {
        parcourName = (EditText) findViewById(R.id.txt_new_parcour_name);
        parcourName.setEnabled(true);
        parcourTargetCount = (EditText) findViewById(R.id.txt_new_parcour_target_count);
        parcourTargetCount.setEnabled(false);
        parcourCreate = (Button) findViewById(R.id.btn_create_new_parcour);
        listViewTargets = (ListView) findViewById(R.id.list_targets_new_parcour);

        spScoreType = (Spinner) findViewById(R.id.sp_score_type_parcoure_new);
        String[] scoreTypes = new String[]{ScoreType.NFAS_STANDARD.getDiscription(), ScoreType.NFAS_SPECIAL.getDiscription()};
        spScoreType.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, scoreTypes));
        spScoreType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final Object scoretype = parent.getItemAtPosition(position);

                if (scoretype.toString().equals(ScoreType.NFAS_STANDARD.getDiscription())) {
                    parcour.setScoreType(ScoreType.NFAS_STANDARD);
                } else {
                    parcour.setScoreType(ScoreType.NFAS_SPECIAL);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        parcourName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    parcour.setName(parcourName.getText().toString());
                    parcourTargetCount.setEnabled(true);
                }
            }
        });


        parcourTargetCount.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String s = parcourTargetCount.getText().toString();

                    parcour.setTargetCount(Integer.valueOf(s));


                    ArrayList<String> list = new ArrayList<>();
                    for (int i = 1; i <= parcour.getTargetCount(); i++) {

                        parcour.addTargetToList(new Target(i));
                    }

                }

            }
        });


        TargetAdapter targetAdapter = new TargetAdapter(this, new ArrayList<Target>(parcour.getListTargets()));

        listViewTargets.setAdapter(targetAdapter);


    }
}
