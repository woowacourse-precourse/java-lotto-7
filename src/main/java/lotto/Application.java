package lotto;

import static lotto.constants.Constants.*;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController lottoController = new LottoController();
            lottoController.start();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
        } finally {
            Console.close();
        }
    }
}
