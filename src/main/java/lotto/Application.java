package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoChecker;
import lotto.model.LottoInput;
import lotto.model.LottoResult;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoInput lottoInput = new LottoInput();
        LottoChecker lottoChecker = new LottoChecker();
        LottoResult lottoResult = new LottoResult();
        List<Lotto> allLottos = new ArrayList<>();

        int lottoPurchaseAmount = lottoInput.getLottoPurchaseAmount();

        for (int i = 0; i < lottoPurchaseAmount; i++) {
            Lotto lotto = new Lotto(generateLottoNumbers());
            allLottos.add(lotto);
        }

        printAllLottosNumbers(allLottos);
        List<Integer> winningNumbers = lottoInput.inputWinningNumbers();
        Integer bonusNumber = lottoInput.inputBonusNumber();

        lottoChecker.lottoCheckingProcess(allLottos, winningNumbers, bonusNumber, lottoResult);
        lottoResult.printResults();
        lottoResult.computeProfitRate(lottoPurchaseAmount);
    }

    private static void printAllLottosNumbers(List<Lotto> allLottos) {
    }

    public static List<Integer> generateLottoNumbers() {
    }
}
