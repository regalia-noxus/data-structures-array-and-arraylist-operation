import java.util.Arrays;

public class ArrayOperations {

    // Traversal: Menampilkan seluruh isi array
    public static void traversal(int[] arr) {
        System.out.println(Arrays.toString(arr)); //pakai Arrays.toString() agar elemen di dalamnya dicetak rapi dalam tanda kurung siku
    }

    // Linear Search: Mencari elemen secara berurutan satu per satu
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) { // K cek satu-satu pakai loop dari nomor 0 sampai ujung. jjka ketemu, langsung return index-nya (break/keluar)
            if (arr[i] == target) {
                return i; // Kembalikan indeks jika ditemukan
            }
        }
        return -1; // Kembalikan -1 jika tidak ditemukan alasannya karena di Java index array itu tidak pernah bernilai negatif
    }

    // Binary Search: Mencari elemen pada array terurut dengan membagi 2
    public static int binarySearch(int[] arr, int target) {
        int kiri = 0; // binary Search bisa berjalan jika datanya sudah TERURUT (sorted).
        int kanan = arr.length - 1;

        while (kiri <= kanan) {
            int tengah = (kiri + kanan) / 2;

            if (arr[tengah] == target) { // Kalau hoki pas di tengah, langsung kelar
                return tengah;
            } else if (arr[tengah] < target) { // kalau target lebih besar dari nilai tengah, buang separuh bagian kiri
                kiri = tengah + 1;
            } else {
                kanan = tengah - 1; // sebaliknya, kalau target lebih kecil, buang separuh bagian kanan
            }
        }
        return -1; //jika tidak ketemu di seluruh rentang pencarian
    }

    // Penyisipan: Menambah elemen pada indeks tertentu menggunakan System.arraycopy
    public static int[] insert(int[] arr, int elemenBaru, int targetIndex) {
        // Buat array baru dengan ukuran + 1 karena array Java bersifat statis contohnya iika sebelumnya 5 elemen, sekarang menjadi 6.
        int[] hasil = new int[arr.length + 1];

        // Salin elemen sebelum indeks yang dituju
        System.arraycopy(arr, 0, hasil, 0, targetIndex);

        // Masukkan elemen baru pada indeks yang diinginkan
        hasil[targetIndex] = elemenBaru;
 
        // Salin sisa elemen dari array lama ke posisi setelah elemen baru. Posisi tujuan digeser satu indeks ke kanan
        System.arraycopy(arr, targetIndex, hasil, targetIndex + 1, arr.length - targetIndex);
        
        return hasil; // Mengembalikan array baru hasil penyisipan
    }

    // Penghapusan: Menghapus elemen pada indeks tertentu
    public static int[] delete(int[] arr, int targetIndex) {
        // Buat array baru dengan ukuran - 1 atau dengan panjang berkurang satu
        int[] hasil = new int[arr.length - 1];

        // Salin elemen sebelum indeks yang dihapus 
        System.arraycopy(arr, 0, hasil, 0, targetIndex);

        // Salin elemen setelah indeks yang dihapus, elemen-elemen tersebut bergeser satu posisi ke kiri
        System.arraycopy(arr, targetIndex + 1, hasil, targetIndex, arr.length - targetIndex - 1);

        return hasil; // mengembalikan array baru tanpa elemen yang dihapus.
    }
}