package com.example.kampustangerang;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.kampustangerang.databinding.ActivityMainBinding;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.root);

        List<Campus> campusList = new ArrayList<>();
        campusList.add(new Campus(
                "Universitas Multimedia Nusantara (UMN)",
                "Gading Serpong, Tangerang",
                "Fokus pada bidang teknologi informasi dan komunikasi.",
                "https://www.umn.ac.id/wp-content/uploads/2021/02/Gedung-UMN.jpg"
        ));
        campusList.add(new Campus(
                "Universitas Pelita Harapan (UPH)",
                "Lippo Village, Karawaci, Tangerang",
                "Salah satu universitas swasta ternama dengan berbagai program studi internasional.",
                "https://www.uph.edu/wp-content/uploads/2023/05/UPH-Tower-scaled.jpg"
        ));
        campusList.add(new Campus(
                "BINUS University",
                "Alam Sutera, Tangerang",
                "Kampus modern dengan fokus pada inovasi dan teknologi.",
                "https://bulatankata.com/wp-content/uploads/2022/10/binus-alsut.jpg"
        ));
        campusList.add(new Campus(
                "Prasetya Mulya Business School",
                "BSD City, Tangerang Selatan",
                "Terkenal dengan program bisnis dan kewirausahaan yang unggul.",
                "https://www.prasetiyamulya.ac.id/wp-content/uploads/2021/08/Gedung-BSD.jpg"
        ));
        campusList.add(new Campus(
                "Universitas Pamulang (UNPAM)",
                "Pamulang, Tangerang Selatan",
                "Universitas dengan jumlah mahasiswa terbanyak yang mengedepankan pendidikan terjangkau.",
                "https://unpam.ac.id/wp-content/uploads/2021/03/unpam-viktor.jpg"
        ));
        campusList.add(new Campus(
                "Swiss German University (SGU)",
                "BSD City, Tangerang Selatan",
                "Universitas internasional pertama dengan kurikulum berstandar Jerman.",
                "https://sgu.ac.id/wp-content/uploads/2017/02/The-Prominence-Tower.jpg"
        ));
        campusList.add(new Campus(
                "Universitas Muhammadiyah Tangerang (UMT)",
                "Cikokol, Tangerang",
                "Pusat pendidikan tinggi Islam di jantung kota Tangerang.",
                "https://umt.ac.id/wp-content/uploads/2022/01/gedung-umt.jpg"
        ));
        campusList.add(new Campus(
                "Atma Jaya Catholic University",
                "BSD City, Tangerang Selatan",
                "Kampus ketiga Atma Jaya yang fokus pada bidang teknik dan teknobiologi.",
                "https://www.atmajaya.ac.id/wp-content/uploads/2019/07/Gedung-BSD.jpg"
        ));
        campusList.add(new Campus(
                "Monash University Indonesia",
                "BSD City, Tangerang Selatan",
                "Kampus pascasarjana dari universitas luar negeri pertama di Indonesia.",
                "https://www.monash.edu/__data/assets/image/0004/2642737/indonesia-campus.jpg"
        ));

        CampusAdapter adapter = new CampusAdapter(campusList);
        binding.rvCampuses.setLayoutManager(new LinearLayoutManager(this));
        binding.rvCampuses.setAdapter(adapter);
    }
}
