package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.global.string.QuestionConstants;
import lotto.service.LottoService;

public class LottoController {
    private LottoService lottoService = new LottoService();

    public void getAmount() {
        System.out.println(QuestionConstants.INPUT_MONEY);
        String inputText = Console.readLine().trim();
        int money = Integer.parseInt(inputText);

        lottoService.getAmount(money);
    }
}
