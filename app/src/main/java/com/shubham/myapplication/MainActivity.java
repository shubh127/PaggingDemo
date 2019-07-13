package com.shubham.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvList = findViewById(R.id.rv_recycler_view);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setHasFixedSize(true);

        ItemViewModel itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        final ItemAdapter adapter = new ItemAdapter(this);

        itemViewModel.itemPagedList.observe(this, new Observer<PagedList<Item>>() {
            @Override
            public void onChanged(PagedList<Item> items) {
                adapter.submitList(items);
            }
        });
        rvList.setAdapter(adapter);
    }
}
