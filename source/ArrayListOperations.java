import java.util.ArrayList;
import java.util.Collections;

public class ArrayListOperations {

    // 1. Traversal: Menampilkan seluruh isi ArrayList
    public static void traversal(ArrayList<Integer> list) {
        System.out.println(list.toString()); // fungsinya mengubah seluruh elemen menjadi representasi String
    }

    // 2. Menambahkan elemen di akhir list
    public static void addElement(ArrayList<Integer> list, int elemen) {
        list.add(elemen); // fungsinya add() secara otomatis menambahkan elemen sekaligus memperbarui jumlah data di ArrayList.
    }

    // 3. Menyisipkan elemen pada indeks tertentu
    public static void insertElement(ArrayList<Integer> list, int targetIndex, int elemen) {
        list.add(targetIndex, elemen); // elemen baru disisipkan pada indeks target, lalu elemen pada indeks tersebut dan setelahnya akan bergeser satu posisi ke kanan
    }

    // 4. Menghapus elemen berdasarkan indeks
    public static void deleteElement(ArrayList<Integer> list, int targetIndex) {
        list.remove(targetIndex); // remove() menghapus elemen pada indeks target, lalu elemen setelahnya bergeser satu posisi ke kiri
    }

    // 5. Pencarian elemen (Linear Search via indexOf)
    public static int search(ArrayList<Integer> list, int target) {
        return list.indexOf(target); // fungsi indexOf() mencari nilai dan mengembalikan indeks kemunculan pertama. kalau tidak ditemukan, hasilnya adalah -1
    }

    // 6. Pengurutan data menggunakan Collections.sort()
    public static void sortList(ArrayList<Integer> list) {
        Collections.sort(list); // fungsi Collections.sort() mengurutkan angka secara ascending, dari terkecil ke terbesar
    }
}