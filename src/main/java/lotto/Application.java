package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.LottoConfig;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = LottoConfig.getLottoController();
        try {
            lottoController.run();
        } catch (OutOfMemoryError e) {
            throw new IllegalArgumentException("처리 불가능한 입력입니다!");
        } finally {
            Console.close();
        }
    }
}
