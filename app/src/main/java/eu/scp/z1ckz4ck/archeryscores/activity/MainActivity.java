package eu.scp.z1ckz4ck.archeryscores.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import eu.scp.z1ckz4ck.archeryscores.R;
import eu.scp.z1ckz4ck.archeryscores.customAdapter.UserAdapter;
import eu.scp.z1ckz4ck.archeryscores.entity.Parcour;
import eu.scp.z1ckz4ck.archeryscores.entity.User;
import eu.scp.z1ckz4ck.archeryscores.enums.ScoreType;
import eu.scp.z1ckz4ck.archeryscores.services.ScoreTrackerService;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ScoreTrackerActivity";

    private Button btnStart;
    private Spinner sp_pacour;
    private ScoreTrackerService sts;
    private Parcour choosenParcour;
    private Spinner spScorePoints;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_tracker);
        sts = (ScoreTrackerService) getApplication();
        init();
        start();
    }


    /**
     * Initialize the Activity
     */
    public void init() {
        //Pacour
       Button btnOpenParcourNew = (Button) findViewById(R.id.btn_add_pakour);
        btnOpenParcourNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userNew = new Intent(MainActivity.this, ParcourNew.class);
                startActivityForResult(userNew, 30);
            }
        });
        sp_pacour = (Spinner) findViewById(R.id.sp_pakour);
        sp_pacour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object itemAtPosition = parent.getItemAtPosition(position);
                System.out.println(itemAtPosition.toString());
                //TODO: implement
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //ScorePoints
        spScorePoints = (Spinner) findViewById(R.id.sp_score);
        addScoresToSpinner(spScorePoints);
        spScorePoints.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object itemAtPosition = parent.getItemAtPosition(position);

                if (ScoreType.NFAS_SPECIAL.getDiscription().equals(itemAtPosition.toString())) {
                    sts.setScoreType(ScoreType.NFAS_SPECIAL);

                } else {
                    sts.setScoreType(ScoreType.NFAS_STANDARD);
                }
                Log.i(TAG, sts.getScoreType().getDiscription());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Users -> open user Activity to add User
        Button btn_addUserNew = (Button) findViewById(R.id.btn_adduser);
        btn_addUserNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userNew = new Intent(MainActivity.this, UserNew.class);
                startActivityForResult(userNew, 20);

            }
        });
        ListView lvUsers = (ListView) findViewById(R.id.lv_users);
        createListViewUser(lvUsers);
    }

    private void createListViewUser(ListView lvUsers) {

        List<LvUser> lvUserItems = addUsersToLV();
        int lv_item_user_id = R.layout.lv_item_user;
        adapter = new UserAdapter(this, lv_item_user_id, lvUserItems) ;

        lvUsers.setAdapter(adapter);
        lvUsers.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        lvUsers.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {

            }

            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {

                Toast.makeText(MainActivity.this,"Select",Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {

            }
        });


    }



    /** adds all Users to Listview
     * @return
     */
    private List<LvUser> addUsersToLV() {
        List<LvUser> result = new ArrayList<>();
        List<User> allUser = sts.refreshAndgetAllUser();
        for (final User u : allUser) {
            LvUser lvUser = new LvUser();
            lvUser.setUserId(u.getUserId());
            lvUser.setFirstName(u.getFirstName());
            lvUser.setLastName(u.getLastName());
            ImageButton imageButton = new ImageButton(getApplicationContext());
            lvUser.setConfig(imageButton);
            result.add(lvUser);
        }

        return result;
    }

    /**
     * @param spScorePoints
     */
    private void addScoresToSpinner(Spinner spScorePoints) {
        List<String> scoreTyps = new ArrayList<>();
        scoreTyps.add(ScoreType.NFAS_STANDARD.getDiscription());
        scoreTyps.add(ScoreType.NFAS_SPECIAL.getDiscription());
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, scoreTyps);
        spScorePoints.setAdapter(adapter);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 20 && resultCode == 20) {
            createListViewUser((ListView) findViewById(R.id.lv_users));
            adapter.notifyDataSetChanged();

        }
    }


    /**
     * starts a new Pacour
     */
    private void start() {
        btnStart = (Button) findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Start Button clicked");
            }
        });
        Toast.makeText(MainActivity.this,"Start Pacour",Toast.LENGTH_SHORT).show();
    }

}
