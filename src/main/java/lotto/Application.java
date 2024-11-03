package lotto;

import lotto.controller.LottoContoller;

public class Application {
    public static void main(String[] args) {
        LottoContoller lottoContoller = LottoContoller.getInstance();
        lottoContoller.run();
    }
}
