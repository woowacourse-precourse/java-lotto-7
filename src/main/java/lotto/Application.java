package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.LottoService;
import lotto.view.LottoInputHandler;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoInputHandler inputHandler = new LottoInputHandler();
        LottoService lottoService = new LottoService(inputHandler.getTotalPurchase());
        List<List<Integer>> totalRandomNumbers = lottoService.generateLottoTickets();
        Console.close();
    }
}