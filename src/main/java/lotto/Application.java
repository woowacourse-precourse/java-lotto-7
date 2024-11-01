package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentSkipListMap;
import lotto.controller.LottoController;
import lotto.domain.Lotto;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.tryLotto();
    }
}
