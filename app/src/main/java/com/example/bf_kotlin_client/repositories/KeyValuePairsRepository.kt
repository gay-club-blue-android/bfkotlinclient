package com.example.bf_kotlin_client.repositories

import androidx.room.*
import com.example.bf_kotlin_client.models.KeyValuePair

@Dao
interface KeyValuePairsRepository {
    @Query("SELECT `value` from key_value_pairs WHERE `key` = :key")
    suspend fun getByKey(key: String): String?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(keyValuePair: KeyValuePair)

    @Update
    suspend fun update(keyValuePair: KeyValuePair)

    @Query("DELETE FROM key_value_pairs")
    suspend fun deleteAll()

    @Query("DELETE FROM key_value_pairs WHERE `key` = :key")
    suspend fun deleteByKey(key: String)
}