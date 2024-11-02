package lotto;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    private void run() {
        LottoStore lottoStore = new LottoStore();
        lottoStore.open();
    }
}
