package lotto;

interface Predator{
    String getFood();
}

interface Barkable{
    void bark();
}

class Bouncer {
    void barkAnimal(Barkable animal) {  // Animal 대신 Barkable을 사용
        animal.bark();
    }
}

class Animal {
    String name;

    void setName(String name) {
        this.name = name;
    }
}

class Tiger extends Animal implements Predator, Barkable {
    public String getFood() {
        return "apple";
    }
    public void bark() {
        System.out.println("어흥");
    }

}

class Lion extends Animal implements Predator, Barkable {
    public String getFood() {
        return "banana";
    }
    public void bark() {
        System.out.println("으르렁");
    }

}

class ZooKeeper {
    void feed(Predator predator) {
        System.out.println("feed " + predator.getFood());
    }
}

public class Application {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        Lion lion = new Lion();

        Bouncer bouncer= new Bouncer();
        bouncer.barkAnimal(tiger);
        bouncer.barkAnimal(lion);
    }
}
