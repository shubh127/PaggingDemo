package com.shubham.myapplication;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

public class ItemDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer,Item>> dataSource=new MutableLiveData<>();

    @NonNull
    @Override
    public DataSource create() {
        ItemDataSource itemDataSource=new ItemDataSource();
        dataSource.postValue(itemDataSource);
        return itemDataSource;
    }

    MutableLiveData<PageKeyedDataSource<Integer, Item>> getDataSource() {
        return dataSource;
    }
}
