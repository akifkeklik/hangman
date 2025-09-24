import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] words = {"java", "programlama", "bilgisayar", "insan", "kitap"};
        String wordToGuess = words[random.nextInt(words.length)];
        // 0-4 arasında (indisleri, sırası) rastgele seçim yapar. Böylece her çalıştırdğımızda rastgele kelime basar.


        boolean[] guessedLetters = new boolean[wordToGuess.length()];
        // tahmin edilecek kelimenin uzunluğunda bir tahmin edilen harfler listesi oluşturduk ve harfleri burda tuttuk.

        int remainingGuess = 6;
        // kalan tahmin: 6 ( Varsayılan hatalı tahmin hakkı.)

        boolean isFound;
        boolean isComplete;


        System.out.println("Adam Asmaca oyununa hoş geldiniz!");
        System.out.println("Bu bölümde aranan kelime: '" + wordToGuess+ "'");
        System.out.println("6 tane hatalı tahmin hakkımız var !");
        System.out.println("Kelimeyi tahmin etmek için harf girişi yapın.");


        while (remainingGuess > 0) {
            System.out.println();
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (guessedLetters[i]) {
                    System.out.print(wordToGuess.charAt(i) + " ");
                } else {
                    System.out.print("_ ");
                }
                // tahmin edilen true ise yani doğru ise ekrana bas ve yanına boşluk ekle , doğru değilse ekrana _ basar.
            }

            System.out.println("Kalan hatalı tahmin hakkınız: " + remainingGuess);
            System.out.println("Harf Giriniz: ");
            char guess = scanner.next().charAt(0);
            // Kullanıcının tahmin için denediği harfi guess nesnesine atadık.


            isFound = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedLetters[i] = true;
                    isFound = true;
                }
            }

            if (isFound) {
                System.out.println("Harf doğru tahmin edildi!");
            } else {
                remainingGuess--;
                System.out.println("Harf doğru değil, 1 hakkınız daha gitti , kalan hata hakkınız " + remainingGuess);
            }

            isComplete = true;
            for (boolean letter : guessedLetters) {
                if (!letter) {
                    isComplete = false;
                    break;
                }
            }

            if (isComplete) {
                System.out.println("Tebrikler! Kelimeyi doğru tahmin ettiniz : '" + wordToGuess +"'");
                break;
            }
        }

        if (remainingGuess == 0) {
            System.out.println("Tahmin hakkınız bitti, Adam asıldı! ");
            System.out.println("Doğru kelime: '" + wordToGuess + "' dı.");
        }


    }
}
