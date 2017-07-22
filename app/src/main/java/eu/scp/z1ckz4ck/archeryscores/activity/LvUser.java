package eu.scp.z1ckz4ck.archeryscores.activity;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.Serializable;

/**
 * Created by z1ckz4ck on 14.04.17.
 */
public class LvUser {

    private static final String TAG = "LvUser";

    private int userId;
    private String firstName;
    private String lastName;
    private ImageButton config;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ImageButton getConfig() {
        return config;
    }

    public void setConfig(ImageButton config) {
        this.config = config;
    }
}
