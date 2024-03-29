package com.shubham.myapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

public class ItemViewModel extends ViewModel {
     LiveData<PagedList<Item>> itemPagedList;
    private LiveData<PageKeyedDataSource<Integer, Item>> liveDataSource;

    public ItemViewModel() {
        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory();
        liveDataSource = itemDataSourceFactory.getDataSource();

        PagedList.Config config=(new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPageSize(ItemDataSource.PAGE_SIZE)
                .build();

        itemPagedList=(new LivePagedListBuilder(itemDataSourceFactory,config)).build();
    }
}
