package homework17.app;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Product> catalog = new ArrayList<>();

        catalog.add(new Product("Cola", "drink", 23));
        catalog.add(new Product("Sprite", "drink", 21));
        catalog.add(new Product("Corn", "vegetable", 15));
        catalog.add(new Product("Tomato", "vegetable", 5));
        catalog.add(new Product("Jacket", "clothes", 70));

        Map<String, Double> group = catalog.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));

        System.out.println(group);

        Map.Entry<String, Double> maxPrice = Collections.max(group.entrySet(), Map.Entry.comparingByValue());
        System.out.println("Category: " + maxPrice.getKey() + ", max price: " + maxPrice.getValue());

//        group.forEach((key, value) -> {
//            double averagePrice = value.stream().collect(Collectors.averagingDouble(Product::getPrice));
//            System.out.println("Category: " + key);
//            value.forEach(product -> System.out.println(product.toString()));
//            System.out.println("Average price: " + averagePrice + "\n");
//        });
//
//
    }
}
