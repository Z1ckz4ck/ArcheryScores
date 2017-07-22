package eu.scp.z1ckz4ck.archeryscores.contentProv;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import eu.scp.z1ckz4ck.archeryscores.entity.Parcour;

/**
 * Created by z1ckz4ck on 14.04.17.
 */
public class DbHandlerParcours extends SQLiteOpenHelper{
    //DB
    private static final String DB_NAME = "ScoreTrackerDB";
    private static final int DB_VERSION = 1;

    //Table name
    private static final String TABLE_PARCOURS = "PARCOURS";

    //Table Colums
    private static final String PARCOURS_ID = "parcours_id";
    private static final String PARCOURS_NAME = "parcours_name";
    private static final String PARCOURS_COUNT_TARGETS = "count_targets";
    private static final String PARCOURS_TIME_TO_FINISH = "time_to_finish";
    private static final String PARCOURS_LENGTH = "parcours_length";

    public DbHandlerParcours(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PARCOUR_TABLE = "CREATE TABLE " + TABLE_PARCOURS + "(" + PARCOURS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + PARCOURS_NAME + " TEXT NOT NULL, " + PARCOURS_COUNT_TARGETS + " INTEGER, " + PARCOURS_TIME_TO_FINISH + " TEXT, "+ PARCOURS_LENGTH +  "TEXT )";
        db.execSQL(CREATE_PARCOUR_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PARCOURS);
        //create table
        onCreate(db);
    }

    /**
     * Adding new parcour
     */
    public void addUser(Parcour parcour) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put(USER_ID, user.getUserId());
        values.put(PARCOURS_NAME, parcour.getName());
        values.put(PARCOURS_COUNT_TARGETS, parcour.getTargetCount());
        values.put(PARCOURS_TIME_TO_FINISH, parcour.getTimeToFinish());
        values.put(PARCOURS_LENGTH, parcour.getLenght());


        db.insert(TABLE_PARCOURS, null, values);
        db.close();
    }
}
