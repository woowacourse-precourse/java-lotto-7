package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        LottoInput lottoInput = new LottoInput();
        int amount = lottoInput.purchaseInput();
    }
}