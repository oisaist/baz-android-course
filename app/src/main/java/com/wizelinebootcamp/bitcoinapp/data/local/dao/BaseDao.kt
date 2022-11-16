package com.wizelinebootcamp.bitcoinapp.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(obj: List<T>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertObj(obj: T)
}
