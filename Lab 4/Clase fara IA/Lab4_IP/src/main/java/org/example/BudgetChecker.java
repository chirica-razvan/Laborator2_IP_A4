package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@NoArgsConstructor
public class BudgetChecker {
    private List <Map<Product, Integer>> products = new ArrayList<Map<Product,Integer>>();
    @Getter
    private int totalPrice;
    @Getter
    @Setter
    private int budget;

    BudgetChecker(int budget) {
        this.budget = budget;
    }

    public void addProduct(Product product,Integer price) {
        var existingProduct =  new HashMap<Product, Integer>();
        existingProduct.put(product, price);
            if (products.contains(existingProduct)) {
                System.out.println("Acest produs exista deja");
                return;
            }
            else {
                var catalogProduct = new HashMap<Product, Integer>();
                catalogProduct.put(product, price);
                products.add(catalogProduct);
                this.totalPrice +=price;
                System.out.println("Produsul "+product.getName()+" a fost adaugat cu succes!");
                if(!isInBudget(price)){
                    System.out.println("[AVERTISMENT] Costul total al produselor trece peste bugetul setat");
                }
            }
    }

    public void removeProduct(Product product,Integer price){
        var existingProduct =  new HashMap<Product, Integer>();
        existingProduct.put(product, price);
        if(products.contains(existingProduct)){
            products.remove(existingProduct);
            this.totalPrice -= price;
            System.out.println("Produsul "+product.getName()+" a fost eliminat cu succes!");
            return;
        }
        else{
            System.out.println("Produsul "+product.getName()+" nu exista in aceasta casa");
        }
    }

    private boolean isInBudget(int price){
        if(totalPrice+price > budget){
            return false;
        }
        else{
            return true;
        }
    }

}
