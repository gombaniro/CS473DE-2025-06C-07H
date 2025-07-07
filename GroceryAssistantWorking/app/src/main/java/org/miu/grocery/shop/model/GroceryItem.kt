package org.miu.grocery.shop.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class GroceryItem(
    val name: String,
    @DrawableRes val imageRes: Int,
    val price: Double,
    val description: String
) : Parcelable