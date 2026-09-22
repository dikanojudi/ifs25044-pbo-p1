import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nim = sc.nextLine().trim();

        if (nim.length() != 8) {
            System.out.println("NIM harus 8 karakter");
            return;
        }

        String prefix = nim.substring(0, 3);
        String programStudi;

        switch (prefix) {
            case "11S":
                programStudi = "Sarjana Informatika";
                break;
            case "12S":
                programStudi = "Sarjana Sistem Informasi";
                break;
            case "13S":
                programStudi = "Sarjana Teknik Elektro";
                break;
            case "21S":
                programStudi = "Sarjana Manajemen Rekayasa";
                break;
            case "22S":
                programStudi = "Sarjana Teknik Metalurgi";
                break;
            case "31S":
                programStudi = "Sarjana Teknik Bioproses";
                break;
            case "32S":
                programStudi = "Sarjana Bioteknologi";
                break;
            case "114":
                programStudi = "Diploma 4 Teknologi Rekasaya Perangkat Lunak";
                break;
            case "113":
                programStudi = "Diploma 3 Teknologi Informasi";
                break;
            case "133":
                programStudi = "Diploma 3 Teknologi Komputer";
                break;
            default:
                System.out.println("Kode tidak tersedia");
                return;
        }

        int angkatan;
        int urutan;

        try {
            angkatan = Integer.parseInt("20" + nim.substring(3, 5));
            urutan = Integer.parseInt(nim.substring(5, 8));
        } catch (NumberFormatException e) {
            System.out.println("NIM harus 8 karakter");
            return;
        }

        System.out.println("Informasi NIM " + nim + ": ");
        System.out.println(">> Program Studi: " + programStudi);
        System.out.println(">> Angkatan: " + angkatan);
        System.out.println(">> Urutan: " + urutan);
    }
}