package lotto;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        Service service = new Service();
        service.run();
    }
}
