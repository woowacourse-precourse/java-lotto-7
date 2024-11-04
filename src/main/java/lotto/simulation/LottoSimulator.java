package lotto.simulation;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.io.ConsoleInputHandler;
import lotto.io.ConsoleOutputHandler;
import lotto.model.BuyAmount;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoSimulator {
    public void run() {
        ConsoleOutputHandler.buyAmountMessage();
        String buyAmountString = ConsoleInputHandler.buyAmount();
        BuyAmount buyAmount = new BuyAmount(buyAmountString);
        int lottoAmount = buyAmount.lottoAmount();
        ConsoleOutputHandler.lottoAmountMessage(lottoAmount);
        List<Lotto> lottoList = new ArrayList<>();
        for(int i = 0; i < lottoAmount; i++){
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
            lottoList.add(lotto);
            lotto.lottoNumberOut();
        }
    }
}
