import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Integer> frekuensi =
            new LinkedHashMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.equals("---")) {
                break;
            }

            if (line.isEmpty()) {
                continue;
            }

            try {
                int nilai = Integer.parseInt(line);

                frekuensi.put(
                    nilai,
                    frekuensi.getOrDefault(nilai, 0) + 1
                );
            } catch (NumberFormatException e) {
                // Baris yang bukan bilangan diabaikan
            }
        }

        // Tidak ada data
        if (frekuensi.isEmpty()) {
            return;
        }

        int tertinggi = Integer.MIN_VALUE;
        int terendah = Integer.MAX_VALUE;

        int terbanyak = 0;
        int tersedikit = 0;

        int maxFreq = -1;
        int minFreq = Integer.MAX_VALUE;

        int jumlahTertinggi = 0;
        int jumlahTerendah = 0;

        long maxJumlah = Long.MIN_VALUE;
        long minJumlah = Long.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry :
                frekuensi.entrySet()) {

            int nilai = entry.getKey();
            int freq = entry.getValue();

            long jumlah = (long) nilai * freq;

            // Tertinggi
            if (nilai > tertinggi) {
                tertinggi = nilai;
            }

            // Terendah
            if (nilai < terendah) {
                terendah = nilai;
            }

            // Terbanyak
            if (freq > maxFreq ||
                (freq == maxFreq && nilai > terbanyak)) {

                maxFreq = freq;
                terbanyak = nilai;
            }

            // Tersedikit
            if (freq < minFreq ||
                (freq == minFreq && nilai < tersedikit)) {

                minFreq = freq;
                tersedikit = nilai;
            }

            // Jumlah Tertinggi
            if (jumlah > maxJumlah ||
                (jumlah == maxJumlah &&
                 nilai > jumlahTertinggi)) {

                maxJumlah = jumlah;
                jumlahTertinggi = nilai;
            }

            // Jumlah Terendah
            if (jumlah < minJumlah ||
                (jumlah == minJumlah &&
                 nilai < jumlahTerendah)) {

                minJumlah = jumlah;
                jumlahTerendah = nilai;
            }
        }

        System.out.println("Tertinggi: " + tertinggi);
        System.out.println("Terendah: " + terendah);

        System.out.println(
            "Terbanyak: " + terbanyak +
            " (" + frekuensi.get(terbanyak) + "x)"
        );

        System.out.println(
            "Tersedikit: " + tersedikit +
            " (" + frekuensi.get(tersedikit) + "x)"
        );

        System.out.println(
            "Jumlah Tertinggi: " +
            jumlahTertinggi + " * " +
            frekuensi.get(jumlahTertinggi) +
            " = " + maxJumlah
        );

        System.out.println(
            "Jumlah Terendah: " +
            jumlahTerendah + " * " +
            frekuensi.get(jumlahTerendah) +
            " = " + minJumlah
        );
    }
}