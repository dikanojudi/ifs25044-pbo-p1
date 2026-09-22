import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] bobot = new int[6];

        for (int i = 0; i < 6; i++) {
            bobot[i] = Integer.parseInt(sc.nextLine().trim());
        }

        int totalBobot = 0;

        for (int nilai : bobot) {
            totalBobot += nilai;
        }

        if (totalBobot != 100) {
            System.out.println("Total bobot harus 100");
            return;
        }

        String[] simbol = {"PA", "T", "K", "P", "UTS", "UAS"};

        int[] total = new int[6];
        int[] perolehan = new int[6];

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.equals("---")) {
                break;
            }

            String[] data = line.split("\\|", -1);

            if (data.length != 3) {
                System.out.println(
                    "Data tidak valid. Silahkan menggunakan format: Simbol|Bobot|Perolehan-Nilai"
                );
                continue;
            }

            String kode = data[0].trim();

            int nilaiBobot;
            int nilaiPerolehan;

            try {
                nilaiBobot = Integer.parseInt(data[1].trim());
                nilaiPerolehan = Integer.parseInt(data[2].trim());
            } catch (NumberFormatException e) {
                System.out.println(
                    "Data tidak valid. Silahkan menggunakan format: Simbol|Bobot|Perolehan-Nilai"
                );
                continue;
            }

            int index = -1;

            for (int i = 0; i < simbol.length; i++) {
                if (simbol[i].equals(kode)) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                System.out.println("Simbol tidak dikenal");
                continue;
            }

            // Clamp nilai agar 0 <= perolehan <= bobot
            nilaiPerolehan = Math.min(nilaiPerolehan, nilaiBobot);
            nilaiPerolehan = Math.max(nilaiPerolehan, 0);

            total[index] += nilaiBobot;
            perolehan[index] += nilaiPerolehan;
        }

        double nilaiAkhir = 0.0;
int[] perolehan100 = new int[6];
double[] kontribusi = new double[6];

for (int i = 0; i < 6; i++) {

    if (total[i] == 0) {
        perolehan100[i] = 0;
    } else {
        perolehan100[i] =
            (perolehan[i] * 100) / total[i];
    }

    kontribusi[i] =
        (perolehan100[i] / 100.0) * bobot[i];

    nilaiAkhir += kontribusi[i];
}

        String grade;

        if (nilaiAkhir >= 79.5) {
            grade = "A";
        } else if (nilaiAkhir >= 72) {
            grade = "AB";
        } else if (nilaiAkhir >= 64.5) {
            grade = "B";
        } else if (nilaiAkhir >= 57) {
            grade = "BC";
        } else if (nilaiAkhir >= 49.5) {
            grade = "C";
        } else if (nilaiAkhir >= 34) {
            grade = "D";
        } else {
            grade = "E";
        }

        String[] namaKomponen = {
            "Partisipatif",
            "Tugas",
            "Kuis",
            "Proyek",
            "UTS",
            "UAS"
        };

        System.out.println("Perolehan Nilai:");

        for (int i = 0; i < 6; i++) {
            System.out.printf(
                ">> %s: %d/%d (%.2f/%d)%n",
                namaKomponen[i],
                perolehan100[i],
                kontribusi[i],
                bobot[i]
            );
        }

        System.out.println();

        System.out.printf(
            ">> Nilai Akhir: %.2f%n",
            nilaiAkhir
        );

        System.out.println(">> Grade: " + grade);
    }
}