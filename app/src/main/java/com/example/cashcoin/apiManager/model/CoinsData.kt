package com.example.cashcoin.apiManager.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.math.BigInteger

data class CoinsData(
    @SerializedName("Data")
    val `data`: List<Data>,
    @SerializedName("HasWarning")
    val hasWarning: Boolean,
    @SerializedName("Message")
    val message: String,
    @SerializedName("MetaData")
    val metaData: MetaData,
    @SerializedName("RateLimit")
    val rateLimit: RateLimit,
    @SerializedName("SponsoredData")
    val sponsoredData: List<Any>,
    @SerializedName("Type")
    val type: Int
) {
    @Parcelize
    data class Data(
        @SerializedName("CoinInfo")
        val coinInfo: CoinInfo,
        @SerializedName("DISPLAY")
        val dISPLAY: DISPLAY,
        @SerializedName("RAW")
        val rAW: RAW
    ) : Parcelable {
        @Parcelize
        data class CoinInfo(
            @SerializedName("Algorithm")
            val algorithm: String,
            @SerializedName("AssetLaunchDate")
            val assetLaunchDate: String,
            @SerializedName("BlockNumber")
            val blockNumber: Int,
            @SerializedName("BlockReward")
            val blockReward: Double,
            @SerializedName("BlockTime")
            val blockTime: Double,
            @SerializedName("DocumentType")
            val documentType: String,
            @SerializedName("FullName")
            val fullName: String,
            @SerializedName("Id")
            val id: String,
            @SerializedName("ImageUrl")
            val imageUrl: String,
            @SerializedName("Internal")
            val `internal`: String,
            @SerializedName("MaxSupply")
            val maxSupply: Double,
            @SerializedName("Name")
            val name: String,
            @SerializedName("NetHashesPerSecond")
            val netHashesPerSecond: BigInteger,
            @SerializedName("ProofType")
            val proofType: String,
            @SerializedName("Rating")
            val rating: Rating,
            @SerializedName("Type")
            val type: Int,
            @SerializedName("Url")
            val url: String
        ) : Parcelable {
            @Parcelize
            data class Rating(
                @SerializedName("Weiss")
                val weiss: Weiss
            ) : Parcelable {
                @Parcelize
                data class Weiss(
                    @SerializedName("MarketPerformanceRating")
                    val marketPerformanceRating: String,
                    @SerializedName("Rating")
                    val rating: String,
                    @SerializedName("TechnologyAdoptionRating")
                    val technologyAdoptionRating: String
                ) : Parcelable
            }
        }

        @Parcelize
        data class DISPLAY(
            @SerializedName("USD")
            val uSD: USD
        ) : Parcelable {
            @Parcelize
            data class USD(
                @SerializedName("CHANGE24HOUR")
                val cHANGE24HOUR: String,
                @SerializedName("CHANGEDAY")
                val cHANGEDAY: String,
                @SerializedName("CHANGEHOUR")
                val cHANGEHOUR: String,
                @SerializedName("CHANGEPCT24HOUR")
                val cHANGEPCT24HOUR: String,
                @SerializedName("CHANGEPCTDAY")
                val cHANGEPCTDAY: String,
                @SerializedName("CHANGEPCTHOUR")
                val cHANGEPCTHOUR: String,
                @SerializedName("CIRCULATINGSUPPLY")
                val cIRCULATINGSUPPLY: String,
                @SerializedName("CIRCULATINGSUPPLYMKTCAP")
                val cIRCULATINGSUPPLYMKTCAP: String,
                @SerializedName("CONVERSIONLASTUPDATE")
                val cONVERSIONLASTUPDATE: String,
                @SerializedName("CONVERSIONSYMBOL")
                val cONVERSIONSYMBOL: String,
                @SerializedName("CONVERSIONTYPE")
                val cONVERSIONTYPE: String,
                @SerializedName("FROMSYMBOL")
                val fROMSYMBOL: String,
                @SerializedName("HIGH24HOUR")
                val hIGH24HOUR: String,
                @SerializedName("HIGHDAY")
                val hIGHDAY: String,
                @SerializedName("HIGHHOUR")
                val hIGHHOUR: String,
                @SerializedName("IMAGEURL")
                val iMAGEURL: String,
                @SerializedName("LASTMARKET")
                val lASTMARKET: String,
                @SerializedName("LASTTRADEID")
                val lASTTRADEID: String,
                @SerializedName("LASTUPDATE")
                val lASTUPDATE: String,
                @SerializedName("LASTVOLUME")
                val lASTVOLUME: String,
                @SerializedName("LASTVOLUMETO")
                val lASTVOLUMETO: String,
                @SerializedName("LOW24HOUR")
                val lOW24HOUR: String,
                @SerializedName("LOWDAY")
                val lOWDAY: String,
                @SerializedName("LOWHOUR")
                val lOWHOUR: String,
                @SerializedName("MARKET")
                val mARKET: String,
                @SerializedName("MKTCAP")
                val mKTCAP: String,
                @SerializedName("MKTCAPPENALTY")
                val mKTCAPPENALTY: String,
                @SerializedName("OPEN24HOUR")
                val oPEN24HOUR: String,
                @SerializedName("OPENDAY")
                val oPENDAY: String,
                @SerializedName("OPENHOUR")
                val oPENHOUR: String,
                @SerializedName("PRICE")
                val pRICE: String,
                @SerializedName("SUPPLY")
                val sUPPLY: String,
                @SerializedName("TOPTIERVOLUME24HOUR")
                val tOPTIERVOLUME24HOUR: String,
                @SerializedName("TOPTIERVOLUME24HOURTO")
                val tOPTIERVOLUME24HOURTO: String,
                @SerializedName("TOSYMBOL")
                val tOSYMBOL: String,
                @SerializedName("TOTALTOPTIERVOLUME24H")
                val tOTALTOPTIERVOLUME24H: String,
                @SerializedName("TOTALTOPTIERVOLUME24HTO")
                val tOTALTOPTIERVOLUME24HTO: String,
                @SerializedName("TOTALVOLUME24H")
                val tOTALVOLUME24H: String,
                @SerializedName("TOTALVOLUME24HTO")
                val tOTALVOLUME24HTO: String,
                @SerializedName("VOLUME24HOUR")
                val vOLUME24HOUR: String,
                @SerializedName("VOLUME24HOURTO")
                val vOLUME24HOURTO: String,
                @SerializedName("VOLUMEDAY")
                val vOLUMEDAY: String,
                @SerializedName("VOLUMEDAYTO")
                val vOLUMEDAYTO: String,
                @SerializedName("VOLUMEHOUR")
                val vOLUMEHOUR: String,
                @SerializedName("VOLUMEHOURTO")
                val vOLUMEHOURTO: String
            ) : Parcelable
        }

        @Parcelize
        data class RAW(
            @SerializedName("USD")
            val uSD: USD
        ) : Parcelable {
            @Parcelize
            data class USD(
                @SerializedName("CHANGE24HOUR")
                val cHANGE24HOUR: Double,
                @SerializedName("CHANGEDAY")
                val cHANGEDAY: Double,
                @SerializedName("CHANGEHOUR")
                val cHANGEHOUR: Double,
                @SerializedName("CHANGEPCT24HOUR")
                val cHANGEPCT24HOUR: Double,
                @SerializedName("CHANGEPCTDAY")
                val cHANGEPCTDAY: Double,
                @SerializedName("CHANGEPCTHOUR")
                val cHANGEPCTHOUR: Double,
                @SerializedName("CIRCULATINGSUPPLY")
                val cIRCULATINGSUPPLY: Double,
                @SerializedName("CIRCULATINGSUPPLYMKTCAP")
                val cIRCULATINGSUPPLYMKTCAP: Double,
                @SerializedName("CONVERSIONLASTUPDATE")
                val cONVERSIONLASTUPDATE: Int,
                @SerializedName("CONVERSIONSYMBOL")
                val cONVERSIONSYMBOL: String,
                @SerializedName("CONVERSIONTYPE")
                val cONVERSIONTYPE: String,
                @SerializedName("FLAGS")
                val fLAGS: String,
                @SerializedName("FROMSYMBOL")
                val fROMSYMBOL: String,
                @SerializedName("HIGH24HOUR")
                val hIGH24HOUR: Double,
                @SerializedName("HIGHDAY")
                val hIGHDAY: Double,
                @SerializedName("HIGHHOUR")
                val hIGHHOUR: Double,
                @SerializedName("IMAGEURL")
                val iMAGEURL: String,
                @SerializedName("LASTMARKET")
                val lASTMARKET: String,
                @SerializedName("LASTTRADEID")
                val lASTTRADEID: String,
                @SerializedName("LASTUPDATE")
                val lASTUPDATE: Int,
                @SerializedName("LASTVOLUME")
                val lASTVOLUME: Double,
                @SerializedName("LASTVOLUMETO")
                val lASTVOLUMETO: Double,
                @SerializedName("LOW24HOUR")
                val lOW24HOUR: Double,
                @SerializedName("LOWDAY")
                val lOWDAY: Double,
                @SerializedName("LOWHOUR")
                val lOWHOUR: Double,
                @SerializedName("MARKET")
                val mARKET: String,
                @SerializedName("MEDIAN")
                val mEDIAN: Double,
                @SerializedName("MKTCAP")
                val mKTCAP: Double,
                @SerializedName("MKTCAPPENALTY")
                val mKTCAPPENALTY: Int,
                @SerializedName("OPEN24HOUR")
                val oPEN24HOUR: Double,
                @SerializedName("OPENDAY")
                val oPENDAY: Double,
                @SerializedName("OPENHOUR")
                val oPENHOUR: Double,
                @SerializedName("PRICE")
                val pRICE: Double,
                @SerializedName("SUPPLY")
                val sUPPLY: Double,
                @SerializedName("TOPTIERVOLUME24HOUR")
                val tOPTIERVOLUME24HOUR: Double,
                @SerializedName("TOPTIERVOLUME24HOURTO")
                val tOPTIERVOLUME24HOURTO: Double,
                @SerializedName("TOSYMBOL")
                val tOSYMBOL: String,
                @SerializedName("TOTALTOPTIERVOLUME24H")
                val tOTALTOPTIERVOLUME24H: Double,
                @SerializedName("TOTALTOPTIERVOLUME24HTO")
                val tOTALTOPTIERVOLUME24HTO: Double,
                @SerializedName("TOTALVOLUME24H")
                val tOTALVOLUME24H: Double,
                @SerializedName("TOTALVOLUME24HTO")
                val tOTALVOLUME24HTO: Double,
                @SerializedName("TYPE")
                val tYPE: String,
                @SerializedName("VOLUME24HOUR")
                val vOLUME24HOUR: Double,
                @SerializedName("VOLUME24HOURTO")
                val vOLUME24HOURTO: Double,
                @SerializedName("VOLUMEDAY")
                val vOLUMEDAY: Double,
                @SerializedName("VOLUMEDAYTO")
                val vOLUMEDAYTO: Double,
                @SerializedName("VOLUMEHOUR")
                val vOLUMEHOUR: Double,
                @SerializedName("VOLUMEHOURTO")
                val vOLUMEHOURTO: Double
            ) : Parcelable
        }
    }

    data class MetaData(
        @SerializedName("Count")
        val count: Int
    )

    class RateLimit
}