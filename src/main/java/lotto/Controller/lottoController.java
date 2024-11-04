package lotto.Controller;

import lotto.domain.*;
import lotto.service.CheckLotto;
import lotto.view.Input;

import java.util.List;
import java.util.Map;

import static lotto.service.CalculateResult.calculateResult;
import static lotto.service.CheckLotto.checkLottoRank;
import static lotto.view.Output.*;

public class lottoController {
    public static void start(){
        try {
            int putchaseAmount = Input.inputPurchaseAmount();
            List<Integer> winningNumber = Input.inputWinnerNumbers();
            Lotto winningLotto = new Lotto(winningNumber);
            int bonusNumber = Input.inputBonusNumber(winningNumber);
            int numberOfPurchase = Input.calculateLottoAmount(putchaseAmount);
            List<Lotto> lottos = LottoNumberGenerator.generateLottoNumbers(numberOfPurchase);
            WinningLotto winningLottoWithBonusNumber = new WinningLotto(winningLotto, bonusNumber);
            List<ResultOfLotto> resultOfLottos = checkLottoRank(winningLottoWithBonusNumber, lottos, bonusNumber);
            List<WinningRank> resultList = calculateResult(resultOfLottos);
            Map<WinningRank, Integer> resultOfLottoAsEnum = collectResult(resultList);
            printPurchasedLottoNumbers(lottos);
            printResult(resultOfLottoAsEnum, putchaseAmount);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
