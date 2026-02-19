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

        // Data Kampus Resmi Tangerang & Tangerang Selatan
        allCampuses = listOf(
            Campus(
                "Universitas Multimedia Nusantara (UMN)",
                "Jl. Scientia Boulevard, Gading Serpong, Tangerang",
                "Universitas yang berfokus pada teknologi, kreativitas, dan kewirausahaan.",
                "https://www.umn.ac.id/wp-content/uploads/2021/02/Gedung-UMN.jpg",
                "Perpustakaan modern, Studio TV, Laboratorium iMac, Skystar Ventures Tech Incubator",
                "Pendaftaran: 1 September 2024 - 31 Juli 2025 (Gelombang 1-3)",
                "Umum",
                "Dr. Ninok Leksono, M.A.",
                listOf(
                    Faculty("Fakultas Teknologi Informasi", "Dr. Eng. Niki Prastomo", listOf(
                        StudyProgram("Informatika", "Marlinda Vasti Holong, S.Kom., M.Kom."),
                        StudyProgram("Sistem Informasi", "Rindlo Tianti, S.Kom., M.Kom."),
                        StudyProgram("Teknik Komputer", "Arya Wicaksana, S.Kom., M.Eng.")
                    )),
                    Faculty("Fakultas Seni dan Desain", "Muhammad Cahya Mulya Daulay, S.Sn., M.Ds.", listOf(
                        StudyProgram("Desain Komunikasi Visual", "Fonita Theresia Yoliando, S.Ds., M.A."),
                        StudyProgram("Film & Animasi", "Kus Sudarsono, S.E., M.Sn.")
                    ))
                )
            ),
            Campus(
                "Universitas Pelita Harapan (UPH)",
                "Mh. Thamrin Boulevard, Lippo Village, Tangerang",
                "Universitas swasta Kristen dengan standar internasional dan fasilitas medis unggulan.",
                "https://www.uph.edu/wp-content/uploads/2023/05/UPH-Tower-scaled.jpg",
                "Mochtar Riady Institute, Hope Clinic, Concert Hall, Sport Center",
                "Pendaftaran: 1 Agustus 2024 - 30 Juni 2025",
                "Umum",
                "Dr. (Hon) Jonathan L. Parapak, M.Eng.Sc.",
                listOf(
                    Faculty("Fakultas Kedokteran", "Prof. Dr. dr. Eka J. Wahjoepramono", listOf(
                        StudyProgram("Kedokteran", "dr. Andree Kurniawan, Sp.PD."),
                        StudyProgram("Keperawatan", "Christine L. Sommers, Ph.D.")
                    )),
                    Faculty("Fakultas Hukum", "Dr. Velliana Tanaya, S.H., M.H.", listOf(
                        StudyProgram("Ilmu Hukum", "Dr. Velliana Tanaya, S.H., M.H.")
                    ))
                )
            ),
            Campus(
                "BINUS University @Alam Sutera",
                "Jl. Jalur Sutera Barat, Alam Sutera, Tangerang",
                "Kampus berbasis teknologi yang mencetak entrepreneur global.",
                "https://binus.ac.id/wp-content/uploads/2022/01/Alam-Sutera-Campus-1024x683.jpg",
                "Creative Lab, Smart Class, Library, Student Lounge",
                "Pendaftaran: Sepanjang Tahun (Rolling Admission)",
                "Umum",
                "Dr. Nelly, S.Kom., M.M., CSCA",
                listOf(
                    Faculty("School of Computer Science", "Fredy Purnomo, S.Kom., M.Kom.", listOf(
                        StudyProgram("Cyber Security", "Yohan Muliono, S.Kom., M.Ti."),
                        StudyProgram("Game Application & Technology", "David")
                    )),
                    Faculty("School of Design", "Danendro Adi, S.Sn., M.Arts.", listOf(
                        StudyProgram("Interior Design", "Anak Agung Ayu Wulandari, S.Sn., M.Ds."),
                        StudyProgram("New Media", "Noeratri Andanwetana, S.Sn., M.Ds.")
                    ))
                )
            ),
            Campus(
                "UIN Syarif Hidayatullah Jakarta",
                "Jl. Ir. H. Juanda No. 95, Ciputat, Tangerang Selatan",
                "Universitas Islam Negeri tertua dan terbaik di Indonesia.",
                "https://www.uinjkt.ac.id/wp-content/uploads/2022/03/Rektorat-UIN-Jakarta.jpg",
                "Masjid Al-Jamiah, Sport Center, Rumah Sakit UIN, Perpustakaan Pusat",
                "Jalur SPAN-PTKIN: 12 Feb - 15 Maret 2024; Jalur UM-PTKIN: 17 April - 15 Juni 2024",
                "Umum",
                "Prof. Asep Saepudin Jahar, M.A., Ph.D.",
                listOf(
                    Faculty("Fakultas Sains dan Teknologi", "Husni Teja Sukmana, Ph.D.", listOf(
                        StudyProgram("Teknik Informatika", "Siti Ummi Masruroh, M.Sc."),
                        StudyProgram("Sistem Informasi", "Dr. A'ang Subiyakto")
                    )),
                    Faculty("Fakultas Kedokteran", "dr. Hari Hendarto, Ph.D., Sp.PD-KEMD.", listOf(
                        StudyProgram("Kedokteran", "dr. Achmad Zaki, M.Epid., Sp.OT.")
                    ))
                )
            ),
            Campus(
                "Universitas Pamulang (UNPAM)",
                "Jl. Surya Kencana No. 1, Pamulang, Tangerang Selatan",
                "Universitas dengan biaya terjangkau dan aksesibilitas tinggi bagi masyarakat.",
                "https://unpam.ac.id/wp-content/uploads/2018/01/unpam-pusat.jpg",
                "Laboratorium Hukum, Studio Radio, Business Center, Perpustakaan",
                "Pendaftaran Gelombang 1: Jan - April 2024; Gelombang 2: Mei - Agustus 2024",
                "Umum",
                "Dr. E. Nurzaman AM, M.M., M.Si.",
                listOf(
                    Faculty("Fakultas Ekonomi dan Bisnis", "Dr. H. Endang Ruhiyat, S.E., M.M., CSRA.", listOf(
                        StudyProgram("Manajemen", "Dr. Ali Maddinsyah, S.E., M.M."),
                        StudyProgram("Akuntansi", "Eka Rima Prasetya, S.E., M.M.")
                    )),
                    Faculty("Fakultas Teknik", "Syaiful Bakhri, S.T., M.Eng.Sc., Ph.D.", listOf(
                        StudyProgram("Teknik Informatika", "Achmad Udin Zailani, S.Kom., M.Kom."),
                        StudyProgram("Teknik Elektro", "Ariyawan Sunardi, S.T., M.T.")
                    ))
                )
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
