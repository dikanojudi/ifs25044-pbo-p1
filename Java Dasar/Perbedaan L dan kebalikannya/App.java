import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] row = sc.nextLine().trim().split("\\s+");

            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }

        // Kasus 1x1
        if (n == 1) {
            int tengah = matrix[0][0];

            System.out.println("Nilai L: Tidak Ada");
            System.out.println("Nilai Kebalikan L: Tidak Ada");
            System.out.println("Nilai Tengah: " + tengah);
            System.out.println("Perbedaan: Tidak Ada");
            System.out.println("Dominan: " + tengah);

            return;
        }

        // Kasus 2x2
        if (n == 2) {
            int total = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    total += matrix[i][j];
                }
            }

            System.out.println("Nilai L: Tidak Ada");
            System.out.println("Nilai Kebalikan L: Tidak Ada");
            System.out.println("Nilai Tengah: " + total);
            System.out.println("Perbedaan: Tidak Ada");
            System.out.println("Dominan: " + total);

            return;
        }

        // Nilai L
        int nilaiL = 0;

        for (int i = 0; i < n; i++) {
            nilaiL += matrix[i][0];
        }

        for (int j = 1; j < n - 1; j++) {
            nilaiL += matrix[n - 1][j];
        }

        // Nilai Kebalikan L
        int kebalikanL = 0;

        for (int i = 0; i < n; i++) {
            kebalikanL += matrix[i][n - 1];
        }

        for (int j = 1; j < n - 1; j++) {
            kebalikanL += matrix[0][j];
        }

        // Nilai tengah
        int nilaiTengah;

        if (n % 2 == 1) {
            // N ganjil
            nilaiTengah = matrix[n / 2][n / 2];
        } else {
            // N genap: jumlah blok 2x2 di tengah
            int r = n / 2 - 1;
            int c = n / 2 - 1;

            nilaiTengah =
                matrix[r][c]
                + matrix[r][c + 1]
                + matrix[r + 1][c]
                + matrix[r + 1][c + 1];
        }

        int perbedaan = Math.abs(nilaiL - kebalikanL);

        int dominan;

        if (perbedaan == 0) {
            dominan = nilaiTengah;
        } else {
            dominan = Math.max(nilaiL, kebalikanL);
        }

        System.out.println("Nilai L: " + nilaiL);
        System.out.println("Nilai Kebalikan L: " + kebalikanL);
        System.out.println("Nilai Tengah: " + nilaiTengah);
        System.out.println("Perbedaan: " + perbedaan);
        System.out.println("Dominan: " + dominan);
    }
}