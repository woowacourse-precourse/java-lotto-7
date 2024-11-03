package lotto;

import lotto.service.LottoApplicationProcessor;

public class Application {
    private final LottoApplicationProcessor lottoApplicationProcessor;

    public Application() {
        this.lottoApplicationProcessor = new LottoApplicationProcessor();
    }

    public void run() {
        this.lottoApplicationProcessor.run();
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }
}
