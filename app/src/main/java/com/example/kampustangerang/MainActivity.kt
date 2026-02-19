package com.example.kampustangerang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kampustangerang.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var allCampuses: List<Campus>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari Intent (dikirim dari LoginActivity)
        val name = intent.getStringExtra("USERNAME") ?: "User"
        val school = intent.getStringExtra("SCHOOL") ?: "-"
        val userClass = intent.getStringExtra("CLASS") ?: "-"
        val interest = intent.getStringExtra("INTEREST") ?: "IPA"

        // Update Tampilan Profil
        binding.tvStudentName.text = "Nama: $name"
        binding.tvStudentSchool.text = "Asal Sekolah: $school"
        binding.tvStudentClass.text = "Kelas: $userClass"

        // Set RadioButton sesuai minat user
        when (interest) {
            "IPA" -> binding.rbIpa.isChecked = true
            "IPS" -> binding.rbIps.isChecked = true
            "Bahasa" -> binding.rbBahasa.isChecked = true
        }

        // Data Dummy Kampus
        allCampuses = listOf(
            Campus(
                "Universitas Multimedia Nusantara (UMN)",
                "Gading Serpong, Tangerang",
                "Fokus pada bidang teknologi informasi dan komunikasi.",
                "https://www.umn.ac.id/wp-content/uploads/2021/02/Gedung-UMN.jpg",
                "Perpustakaan modern, Studio TV, Laboratorium iMac",
                "1 Oktober 2023 - 31 Desember 2023",
                "IPA"
            ),
            Campus(
                "Universitas Pelita Harapan (UPH)",
                "Karawaci, Tangerang",
                "Universitas swasta ternama dengan fasilitas internasional.",
                "https://www.uph.edu/wp-content/uploads/2023/05/UPH-Tower-scaled.jpg",
                "Concert Hall, Museum, Kolam Renang Olympic",
                "1 September 2023 - 30 November 2023",
                "Umum"
            ),
            Campus(
                "Prasetya Mulya Business School",
                "BSD City, Tangerang",
                "Sekolah bisnis terbaik untuk peminatan manajemen dan ekonomi.",
                "https://www.prasetiyamulya.ac.id/img/campus-bsd.jpg",
                "Business Hub, Library, Discussion Room",
                "1 Januari 2024 - 31 Maret 2024",
                "IPS"
            ),
            Campus(
                "STBA Jia",
                "Tangerang",
                "Sekolah tinggi bahasa asing dengan fokus bahasa Jepang dan Inggris.",
                "https://stbajia.ac.id/img/bg.jpg",
                "Language Lab, Library",
                "1 April 2024 - 30 Juni 2024",
                "Bahasa"
            )
        )

        setupRecyclerView(interest)

        binding.rgInterest.setOnCheckedChangeListener { _, checkedId ->
            val selectedRadioButton = findViewById<RadioButton>(checkedId)
            val selectedInterest = selectedRadioButton.text.toString()
            filterCampuses(selectedInterest)
        }
    }

    private fun setupRecyclerView(category: String) {
        val filteredList = allCampuses.filter { it.category == category || it.category == "Umum" }
        val adapter = CampusAdapter(filteredList)
        binding.rvCampuses.layoutManager = LinearLayoutManager(this)
        binding.rvCampuses.adapter = adapter
    }

    private fun filterCampuses(category: String) {
        val filteredList = allCampuses.filter { it.category == category || it.category == "Umum" }
        binding.rvCampuses.adapter = CampusAdapter(filteredList)
    }
}
