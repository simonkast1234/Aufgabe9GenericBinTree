public class Product implements Comparable<Product> {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "(" + price + ")";
    }

    @Override
    public int compareTo(Product p) {
        if(this.price > p.price) return 1;
        else if(this.price < p.price) return -1;
        else if(Character.toLowerCase(this.name.toCharArray()[0]) > Character.toLowerCase(p.name.toCharArray()[0])) {
            return 1;
        }
        return -1;
    }
}
