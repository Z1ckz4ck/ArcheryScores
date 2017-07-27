package eu.scp.z1ckz4ck.archeryscores.contentProv;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import eu.scp.z1ckz4ck.archeryscores.entity.Parcour;

/**
 * Created by z1ckz4ck on 14.04.17.
 */
public class DbHandlerParcours extends SQLiteOpenHelper {
    //DB
    private static final String DB_NAME = "ScoreTrackerDB";
    private static final int DB_VERSION = 1;

    //Table name
    private static final String TABLE_PARCOURS = "PARCOURS_TAB";

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
        String CREATE_PARCOUR_TABLE = "CREATE TABLE " + TABLE_PARCOURS + "(" + PARCOURS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
        PARCOURS_NAME + " TEXT NOT NULL, " + PARCOURS_COUNT_TARGETS + " INTEGER, " + PARCOURS_TIME_TO_FINISH + " TEXT, " + PARCOURS_LENGTH + "TEXT )";
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
    public void addParcour(DbParcour parcour) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PARCOURS_NAME, parcour.getName());
        values.put(PARCOURS_COUNT_TARGETS, parcour.getTargetCount());
        values.put(PARCOURS_TIME_TO_FINISH, parcour.getTimeToFinish());
        values.put(PARCOURS_LENGTH, parcour.getLenght());


        db.insert(TABLE_PARCOURS, null, values);
        db.close();
    }

    /**
     * deletes a Parcour.
     * calls deleteParcour(int id)
     *
     * @param parcour
     */
    public void deleteParcour(DbParcour parcour) {
        deleteParcour(parcour.getId());
    }

    public void deleteParcour(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PARCOURS, PARCOURS_ID + "=?", new String[]{String.valueOf(id)});
        db.close();
    }

    /**
     * Returns single Parcour by id
     *
     * @param id - of the Parcour
     * @return - a Parcour
     */
    public DbParcour getParcour(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PARCOURS, new String[]{PARCOURS_ID, PARCOURS_NAME, PARCOURS_COUNT_TARGETS, PARCOURS_TIME_TO_FINISH, PARCOURS_LENGTH}, PARCOURS_ID + "=?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            return new DbParcour(Integer.parseInt(cursor.getString(0)), cursor.getString(1), Integer.parseInt(cursor.getString(2)), cursor.getString(3), cursor.getString(4));
        }
        return null;
    }

    public void updateParcour(DbParcour parcour){
        //TODO: implement
    }


}
