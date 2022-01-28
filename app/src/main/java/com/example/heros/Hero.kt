package com.example.heros
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import android.widget.ImageView
@Parcelize

data class Hero(
    val name: String,
    val description : String,
    val superpower: String,
    val ranking : Int,
    val image: String) : Parcelable, Comparable<Hero> {
        override fun compareTo(other: Hero) : Int {
            var thisRank = this.ranking
            var otherRank = other.ranking
            if (thisRank < otherRank) {
                return -1
            } else if (thisRank > otherRank) {
                return 1
            } else {
                return 0
            }
        }
}