# Tugas Pemrograman 5 - Shyour Box
CSGE601021 Dasar-Dasar Pemrograman 2 @ Fakultas Ilmu Komputer Universitas Indonesia,
Semester Pendek – 2022/2023

## Dokumen Soal
Dokumen soal dapat diakses melalui [link ini](https://docs.google.com/document/d/1iT1dp2ssZWuaDLW-p6cTqaduTepxe9dm_BwtVcKTFgw/edit).


## Panduan Memulai
1. Tambahkan ***remote*** baru pada **repository anda** bernama **`upstream`** untuk mendapatkan code dari repository DDP2 dengan perintah:
    ```bash
    git remote add upstream https://gitlab.com/DDP2-CSUI/sp-ddp2-2023/template-tp5-sp-ddp2.git
    ```
    Jika sebelumnya anda telah menambahkan **`upstream`**, Anda dapat mengganti url **`upstream`** ke DDP2 dengan perintah:
    ```bash
    git remote set-url upstream https://gitlab.com/DDP2-CSUI/sp-ddp2-2023/template-tp5-sp-ddp2.git
    ```
    > Note: Sekarang, pada git anda terdapat 2 source remote, yakni: **`origin`**, repository milik anda dan **`upstream`**, repository DDP2 tempat soal dan template Tugas Pemrograman 3 berada.
2. Buat direktori baru pada folder TP3 anda kemudian pindahkan terminal ke ***path*** tersebut.
3. Lakukan ***pull*** dari remote **`upstream`** dengan perintah 
    ```bash
    git pull upstream main
    ```

## Deskripsi
Kiprah burhan sebagai programmer ganteng idaman yang sudah kondang di Ibukota. Setelah dua minggu berturut-turut menyelesaikan proyek dari HaloDDP dan Perusahaan XYZ, kini salah satu toko tempat berbelanja favorit karyawan perusahaan XYZ, yakni ShyourBox meminta bantuan Om Burhan untuk membangun sistem administrasi kasir mereka. ShyourBox menjual berbagai jenis buah dan sayur dengan kualitas premium namun hanya eksklusif pada member mereka, sesuai dengan motto mereka yaitu YMMA (Yang Mau Mau Aja & Yang Member Member Aja). Member ShyourBox terbagi menjadi dua yaitu premium dan reguler. Member premium mendapatkan benefit berupa potongan sebesar 10% untuk perbelanjaan minimal Rp300.000,00. 


## Menyelesaikan konflik

Jika terjadi *merge conflict*, silakan selesaikan konflik yang ada dan
lanjutkan proses *merging*. Kamu bisa mencari [panduan](https://githowto.com/resolving_conflicts) atau meminta bantuan asdos jika mengalami kesulitan.
