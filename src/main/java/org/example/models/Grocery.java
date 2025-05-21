package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {

    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Grocery List Uygulamasına Hoşgeldiniz!");
        System.out.println("0 - Çıkış\n1 - Eleman Ekle\n2 - Eleman Çıkar");

        while (true) {
            System.out.print("\nSeçiminiz (0, 1, 2): ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "0":
                    System.out.println("Uygulama sonlandırılıyor. Görüşmek üzere!");
                    return;
                case "1":
                    System.out.print("Eklemek istediğiniz eleman(lar)ı giriniz (örnek: tomato veya tomato, orange, peach): ");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    break;
                case "2":
                    System.out.print("Çıkarmak istediğiniz eleman(lar)ı giriniz (örnek: tomato veya tomato, orange, peach): ");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    break;
                default:
                    System.out.println("Geçersiz giriş! Lütfen sadece 0, 1 veya 2 giriniz.");
            }

            printSorted(); // Her işlem sonrası listeyi sırala ve yazdır
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (!trimmedItem.isEmpty() && !checkItemIsInList(trimmedItem)) {
                groceryList.add(trimmedItem);
            } else if (checkItemIsInList(trimmedItem)) {
                System.out.println("'" + trimmedItem + "' zaten listede mevcut.");
            }
        }
       Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (checkItemIsInList(trimmedItem)) {
                groceryList.remove(trimmedItem);
            } else {
                System.out.println("'" + trimmedItem + "' listede bulunamadı.");
            }
        }
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("📦 Güncel Sıralı Liste: " + groceryList);
    }
}
