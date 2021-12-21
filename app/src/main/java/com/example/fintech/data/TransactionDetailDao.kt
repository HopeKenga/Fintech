package com.example.fintech.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.fintech.data.Transaction


@Dao
interface TransactionDetailDao {
    @Query("SELECT * FROM `transaction` WHERE `id` = :id")
    fun getTask(id: Long): LiveData<Transaction>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(transaction: Transaction): Long

    @Update
    suspend fun updateTask(transaction: Transaction)

    @Delete
    suspend fun deleteTask(transaction: Transaction)
}