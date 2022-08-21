package spring.basic.singleton;

public class StatefulService { //싱글톤 방식에서의 주의점

    private int price;

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; //여기가 문제! -> 값 변경됨.
    }

    public int getPrice() {
        return price;
    }
}
