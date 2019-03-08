package com.antonicastejon.cryptodata.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Antoni Castejón on 04/01/2018.
 */
interface CoinMarketCapApi {
    @GET("v1/ticker/")
    fun getCryptoList(@Query("start" )start:Int, @Query("limit") limit:Int) : Single<List<Crypto>>
}


data class Crypto(
        @SerializedName("id") val id: String,
        @SerializedName("name") val name: String,
        @SerializedName("symbol") val symbol: String,
        @SerializedName("rank") val rank: Int,
        @SerializedName("price_usd") val priceUsd: String,
        @SerializedName("price_btc") val priceBtc: String,
        @SerializedName("24h_volume_usd") val twentyFourHvolumeUsd: String,
        @SerializedName("market_cap_usd") val marketCapUsd: String,
        @SerializedName("available_supply") val availableSupply: String,
        @SerializedName("total_supply") val totalSupply: String,
        @SerializedName("percent_change_1h") val percentChange1h: String,
        @SerializedName("percent_change_24h") val percentChange24h: String,
        @SerializedName("percent_change_7d") val percentChange7d: String,
        @SerializedName("last_updated") val lastUpdated: String
)


data class User(
        @SerializedName("avatar_url")
        var avatarUrl: String= "",
        @SerializedName("events_url")
        var eventsUrl: String= "",
        @SerializedName("followers_url")
        var followersUrl: String= "",
        @SerializedName("following_url")
        var followingUrl: String= "",
        @SerializedName("gists_url")
        var gistsUrl: String= "",
        @SerializedName("gravatar_id")
        var gravatarId: String= "",
        @SerializedName("html_url")
        var htmlUrl: String= "",
        @SerializedName("id")
        var id: Int,
        @SerializedName("login")
        var login: String= "",
        @SerializedName("node_id")
        var nodeId: String= "",
        @SerializedName("organizations_url")
        var organizationsUrl: String= "",
        @SerializedName("received_events_url")
        var receivedEventsUrl: String= "",
        @SerializedName("repos_url")
        var reposUrl: String= "",
        @SerializedName("site_admin")
        var siteAdmin: Boolean,
        @SerializedName("starred_url")
        var starredUrl: String= "",
        @SerializedName("subscriptions_url")
        var subscriptionsUrl: String= "",
        @SerializedName("type")
        var type: String= "",
        @SerializedName("url")
        var url: String= ""
): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readByte() != 0.toByte(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(avatarUrl)
        parcel.writeString(eventsUrl)
        parcel.writeString(followersUrl)
        parcel.writeString(followingUrl)
        parcel.writeString(gistsUrl)
        parcel.writeString(gravatarId)
        parcel.writeString(htmlUrl)
        parcel.writeInt(id)
        parcel.writeString(login)
        parcel.writeString(nodeId)
        parcel.writeString(organizationsUrl)
        parcel.writeString(receivedEventsUrl)
        parcel.writeString(reposUrl)
        parcel.writeByte(if (siteAdmin) 1 else 0)
        parcel.writeString(starredUrl)
        parcel.writeString(subscriptionsUrl)
        parcel.writeString(type)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}