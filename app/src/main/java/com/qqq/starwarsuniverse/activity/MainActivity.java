package com.qqq.starwarsuniverse.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.qqq.starwarsuniverse.R;
import com.qqq.starwarsuniverse.adapter.PeopleAdapter;
import com.qqq.starwarsuniverse.model.People;
import com.qqq.starwarsuniverse.model.PeopleResponse;
import com.qqq.starwarsuniverse.rest.SWAPIClient;
import com.qqq.starwarsuniverse.rest.SWAPIInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creating container
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_people_container);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SWAPIInterface swapiService = SWAPIClient
                .getClient()
                .create(SWAPIInterface.class);

        Call<PeopleResponse> call = swapiService.getPeopleFromPage();
        call.enqueue(new Callback<PeopleResponse>() {
            @Override
            public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {
                List<People> people = response.body().getResults();
                recyclerView.setAdapter(new PeopleAdapter(people, R.layout.card_view_item_people));
                Log.d(TAG, "SW People from first page: " + people);
            }

            @Override
            public void onFailure(Call<PeopleResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
}
