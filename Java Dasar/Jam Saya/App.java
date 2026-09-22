import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextLine()) {
            return;
        }

        String jamAwalInput = sc.nextLine().trim();

        String[] bagianJam =
            jamAwalInput.split(":", -1);

        if (bagianJam.length != 2) {
            System.out.println("Jam tidak valid");
            return;
        }

        int jam;
        int menit;

        try {
            jam = Integer.parseInt(
                bagianJam[0].trim()
            );

            menit = Integer.parseInt(
                bagianJam[1].trim()
            );
        } catch (NumberFormatException e) {
            System.out.println("Jam tidak valid");
            return;
        }

        if (jam < 0 || jam > 23 ||
            menit < 0 || menit > 59) {

            System.out.println("Jam tidak valid");
            return;
        }

        int totalMenit = jam * 60 + menit;

        int perpindahanHari = 0;
        int totalGeser = 0;

        while (sc.hasNextLine()) {
            String perintah =
                sc.nextLine().trim();

            if (perintah.equals("---")) {
                break;
            }

            if (perintah.length() < 2 ||
                (perintah.charAt(0) != '+' &&
                 perintah.charAt(0) != '-')) {

                System.out.println(
                    "Perintah tidak valid"
                );
                continue;
            }

            int geser;

            try {
                geser = Integer.parseInt(
                    perintah.substring(1)
                );
            } catch (NumberFormatException e) {
                System.out.println(
                    "Perintah tidak valid"
                );
                continue;
            }

            if (perintah.charAt(0) == '-') {
                geser = -geser;
            }

            totalGeser += geser;

            int hariSebelum =
                Math.floorDiv(totalMenit, 1440);

            int totalBaru =
                totalMenit + geser;

            int hariSesudah =
                Math.floorDiv(totalBaru, 1440);

            perpindahanHari +=
                Math.abs(hariSesudah - hariSebelum);

            totalMenit =
                Math.floorMod(totalBaru, 1440);
        }

        int jamAkhir = totalMenit / 60;
        int menitAkhir = totalMenit % 60;

        System.out.printf(
            "Jam Awal: %02d:%02d%n",
            jam,
            menit
        );

        System.out.printf(
            "Jam Akhir: %02d:%02d%n",
            jamAkhir,
            menitAkhir
        );

        if (totalGeser > 0) {
            System.out.println(
                "Total Menit: +" + totalGeser
            );
        } else {
            System.out.println(
                "Total Menit: " + totalGeser
            );
        }

        System.out.println(
            "Pergantian Hari: " +
            perpindahanHari
        );
    }
}