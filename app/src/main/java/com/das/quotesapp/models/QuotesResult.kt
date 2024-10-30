package com.das.quotesapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by S N Shekhar Das on 30/10/24.
 *
 */

@Parcelize
data class QuotesResult(
    @SerializedName("author") val author: String,
    @SerializedName("authorSlug") val authorSlug: String,
    @SerializedName("content") val content: String,
    @SerializedName("dateAdded") val dateAdded: String,
    @SerializedName("dateModified") val dateModified: String,
    @SerializedName("_id") val id: String,
    @SerializedName("length") val length: Int,
    @SerializedName("tags") val tags: List<String>,
) : Parcelable
