package com.shahjahan.runningapp.db

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.core.graphics.BitmapCompat
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream

class Converters {

    @TypeConverter
    fun toBitmap(byteArray: ByteArray): Bitmap{
        return BitmapFactory.decodeByteArray(byteArray, 0 , byteArray.size)
    }

    @TypeConverter
    fun fromBitmap(bmp: Bitmap) : ByteArray{
        var outStream = ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.PNG, 100, outStream)
        return outStream.toByteArray();
    }
}