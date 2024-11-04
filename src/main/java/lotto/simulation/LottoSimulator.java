package lotto.simulation;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.io.ConsoleInputHandler;
import lotto.io.ConsoleOutputHandler;
import lotto.model.BuyAmount;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoSimulator {
    private final ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler();
    private final ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler();
    public void run() {
        consoleOutputHandler.buyAmountMessage();
        String buyAmountString = consoleInputHandler.buyAmount();
        BuyAmount buyAmount = new BuyAmount(buyAmountString);
        int lottoAmount = buyAmount.lottoAmount();
        consoleOutputHandler.lottoAmountMessage(lottoAmount);
        List<Lotto> lottoList = new ArrayList<>();
        for(int i = 0; i < lottoAmount; i++){
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
            lottoList.add(lotto);
        }
    }
}
