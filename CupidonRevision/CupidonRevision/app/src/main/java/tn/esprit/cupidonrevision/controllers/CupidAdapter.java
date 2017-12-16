package tn.esprit.cupidonrevision.controllers;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tn.esprit.cupidonrevision.R;
import tn.esprit.cupidonrevision.models.Cupidon;

/**
 * Created by wael on 09/10/2017.
 */

public class CupidAdapter extends ArrayAdapter<Cupidon> {

    public static class ViewHolder{
        TextView txtNames;
        TextView txtScore;
        ImageView imgSmiley;
    }

    public CupidAdapter(@NonNull Context context, List<Cupidon> cupidons) {
        super(context, 0, cupidons);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Cupidon cupidon = getItem(position);
        ViewHolder vh;
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_cupid, parent, false);
            vh = new ViewHolder();
            vh.txtNames = (TextView) convertView.findViewById(R.id.txtNames);
            vh.txtScore = (TextView) convertView.findViewById(R.id.txtScore);
            vh.imgSmiley = (ImageView) convertView.findViewById(R.id.imgSmiley);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }

        vh.txtNames.setText(cupidon.getNom_fille()+" - "+cupidon.getNom_garcon());
        vh.txtScore.setText(cupidon.getScore()+"%");
        if (cupidon.getScore() > 50){
            vh.imgSmiley.setImageResource(R.drawable.inlove);
        }else if (cupidon.getScore() < 50){
            vh.imgSmiley.setImageResource(R.drawable.unhappy);
        }else if (cupidon.getScore() == 50){
            vh.imgSmiley.setImageResource(R.drawable.suspicious);
        }
        return convertView;
    }
}
