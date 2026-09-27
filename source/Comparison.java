import java.util.ArrayList; // Mengimpor class ArrayList
import java.util.Arrays; // Mengimpor Arrays agar dapat menggunakan Arrays.asList()

public class Comparison {

    public static void main(String[] args) { // main() titik awal eksekusi program Java
        // ==========================================================
        // Output Program
        // ==========================================================
        
        // Inisialisasi data awal embuat Array dengan lima elemen bertipe int
        int[] array = {10, 20, 30, 40, 50};
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50)); // membuat ArrayList dengan data awal yang sama

        // 1. Traversal
        System.out.print("Array Traversal: "); 
        ArrayOperations.traversal(array); // fungsinya memanggil metode traversal milik ArrayOperations
        System.out.print("ArrayList Traversal: ");
        ArrayListOperations.traversal(arrayList);//fungsinya emanggil metode traversal milik ArrayListOperations.
        System.out.println(); // memberi satu baris kosong pada output.

        // 2. Pencarian elemen 30 & pengukuran waktu
        long startWaktuArr = System.nanoTime(); // fungsinya mencatat waktu tepat sebelum pencarian pada Array
        int indexArray = ArrayOperations.linearSearch(array, 30); // mencari angka 30 menggunakan Linear Search kemudian hasil pencariannya disimpan pada variabel indexArray
        long endWaktuArr = System.nanoTime(); // mencatat waktu setelah pencarian selesai
        double waktuCariArray = (endWaktuArr - startWaktuArr) / 1_000_000.0; // fungsinya menghitung selisih waktu awal dan akhir. Dibagi dengan 1.000.000 untuk mengubah nanodetik ke milidetik.

        long startWaktuList = System.nanoTime();  // Mencatat waktu sebelum pencarian pada ArrayList.
        int indexList = ArrayListOperations.search(arrayList, 30); // fungsinya mencari angka 30 menggunakan metode indexOf().
        long endWaktuList = System.nanoTime(); // Mencatat waktu setelah pencarian selesai.
        double waktuCariList = (endWaktuList - startWaktuList) / 1_000_000.0; // fungsinya menghitung durasi pencarian ArrayList dalam milidetik.

        // menampilkan posisi elemen yang ditemukan
        System.out.println("Pencarian 30 dalam Array: Ditemukan di indeks " + indexArray);
        System.out.println("Pencarian 30 dalam ArrayList: Ditemukan di indeks " + indexList);
        System.out.println();

        // 3. Penyisipan elemen 25 pada indeks ke-2
        array = ArrayOperations.insert(array, 25, 2); // fungsinya menyisipkan angka 25 pada indeks 2 lalu hasilnya disimpan kembali karena insert() dan mengembalikan Array baru
        ArrayListOperations.insertElement(arrayList, 2, 25); // fungsinya menyisipkan angka 25 pada indeks 2 ArrayList dan pada ArrayList yang sama langsung dimodifikasi

         // Menampilkan hasil penyisipan Array
        System.out.print("Array setelah penyisipan elemen 25: ");
        ArrayOperations.traversal(array);
        // Menampilkan hasil penyisipan ArrayList
        System.out.print("ArrayList setelah penyisipan elemen 25: ");
        ArrayListOperations.traversal(arrayList);

        System.out.println();

        // 4. Menampilkan waktu eksekusi pencarian
        System.out.printf("Waktu eksekusi pencarian pada Array: %.4f ms\n", waktuCariArray); // fungsi %.4f berarti angka ditampilkan dengan empat digit setelah tanda desimal
        System.out.printf("Waktu eksekusi pencarian pada ArrayList: %.4f ms\n", waktuCariList);
        System.out.println();

        // Pengujian 1000 elemen dilanjutkan di bawah

        // ==========================================================
        // PENGUJIAN DENGAN DATA UJI 1000 ELEMEN (TABEL) pengujian dengan coba uji 1000 elemen tabel
        // ==========================================================
        System.out.println("=========================================================================");
        System.out.println("      TABEL PERBANDINGAN WAKTU EKSEKUSI (DATA UJI = 1000 ELEMEN)         ");
        System.out.println("=========================================================================");

        int jumlahData = 1000; // menentukan jumlah elemen yang akan diuji
        int[] dataArray = new int[jumlahData]; // menyiapkan Array yang memiliki kapasitas 1.000 elemen
        ArrayList<Integer> dataList = new ArrayList<>(); // membuat ArrayList kosong

        // Isi data dari 1 sampai 1000
        for (int i = 0; i < jumlahData; i++) {
            dataArray[i] = i + 1; // Array diisi mulai dari indeks 0 dengan nilai 1
            dataList.add(i + 1); // ArrayList diisi dengan nilai yang sama
        }

        // menentukan angka yang akan dicari
        // lalu dipilih angka 950 yang berada mendekati akhir data
        int nilaiDicari = 950;  // Elemen mendekati akhir
        int indexUji = 500;     // Operasi di tengah
        int nilaiBaru = 9999; // menentukan nilai baru yang akan disisipkan

        // 1. Pengujian Pencarian
        long t1 = System.nanoTime(); // mencatat waktu sebelum pencarian pada Array
        ArrayOperations.linearSearch(dataArray, nilaiDicari); // mencari angka 950 menggunakan Linear Search
        double waktuSearchArr = (System.nanoTime() - t1) / 1_000_000.0;  // menghitung durasi pencarian pada Array.

        long t2 = System.nanoTime(); // mencatat waktu sebelum pencarian ArrayList
        ArrayListOperations.search(dataList, nilaiDicari); // mencari angka 950 menggunakan indexOf()
        double waktuSearchList = (System.nanoTime() - t2) / 1_000_000.0; // menghitung durasi pencarian pada ArrayList

        // 2. Pengujian Penyisipan di Tengah
        long t3 = System.nanoTime(); // mencatat waktu sebelum penyisipan pada Array
        int[] arrSetelahSisip = ArrayOperations.insert(dataArray, nilaiBaru, indexUji); // fungsinya menyisipkan nilai 9999 pada indeks 500 lalu hasil penyisipan disimpan pada Array baru
        double waktuInsertArr = (System.nanoTime() - t3) / 1_000_000.0;

        long t4 = System.nanoTime();
        ArrayListOperations.insertElement(dataList, indexUji, nilaiBaru); // fungsinya menyisipkan nilai 9999 pada indeks 500 ArrayList
        double waktuInsertList = (System.nanoTime() - t4) / 1_000_000.0;

        // 3. Pengujian Penghapusan di Tengah
        long t5 = System.nanoTime();
        ArrayOperations.delete(arrSetelahSisip, indexUji); // fungsinya menghapus elemen pada indeks 500 dari Array yang sebelumnya sudah disisipkan nilai 9999
        double waktuDeleteArr = (System.nanoTime() - t5) / 1_000_000.0;

        long t6 = System.nanoTime();
        ArrayListOperations.deleteElement(dataList, indexUji);
        double waktuDeleteList = (System.nanoTime() - t6) / 1_000_000.0;

        // Tampilkan Tabel

        // Menampilkan nama ketiga kolom tabel
        // Angka setelah tanda minus menunjukkan lebar kolom
        System.out.printf("%-25s | %-16s | %-16s\n", "Operasi Dasar", "Waktu Array (ms)", "Waktu ArrayList (ms)");
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("%-25s | %16.5f | %20.5f\n", "Linear Search", waktuSearchArr, waktuSearchList);
        System.out.printf("%-25s | %16.5f | %20.5f\n", "Insertion (Index 500)", waktuInsertArr, waktuInsertList);
        System.out.printf("%-25s | %16.5f | %20.5f\n", "Deletion (Index 500)", waktuDeleteArr, waktuDeleteList);
        System.out.println("-------------------------------------------------------------------------");
    }
}