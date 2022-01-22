package Package1.com;

import java.util.List;

public class Seller extends Person {
    private String name;
    private String lastname;
    private List<Product> products;



    String Seller1 = "Vitaliy";
    String Sellers2 = "Aleksey";

    public void searchPerson(String name) {
        if (getSeller1().isEmpty()) {

            System.out.println("Идем  " + getSellers2());
        }

    }


    public boolean sellProducts(Customer customer, Product expectedProduct) {
        for (Product product : products) {
            //Проверяем по имени товара что у продавца есть продукт.
            if (product.getName().equals(expectedProduct.getName())) {
                //проверяем что его количество товара больше или равно чем мы хотим купить.
                if (product.getQuantity() >= expectedProduct.getQuantity()) {
                    //проверяем что кэш покупател позволяет купить товар
                    long requiredCash = (long)  product.getPrice() * expectedProduct.getQuantity();
                    if(customer.getCash() >= requiredCash){
                        //уменьшяем количество продукта у продавца.
                        product.setQuantity(product.getQuantity() - expectedProduct.getQuantity());

                        //создаем новый объект для покупателя чтобы ссылка не дублировалась.
                        Product customerProduct = new Product();
                        customerProduct.setQuantity(expectedProduct.getQuantity());
                        customerProduct.setName(expectedProduct.getName());
                        //добавляем количество продуктов у покупателя

                        customer.addPurchase(customerProduct);
                        // увеличиваем кэш продавца

                        setCash(getCash() + requiredCash);
                        //уменьшяем кэш покупателя.

                        customer.setCash(customer.getCash() - requiredCash);
                        //сообщаем потребителя метода что покупка совершена

                        return true;
                    }
                }
            }
        }
        return false;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getSeller1() {
        return Seller1;
    }

    public void setSeller1(String seller1) {
        Seller1 = seller1;
    }

    public String getSellers2() {
        return Sellers2;
    }

    public void setSellers2(String sellers2) {
        Sellers2 = sellers2;
    }
}
