import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       for (int i = 10; i <100 ; i++) {
           if(i % 2 == 0){
               System.out.println(i);
           }
       }
       System.out.println("Podaj slowo do sprawdzenia czy jest palindromem");
       String slowo = wpiszStringZKlawiatury();
       boolean palindrom = palindrom(slowo);
       if(palindrom){
           System.out.println("tak jest palindronem");
       }else{
           System.out.println("Nie jest palindronem");
       }
       System.out.println("Podaj liczbe do ktorej zostanie podana najblizsza liczba palindromowa");
       Integer liczba = wpiszLiczbeZKlawiatury();
       Integer liczbaNajblizszaPalindroma = najblizszaDoPalindroma(liczba);
       System.out.println(liczbaNajblizszaPalindroma);
       System.out.println("Podaj slowo do zaszyfrowania szyfrem cezara");
       slowo = wpiszStringZKlawiatury();
       String cezar = Cezar(slowo,3);
       System.out.println(cezar);
       System.out.println("Wpisz slowo");
       ArrayList listaSlowo1 = new ArrayList<Character>();;
       listaSlowo1 = wpiszDoTablicy();
       System.out.println("Wpisz drugie slowo");
       ArrayList listaSlowo2 = new ArrayList<Character>();
       listaSlowo2 = wpiszDoTablicy();
       System.out.println(czyAnagram(listaSlowo1,listaSlowo2));
       System.out.println("Podaj liczbe do silni (n!)");
       liczba = wpiszLiczbeZKlawiatury();
       System.out.println("Silnia wynosi: " + silniaZPodanejLiczby(liczba));
       System.out.println("Podaj liczbe do sprwadzenia czy jest liczba pierwsza");

       liczba = wpiszLiczbeZKlawiatury();
       System.out.println(czyLiczbaPierwsza(liczba));

       System.out.println("Twoje haslo: "+ generujHaslo());

       System.out.println("Tablica z pierwiastakami indeksow" +tablicaZPierwiastakimiZindeksow());
       System.out.println("Tablica z ciagiem fiobnaciego" + tablicaZCiagaiemFibonaciego());
       ArrayList<Integer> TablicaZCiagiemFibo = tablicaZCiagaiemFibonaciego();
       System.out.println("Podaj liczbe do wyszukania: ");
       liczba = wpiszLiczbeZKlawiatury();
       System.out.println(znajdzNajblizszaLiczbe(TablicaZCiagiemFibo,liczba));

        ArrayList<Integer> wylsowane = new ArrayList<>();
        ArrayList<Integer> parzyste = new ArrayList<>();
        ArrayList<Integer> nieParzyste = new ArrayList<>();
        HashSet<Integer> unikatowe = new HashSet<>();
        wylosujLiczby(wylsowane,parzyste,nieParzyste,unikatowe);
        System.out.println("Wylosowane: " + wylsowane);
        System.out.println("Parzyste: " + parzyste);
        System.out.println("Nie parzyste: " + nieParzyste);
        System.out.println("Unikatowe: " + unikatowe);

        Collections.sort(wylsowane);
        System.out.println(wylsowane);
        System.out.println("Mediana: " + mediana(wylsowane));
        System.out.println("Dominanta: " + dominanta(wylsowane));
        System.out.println("Srednia: " + srednia(wylsowane));

        int x = wpiszLiczbeZKlawiatury();
        int y = wpiszLiczbeZKlawiatury();
        List<Integer> liczbyPierwsze = generujLiczbyPierwsze(1000);
        System.out.println(znajdzLiczbyPierwszeWZakresie(liczbyPierwsze,x,y));
    }
    private static String wpiszStringZKlawiatury(){
        Scanner Klawiatura = new Scanner(System.in);
            String slowo = Klawiatura.nextLine();
        return slowo;
    }
    private static ArrayList wpiszDoTablicy(){
        Scanner Klawiatura = new Scanner(System.in);
        String slowo = Klawiatura.nextLine();
        ArrayList slowoLista = new ArrayList<Character>();
        for (int i = 0; i < slowo.length(); i++) {
            slowoLista.add(slowo.charAt(i));
        }
        return slowoLista;
    }
    private static Integer wpiszLiczbeZKlawiatury(){
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
    private static String czyAnagram(ArrayList<Character> listaSlowo1, ArrayList<Character> listaSlowo2){
        Collections.sort(listaSlowo1);
        Collections.sort(listaSlowo2);
        String anagram = "";
        if(listaSlowo1.size()!=listaSlowo2.size()){
            anagram = "Słowa nie są tej samej długości w takim razie nie sa anagramem";
            return anagram;
        } else{
            for (int i = 0; i < listaSlowo1.size(); i++) {
                if(!listaSlowo1.get(i).equals(listaSlowo2.get(i))){
                    anagram = "Słowa nie sa anagramami";
                    return anagram;
                }
            }
            anagram = "Podane słowa sa anagrmami";
        }
        return anagram;
    }
    private static Integer silniaZPodanejLiczby(Integer liczba){
        int silnia = 1;
        for (int i = liczba; i >= 1; i--) {
            silnia *= i;
        }
        return silnia;
    }
    private static String czyLiczbaPierwsza(Integer liczba){
        String komunikatTakCzyNie ="Tak to jest liczba pierwsza";
        for (int i = liczba - 1; i >=2; i--) {
            if(liczba % i == 0){
                komunikatTakCzyNie = "Ta liczba nie jest liczba pierwsza";
                return komunikatTakCzyNie;
            }
        }
        return komunikatTakCzyNie;
    }
    private static String generujHaslo(){
        String haslo ="";
        String litery = "abcdefghijklmnopqrstwxyz";//26
        String liczby = "1234567890";//10
        String znakiSpecjlane = "~!@#$%^&*()-_=+[]{}|;:',./<>?";//31
        int liczba = (int)(Math.random()*3+1);
        while(haslo.length()<20){
            liczba = (int)(Math.random()*3+1);
            if(liczba == 1){
               liczba = (int)(Math.random()*litery.length());
               haslo += litery.charAt(liczba);
            } else if (liczba == 2) {
                liczba = (int)(Math.random()*liczby.length());
                haslo +=  liczby.charAt(liczba);
            }else {
                liczba = (int)(Math.random()*znakiSpecjlane.length());
                haslo +=  znakiSpecjlane.charAt(liczba);
            }
        }
        return haslo;
    }
    private static ArrayList tablicaZPierwiastakimiZindeksow(){
        ArrayList<Double> tablicaZpierwiastkami = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tablicaZpierwiastkami.add((Double) (Math.sqrt(i)));
        }
        return tablicaZpierwiastkami;
    }
    private static ArrayList tablicaZCiagaiemFibonaciego(){
        ArrayList<Integer> TablicaZCiagiemFibo = new ArrayList<>();
        TablicaZCiagiemFibo.add(0);
        TablicaZCiagiemFibo.add(1);
        for (int i = 2; i < 40; i++) {
            int size = TablicaZCiagiemFibo.size();
            int nastepnaLiczba = TablicaZCiagiemFibo.get(size - 1) + TablicaZCiagiemFibo.get(size - 2);
            TablicaZCiagiemFibo.add(nastepnaLiczba);
        }
        return TablicaZCiagiemFibo;
    }
    private static int znajdzNajblizszaLiczbe(ArrayList<Integer> tablica, int liczba) {
        int lewa = 0;
        int prawa = tablica.size() - 1;
        int srodek;
        int najblizsza = tablica.get(0);
        while (lewa <= prawa) {
            srodek = (lewa + prawa) / 2;
            if (tablica.get(srodek) == liczba) {
                return tablica.get(srodek);
            } else if (tablica.get(srodek) < liczba) {
                lewa = srodek + 1;
            } else {
                prawa = srodek - 1;
            }
        }
        if (prawa >= 0 && lewa < tablica.size()) {
            int roznicaLewej = Math.abs(tablica.get(lewa) - liczba);
            int roznicaPrawej = Math.abs(tablica.get(prawa) - liczba);

            if (roznicaLewej < roznicaPrawej) {
                najblizsza = tablica.get(lewa);
            } else {
                najblizsza = tablica.get(prawa);
            }
        } else if (lewa < tablica.size()) {
            najblizsza = tablica.get(lewa);
        } else if (prawa >= 0) {
            najblizsza = tablica.get(prawa);
        }
        return najblizsza;
    }
    private static void wylosujLiczby(ArrayList<Integer> wylsowane,ArrayList<Integer> parzyste,ArrayList<Integer> nieParzyste,HashSet<Integer> unikatowe ){

        while(wylsowane.size()<10){
            int liczba = (int)(Math.random()*100+1);
            wylsowane.add(liczba);
        }
        for (int i = 0; i < wylsowane.size(); i++) {
            if(wylsowane.get(i) % 2 == 0){
                parzyste.add(wylsowane.get(i));
            }else{
                nieParzyste.add(wylsowane.get(i));
            }
            unikatowe.add(wylsowane.get(i));
        }
    }
    private static Double srednia(ArrayList<Integer> wylsowane){
         Collections.sort(wylsowane);
        double srednia = 0;
        for (int i = 0; i < wylsowane.size(); i++) {
            srednia+=wylsowane.get(i);
        }
        srednia = srednia/wylsowane.size();
        return srednia;
    }
    private static double mediana(ArrayList<Integer> wylsowane){
        Collections.sort(wylsowane);
        double mediana = 0;
        if(wylsowane.size()%2 == 0){
            double liczba1 = wylsowane.get(wylsowane.size()/2-1);
            double liczba2 = wylsowane.get(wylsowane.size()/2);
            mediana = (liczba2 + liczba1)/2;
        }else{
            mediana = wylsowane.get(wylsowane.size()/2);
        }
        return mediana;
    }
    private static Integer dominanta(ArrayList<Integer> wylsowane){
        Collections.sort(wylsowane);
        int dominanta = wylsowane.get(0);
        int maksymalnaLiczba = 0;
        for (int i = 0; i < wylsowane.size(); i++) {
            int obecnaLiczba = 0;
            for (int j = 0; j < wylsowane.size(); j++) {
                if (wylsowane.get(j) == wylsowane.get(i)) {
                    obecnaLiczba++;
                }
            }
            if (obecnaLiczba > maksymalnaLiczba) {
                maksymalnaLiczba = obecnaLiczba;
                dominanta = wylsowane.get(i);
            }
        }
        return dominanta;
    }
    private static List<Integer> generujLiczbyPierwsze(int n) {
        boolean[] sito = new boolean[n];
        for (int i = 2; i < n; i++) {
            sito[i] = true;
        }
        for (int i = 2; i * i < n; i++) {
            if (sito[i]) {
                for (int j = i * i; j < n; j += i) {
                    sito[j] = false;
                }
            }
        }
        List<Integer> liczbyPierwsze = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (sito[i]) {
                liczbyPierwsze.add(i);
            }
        }
        return liczbyPierwsze;
    }
    private static List<Integer> znajdzLiczbyPierwszeWZakresie(List<Integer> liczbyPierwsze, int x, int y) {
        List<Integer> listaLiczbPierwszych = new ArrayList<>();
        for (int liczba : liczbyPierwsze) {
            if (liczba >= x && liczba <= y) {
                listaLiczbPierwszych.add(liczba);
            }
        }
        return listaLiczbPierwszych;
    }
}
