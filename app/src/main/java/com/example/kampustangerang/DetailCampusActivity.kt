package com.example.kampustangerang

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kampustangerang.databinding.ActivityDetailCampusBinding

class DetailCampusActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailCampusBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCampusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener { onBackPressed() }

        val campus = intent.getSerializableExtra("EXTRA_CAMPUS") as? Campus

        campus?.let {
            binding.toolbarLayout.title = it.name
            binding.tvDetailName.text = it.name
            binding.tvDetailLocation.text = it.location
            binding.tvDetailRector.text = "Rektor: ${it.rector}"
            binding.tvDetailDescription.text = it.description
            binding.tvDetailFacilities.text = it.facilities
            binding.tvDetailRegDate.text = it.registrationDate

            // Format Fakultas dan Prodi
            val facultyInfo = StringBuilder()
            it.facultiesList.forEach { faculty ->
                facultyInfo.append("■ ${faculty.name}\n")
                facultyInfo.append("  Dekan: ${faculty.dean}\n")
                faculty.studyPrograms.forEach { prodi ->
                    facultyInfo.append("  - ${prodi.name} (${prodi.headOfProgram})\n")
                }
                facultyInfo.append("\n")
            }
            binding.tvDetailFaculties.text = facultyInfo.toString()

            Glide.with(this)
                .load(it.imageUrl)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .into(binding.ivDetailCampus)
        }
    }
}
