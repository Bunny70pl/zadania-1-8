import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        for (int i = 10; i <100 ; i++) {
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
        String slowo = wpiszStringZKlawiatury();
        boolean palindrom = palindrom(slowo);
        if(palindrom){
            System.out.println("tak jest palindronem");
        }else{
            System.out.println("Nie jest palindronem");
        }
        Integer liczba = wpiszLiczbeZKlawiatury();
        Integer liczbaNajblizszaPalindroma = najblizszaDoPalindroma(liczba);
        System.out.println(liczbaNajblizszaPalindroma);
        slowo = wpiszStringZKlawiatury();
        String cezar = Cezar(slowo,3);
        System.out.println(cezar);
    }
    private static String wpiszStringZKlawiatury(){
        System.out.println("Podaj słowo: ");
        Scanner Klawiatura = new Scanner(System.in);
            String slowo = Klawiatura.nextLine();
        return slowo;
    }
    private static Integer wpiszLiczbeZKlawiatury(){
        System.out.println("Podaj Liczbe: ");
        Scanner Klawiatura = new Scanner(System.in);
        Integer liczba = Klawiatura.nextInt();
        return liczba;
    }
    private static boolean palindrom(String slowo){
        boolean palindrom = true;
        for (int i = 0,j = slowo.length()-1; i < j; i++,j--) {
            if(slowo.charAt(i) != slowo.charAt(j)){
                palindrom = false;
                return palindrom;
            }
        }
        return palindrom;
    }
    private static Integer najblizszaDoPalindroma(Integer liczba){
        int mniejsza = liczba -1;
        int wieksza = liczba +1;
        if(palindrom(Integer.toString(liczba))){
            return liczba;
        }
        while(true){
            if(palindrom(Integer.toString(mniejsza))){
                return mniejsza;
            }
            if(palindrom(Integer.toString(wieksza))){
                return wieksza;
            }
            mniejsza--;
            wieksza++;
        }
    }
    private static String Cezar(String slowo,int klucz){
        StringBuilder zaszyfrowane = new StringBuilder();
        for (int i = 0; i < slowo.length(); i++) {
            char znak = slowo.charAt(i);
            char base = Character.isUpperCase(znak) ? 'A':'a';
            char znakPrzesuniety = (char)((znak - base + klucz) % 26 + base);
            zaszyfrowane.append(znakPrzesuniety);
        }

        return zaszyfrowane.toString();
    }
}
