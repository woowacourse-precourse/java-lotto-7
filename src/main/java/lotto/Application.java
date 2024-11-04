package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        LottoSimulator lottoSimulator = new LottoSimulator(appConfig.getLottoShop());
        lottoSimulator.start();
    }
}
