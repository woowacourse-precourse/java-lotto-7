package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGenerator lg = new LottoGenerator();
        lg.getLottos();

        WinningNumbers wn = new WinningNumbers();
        System.out.println(wn);
    }
}
