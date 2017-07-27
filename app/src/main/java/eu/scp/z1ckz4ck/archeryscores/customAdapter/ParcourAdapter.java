package eu.scp.z1ckz4ck.archeryscores.customAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import eu.scp.z1ckz4ck.archeryscores.R;
import eu.scp.z1ckz4ck.archeryscores.activity.LvUser;
import eu.scp.z1ckz4ck.archeryscores.activity.UserNew;
import eu.scp.z1ckz4ck.archeryscores.entity.Parcour;
import eu.scp.z1ckz4ck.archeryscores.entity.User;
import eu.scp.z1ckz4ck.archeryscores.services.ScoreTrackerService;

import java.util.List;

public class ParcourAdapter extends ArrayAdapter<Parcour> {


    public ParcourAdapter(Context context, int resource, List<Parcour> parcours) {
        super(context, resource, parcours);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.lv_item_user, null);
        }



        return v;
    }


}
