package com.youssef.warehouse;
import java.util.ArrayList;
import java.util.Comparator; 

public class Sorter {

    // "static" means we call this without creating a Sorter object: Sorter.bubbleSortByPrice(list).
    // It sorts the given list in place, from cheapest to most expensive.

public static void bubbleSortByPrice(ArrayList<Product> list){
    int n = list.size();

    for (int pass = 0; pass < n - 1; pass++) {
        
        boolean swapped = false;

        for (int i = 0; i < n - 1 - pass; i++) {

            Product left = list.get(i);
            Product right = list.get(i + 1);

            if (left.getPriceInCents() > right.getPriceInCents()){

                list.set(i, right);
                list.set(i +1, left); // set(position, element) replaces what is at that position
                swapped = true;
            }
        }

    if (!swapped) {
                break;}
        }
    }

public static void bubbleSort(ArrayList<Product> list, Comparator<Product> comparator){

    int n = list.size();

    for(int pass = 0 ; pass < n - 1 ; pass++){

        boolean swapped = false;
        
        for (int i = 0 ; i < n - 1 - pass ; i++){
            Product left = list.get(i);
            Product right = list.get(i + 1);

            if (comparator.compare(left, right) > 0){
                list.set(i, right);
                list.set(i+1, left);
                swapped = true;

            }
        }
        if(!swapped){
            break;
        }
    }
}
    
}
