package lotto;

public class Application {
    public static void main(String[] args) {
        PrizeController controller = new PrizeController();

        try {
            controller.lottoStart();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

}
