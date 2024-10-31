package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final int cost = Input.getCost();
        final String winNumbers = Input.getWinNumbers();
        final int bonus = Input.getBonusNumber();

        System.out.println("cost : " + cost);
        System.out.println("winNumbers : " + winNumbers);
        System.out.println("bonus : " + bonus);

    }
}
