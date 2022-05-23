package com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.local.dao.OriginCardDao
import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.data.local.entity.OriginCardEntity

@Database(
    entities = [OriginCardEntity::class],
    version = 1,
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun originCardDao(): OriginCardDao
}
