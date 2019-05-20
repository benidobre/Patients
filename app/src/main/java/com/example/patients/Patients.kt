package com.example.patients

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Patients(
    val administered_drug_treatment: String,
    val diagnosis_code: String,
    val diagnosis_description: String,
    val diagnosis_description_detailed: String,
    val email: String,
    val first_name: String,
    val gender: String,
    val id: Int,
    val last_name: String
) : Parcelable