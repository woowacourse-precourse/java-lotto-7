package lotto;
import lotto.core.AppController;


public class Application {

    public static void main(String[] args) {
        try {
            AppController.initialize().run();
        } catch (InterruptedException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
