# Kampus Tangerang App 🎓

Aplikasi Android sederhana yang menampilkan daftar perguruan tinggi ternama di wilayah **Tangerang** dan **Tangerang Selatan**. Aplikasi ini dirancang untuk memudahkan calon mahasiswa melihat informasi singkat dan visual dari berbagai kampus di area tersebut.

## 🚀 Fitur Utama

- **Login & Registrasi**: Sistem autentikasi pengguna untuk menyimpan data profil siswa.
- **Daftar Kampus Lengkap**: Menampilkan berbagai universitas besar seperti UMN, UPH, BINUS, UNPAM, dan lainnya.
- **Visual Modern**: Menggunakan `Material Design 3` untuk tampilan yang bersih, intuitif, dan responsif.
- **Gambar Online**: Mengintegrasikan library `Glide` untuk memuat foto gedung kampus secara real-time dari internet.
- **Informasi Detail**: Menyediakan nama, lokasi, deskripsi, **daftar fasilitas**, serta **jadwal pendaftaran** setiap kampus.
- **Profil Siswa**: Menampilkan informasi personal siswa, asal sekolah, dan peminatan (IPA/IPS/Bahasa).

## 🛠️ Teknologi yang Digunakan

- **Bahasa**: [Kotlin](https://kotlinlang.org/) & [Java](https://www.java.com/)
- **UI Framework**: Android Jetpack (ViewBinding, RecyclerView, ConstraintLayout, Material Components)
- **Database**: [Room Persistence Library](https://developer.android.com/training/data-storage/room) untuk penyimpanan data lokal (User & Kampus).
- **Image Loading**: [Glide](https://github.com/bumptech/glide)
- **Minimum SDK**: API 24 (Android 7.0)
- **Target SDK**: API 35 (Android 15)

## 📸 Tampilan Aplikasi

Aplikasi memiliki alur sebagai berikut:
1. **Halaman Login/Signup**: Form pendaftaran akun baru dengan validasi.
2. **Dashboard Utama**: Menampilkan Profil Mahasiswa dan daftar rekomendasi kampus.
3. **Item Kampus**: Kartu yang berisi:
   - **Foto Kampus**: Visual gedung universitas.
   - **Nama Universitas**: Identitas kampus.
   - **Lokasi**: Area spesifik di Tangerang/Tangerang Selatan.
   - **Deskripsi**: Fokus pendidikan atau keunggulan kampus.

## ⚙️ Cara Menjalankan Proyek

1. **Clone Repository**:
   ```bash
   git clone https://github.com/username/KampusTangerang.git
   ```
2. **Buka di Android Studio**:
   Pilih "Open" dan arahkan ke folder proyek hasil clone (Gunakan Android Studio Koala atau yang lebih baru).
3. **Build & Run**:
   Tunggu proses Gradle Sync selesai, lalu jalankan pada Emulator atau Device dengan koneksi internet.

## 🔍 Troubleshooting (Pemecahan Masalah)

Jika Anda menemui kendala saat menjalankan aplikasi, coba langkah berikut:

1. **Gambar Tidak Muncul**:
   - Pastikan perangkat/emulator memiliki koneksi internet yang stabil.
   - Pastikan tag `<uses-permission android:name="android.permission.INTERNET" />` ada di `AndroidManifest.xml`.
2. **Gagal Build (SDK Not Found)**:
   - Pastikan Android SDK 35 sudah terinstal via SDK Manager di Android Studio.
3. **Aplikasi Crash saat Buka Database**:
   - Jika Anda mengubah struktur tabel di Room, Anda mungkin perlu melakukan "Uninstall" aplikasi terlebih dahulu agar database ter-reset, atau mengimplementasikan `Migration`.
4. **Error "Cannot resolve symbol 'statusBarColor'"**:
   - Lakukan **File > Sync Project with Gradle Files**. Jika masih ada, pastikan menggunakan `android:statusBarColor` pada tema yang berbasis `MaterialComponents`.

## ❓ QnA (Tanya Jawab)

**Q: Mengapa menggunakan SDK 35?**
A: SDK 35 adalah standar terbaru untuk memastikan aplikasi memiliki performa terbaik dan dukungan fitur terbaru dari Android 15.

**Q: Bisakah saya mengganti warna tema?**
A: Tentu, buka file `res/values/colors.xml` untuk mengubah palet warna dan `res/values/themes.xml` untuk menerapkannya.

**Q: Mengapa menggunakan Room daripada SQLite biasa?**
A: Room menyediakan layer abstraksi di atas SQLite yang memudahkan pengelolaan database, mencegah query error saat compile-time, dan mendukung integrasi dengan LiveData/Flow.

**Q: Bagaimana cara menambah data kampus baru?**
A: Anda bisa menambahkannya melalui inisialisasi database di kelas `AppDatabase` atau melalui form input jika fitur tersebut diimplementasikan.

## 📄 Lisensi
Proyek ini dibuat untuk tujuan pembelajaran pengembangan aplikasi Android tingkat lanjut. Silakan gunakan dan kembangkan lebih lanjut!
