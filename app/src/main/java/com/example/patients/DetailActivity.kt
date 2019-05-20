package com.example.patients

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val patient = intent.getParcelableExtra<Patients>("pat")
        name.text = "${patient.first_name} ${patient.last_name}"
        gender.text = patient.gender
        diagnosis.text = patient.diagnosis_description
    }

    companion object{
        fun newIntent(context: Context)
                = Intent(context, DetailActivity::class.java)
    }
}
