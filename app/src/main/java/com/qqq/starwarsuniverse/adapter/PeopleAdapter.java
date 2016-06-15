package com.qqq.starwarsuniverse.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.qqq.starwarsuniverse.R;
import com.qqq.starwarsuniverse.model.People;

import org.w3c.dom.Text;

import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>{
    private List<People> mPeople;
    private int mCardViewItem;

    public class PeopleViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView height;
        TextView mass;
        TextView hairColor;
        TextView skinColor;
        TextView eyeColor;
        TextView birthYear;
        TextView gender;

        public PeopleViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.people_name);
            height = (TextView) itemView.findViewById(R.id.people_height);
            mass = (TextView) itemView.findViewById(R.id.people_mass);
            hairColor = (TextView) itemView.findViewById(R.id.people_hair_color);
            skinColor = (TextView) itemView.findViewById(R.id.people_skin_color);
            eyeColor = (TextView) itemView.findViewById(R.id.people_eye_color);
            birthYear = (TextView) itemView.findViewById(R.id.people_birth_year);
            gender = (TextView) itemView.findViewById(R.id.people_gender);
        }
    }

    public PeopleAdapter(List<People> people, int cardViewItem) {
        mPeople = people;
        mCardViewItem = cardViewItem;
    }

    @Override
    public PeopleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(mCardViewItem, parent, false);
        return new PeopleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PeopleViewHolder holder, int position) {
        People people = mPeople.get(position);

        holder.name.setText(people.getName());
        holder.height.setText(people.getHeight());
        holder.mass.setText(people.getMass());
        holder.hairColor.setText(people.getHairColor());
        holder.skinColor.setText(people.getSkinColor());
        holder.eyeColor.setText(people.getEyeColor());
        holder.birthYear.setText(people.getBirthYear());
        holder.gender.setText(people.getGender());
    }

    @Override
    public int getItemCount() {
        return mPeople.size();
    }
}
