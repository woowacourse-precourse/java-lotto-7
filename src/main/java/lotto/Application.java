package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            LottoApp lottoApp = new LottoApp();
            lottoApp.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
