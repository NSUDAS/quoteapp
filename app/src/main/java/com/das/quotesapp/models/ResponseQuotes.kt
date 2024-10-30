package com.das.quotesapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by S N Shekhar Das on 30/10/24.
 * upay (UCB Fintech Company Limited)
 */

@Parcelize
data class ResponseQuotes(
    @SerializedName("count")
    val count: Int= 0,
    @SerializedName("lastItemIndex")
    val lastItemIndex: Int= 0,
    @SerializedName("page")
    val page: Int= 0,
    @SerializedName("results")
    val quotesResults: List<QuotesResult>,
    @SerializedName("totalCount")
    val totalCount: Int= 0,
    @SerializedName("totalPages")
    val totalPages: Int= 0
) : Parcelable
