package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller();
        controller.start();
        controller.buying();
        controller.drawLotto();
    }
}
