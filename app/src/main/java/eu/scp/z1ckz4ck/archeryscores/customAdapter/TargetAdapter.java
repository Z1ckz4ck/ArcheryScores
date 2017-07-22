package eu.scp.z1ckz4ck.archeryscores.customAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import eu.scp.z1ckz4ck.archeryscores.R;
import eu.scp.z1ckz4ck.archeryscores.entity.Target;

import java.util.List;

/**
 * Created by z1ckz4ck on 23.01.17.
 */
public class TargetAdapter extends ArrayAdapter<Target> {

    public TargetAdapter(Context context, List<Target> targets) {
        super(context, 0,targets );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Target target = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.target,parent,false);
        }

        TextView targetnr = (TextView)convertView.findViewById(R.id.txt_target_nr);
        EditText targetName = (EditText)convertView.findViewById(R.id.txt_target_name);

        targetnr.setText(target.getNrTarget());
        targetName.setText(target.getNameTarget());

        return convertView;
    }

}
