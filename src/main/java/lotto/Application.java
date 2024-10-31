package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = LottoGameAppConfig.getLottoController();
        lottoController.start();
    }
}
