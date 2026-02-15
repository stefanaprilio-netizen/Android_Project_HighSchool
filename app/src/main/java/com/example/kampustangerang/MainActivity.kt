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
                "Dr. Ninok Leksono, M.A.",
                "https://www.umn.ac.id/wp-content/uploads/2021/02/Gedung-UMN.jpg",
                listOf(
                    Faculty("Fakultas Teknik & Informatika", "Dr. Eng. Niki Prastomo", listOf(
                        StudyProgram("Informatika", "Marlin, S.Kom., M.T."),
                        StudyProgram("Sistem Informasi", "Ririen Setiati, S.Kom., M.M.")
                    )),
                    Faculty("Fakultas Bisnis", "Dr. Florentina, S.E., M.Si.", listOf(
                        StudyProgram("Manajemen", "Dr. Mohammad Annas"),
                        StudyProgram("Akuntansi", "Stefanus Ariyanto, S.E., M.Ak.")
                    ))
                )
            ),
            Campus(
                "Universitas Pelita Harapan (UPH)",
                "Lippo Village, Karawaci, Tangerang",
                "Salah satu universitas swasta ternama dengan berbagai program studi internasional.",
                "Dr. (Hon) Jonathan L. Parapak, M.Eng.Sc.",
                "https://www.uph.edu/wp-content/uploads/2023/05/UPH-Tower-scaled.jpg",
                listOf(
                    Faculty("Fakultas Hukum", "Dr. Velliana Tanaya, S.H., M.H.", listOf(
                        StudyProgram("Ilmu Hukum", "Dr. Susi Susantijo")
                    )),
                    Faculty("Fakultas Kedokteran", "Prof. Dr. Dr. dr. Eka J. Wahjoepramono", listOf(
                        StudyProgram("Kedokteran", "dr. Beverley W. Anne")
                    ))
                )
            ),
            Campus(
                "BINUS University",
                "Alam Sutera, Tangerang",
                "Kampus modern dengan fokus pada inovasi dan teknologi.",
                "Dr. Nelly, S.Kom., M.M.",
                "https://bulatankata.com/wp-content/uploads/2022/10/binus-alsut.jpg",
                listOf(
                    Faculty("School of Computer Science", "Fredy Purnomo, S.Kom., M.Kom.", listOf(
                        StudyProgram("Computer Science", "Derwin Suhartono, S.Kom., M.T.I.")
                    )),
                    Faculty("School of Design", "Danendro Adi, S.Sn., M.Arts.", listOf(
                        StudyProgram("Visual Communication Design", "Arsa Widitiarsa Utoyo")
                    ))
                )
            ),
            Campus(
                "Universitas Pamulang (UNPAM)",
                "Pamulang, Tangerang Selatan",
                "Universitas dengan jumlah mahasiswa terbanyak yang mengedepankan pendidikan terjangkau.",
                "Dr. E. Nurzaman AM., M.M., M.Si.",
                "https://unpam.ac.id/wp-content/uploads/2021/03/unpam-viktor.jpg",
                listOf(
                    Faculty("Fakultas Ekonomi", "Dr. H. Endang Ruhiyat", listOf(
                        StudyProgram("Manajemen", "Dr. Ali Maddinsyah")
                    )),
                    Faculty("Fakultas Teknik", "Syaiful Bakhri, S.T., M.Eng., Ph.D.", listOf(
                        StudyProgram("Teknik Informatika", "Achmad Udin Zailani, S.Kom., M.Kom.")
                    ))
                )
            )
        )

        val adapter = CampusAdapter(campusList)
        binding.rvCampuses.layoutManager = LinearLayoutManager(this)
        binding.rvCampuses.adapter = adapter
    }
}
