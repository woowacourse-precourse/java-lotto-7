package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String PURCHASE_GUIDE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_RESULT = "%d개를 구매했습니다.";

    public static void main(String[] args) {
        try {
            LottoSystem lottoSystem = new LottoSystem();
            lottoSystem.start();
        } finally {
            Console.close();
        }
    }
}