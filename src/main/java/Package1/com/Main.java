package Package1.com;
//1. Seller. Может добавлять,убирать продукты, выставлять стоимость.
//2. Customer. Может покупать товары, может что-то желать.
//3. Когда seller продает продукты, у него они отнимаются, добавляется у customer.
//кэш отнимается у customer, добавляется к seller.
//4. Поиск товара про продавца и продукту, либо по продукту.

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();

        Seller firstSeller = createdFirstSeller();
        Seller secondSeller = createdSecondSeller();

        market.addSeller(firstSeller);
        market.addSeller(secondSeller);

        Customer customer = createdFirstCustomer();
        customer.findProductOnMarket(market);
        customer.info();


    }


    private static Customer createdFirstCustomer(){
        Product firstProduct = new Product();
        firstProduct.setName(Constans.TOMATOES_PRODUCT_NAME);
        firstProduct.setQuantity(3);

        Product secondProduct = new Product();
        secondProduct.setName(Constans.CUCUMBER_PRODUCT_NAME);
        secondProduct.setQuantity(2);

        return new Customer(List.of(firstProduct, secondProduct), 50);
    }

    private static Seller createdFirstSeller(){
        Seller seller = new Seller();
        seller.setName("Vitaliy");
        seller.setLastname("Eremin");
        seller.setCash(0);

        Product firstProduct = new Product();
        firstProduct.setName(Constans.TOMATOES_PRODUCT_NAME);
        firstProduct.setPrice(10);
        firstProduct.setQuantity(2);

        Product secondProduct = new Product();
        secondProduct.setName(Constans.CUCUMBER_PRODUCT_NAME);
        secondProduct.setPrice(8);
        secondProduct.setQuantity(100);

        List<Product> products = new ArrayList<>();
        products.add(firstProduct);
        products.add(secondProduct);
        seller.setProducts(products);
        return seller;
    }

    private static Seller createdSecondSeller(){
        Seller seller = new Seller();
        seller.setName("Aleksey");
        seller.setLastname("Ushakov");
        seller.setCash(0);

        Product firstProduct = new Product();
        firstProduct.setName(Constans.TOMATOES_PRODUCT_NAME);
        firstProduct.setPrice(8);
        firstProduct.setQuantity(40);

        Product secondProduct = new Product();
        secondProduct.setName(Constans.CUCUMBER_PRODUCT_NAME);
        secondProduct.setPrice(5);
        secondProduct.setQuantity(12);

        List<Product> products = new ArrayList<>();
        products.add(firstProduct);
        products.add(secondProduct);
        seller.setProducts(products);
        return seller;

    }

    
}
