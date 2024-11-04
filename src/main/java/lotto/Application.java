package lotto;

public class Application {
    public static void main(String[] args) {
        LottoApp lottoApp = LottoAppDownloader.downLoad();
        lottoApp.start();
    }
}
