package com.example.kampustangerang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kampustangerang.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val campusList = listOf(
            Campus(
                "Universitas Multimedia Nusantara (UMN)",
                "Gading Serpong, Tangerang",
                "Fokus pada bidang teknologi informasi dan komunikasi.",
                "https://www.umn.ac.id/wp-content/uploads/2021/02/Gedung-UMN.jpg",
                "Perpustakaan modern, Studio TV, Laboratorium iMac, Sport Hall",
                "1 Oktober 2023 - 31 Desember 2023"
            ),
            Campus(
                "Universitas Pelita Harapan (UPH)",
                "Lippo Village, Karawaci, Tangerang",
                "Salah satu universitas swasta ternama dengan berbagai program studi internasional.",
                "https://www.uph.edu/wp-content/uploads/2023/05/UPH-Tower-scaled.jpg",
                "Museum, Kolam Renang Olympic, Lapangan Sepak Bola, Concert Hall",
                "1 September 2023 - 30 November 2023"
            ),
            Campus(
                "BINUS University",
                "Alam Sutera, Tangerang",
                "Kampus modern dengan fokus pada inovasi dan teknologi.",
                "https://bulatankata.com/wp-content/uploads/2022/10/binus-alsut.jpg",
                "Smart Classrooms, Creative Room, Kantin Higienis, Laboratorium Riset",
                "15 Oktober 2023 - 15 Januari 2024"
            ),
            Campus(
                "Universitas Pamulang (UNPAM)",
                "Pamulang, Tangerang Selatan",
                "Universitas dengan jumlah mahasiswa terbanyak yang mengedepankan pendidikan terjangkau.",
                "https://unpam.ac.id/wp-content/uploads/2021/03/unpam-viktor.jpg",
                "Masjid Kampus, Laboratorium Praktik, Kantin Murah, Parkir Luas",
                "1 Desember 2023 - 28 Februari 2024"
            )
        )

        val adapter = CampusAdapter(campusList)
        binding.rvCampuses.layoutManager = LinearLayoutManager(this)
        binding.rvCampuses.adapter = adapter
    }
}
