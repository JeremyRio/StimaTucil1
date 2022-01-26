[Direkomendasikan untuk membaca README.md melalui link github]
link github: https://github.com/JeremyRio/StimaTucil1

Tugas Kecil 1 IF2211 Strategi Algoritma
Penyelesaian Word Search Puzzle dengan Algoritma Brute Force

##Daftar Isi
1. Deskripsi
2. Requirements
3. Penggunaan
4. Penulis

##Deskripsi
Membuat program untuk menemukan semua kata di dalam word search puzzle menggunakan algoritma Brute Force

##Requirements
Windows (Reccomended)
Java
Java Development Kit (JDK)

##Penggunaan
[PENTING]
Program hanya dapat dijalankan dalam sistem operasi Windows. 
Sebagian besar console Windows 10 tidak menyalakan dukungan ANSI escape untuk pewarnaan tulisan dalam terminal. 
Agar terminal Windows 10 dapat mendukung pewarnaan tulisan, pengguna harus mengikut langkah berikut:

1. Buka Registry Editor (Bisa melalui Windows StartMenu atau menekan Win + R lalu menulis regedit)
2. Atur path menjadi Computer\HKEY_CURRENT_USER\Console lalu klik kanan area putih kemudian New > DWORD (32-bit) Value
3. Ganti nama variabel yang baru dibuat menjadi VirtualTerminalLevel
4. Klik kanan VirtualTerminalLevel lalu pilih Modify, kemudian isi Value data menjadi 1

A. Melalui Batch File / run.bat (Windows)
run.bat akan melakukan kompilasi program secara otomatis melalui Command Prompt.
Jalankan run.bat pada folder bin untuk memulai program Word Search Puzzle

B. Melalui Command Prompt/Powershell (Windows)
1. Atur path folder menjadi Tucil1_13520082/bin
2. Jalankan perintah berikut untuk memulai program Word Search Puzzle:
javac -d ../bin ../src/Puzzle.java
java -cp ../bin Puzzle

##Langkah Penggunaan Program
1.Jika ingin menambahkan studi kasus, masukkan studi kasus dalam folder test dengan ekstensi .txt. Contohnya small1.txt
2.Jalankan program melalui cara A atau cara B yang telah disinggung sebelumnya
3.Masukkan nama file tanpa mencantumkan ekstensi .txt
4.Selamat melihat program menyelesaikan Word Search Puzzle :)

Penulis
Nama: Jeremy Rionaldo Pasaribu
NIM: 13520082