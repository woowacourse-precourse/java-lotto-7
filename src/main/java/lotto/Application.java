package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        OutputSystem.printMessageForPurchaseAmount();
        int lottoCount = Lotto.lottoCount(InputSystem.inputLottoPurchaseAmount());
        List<List<Integer>> lottoNumbers = Lotto.purchaseLottoNumbers(lottoCount);
        OutputSystem.printMessageForLottoCountAndNumbers(lottoCount,lottoNumbers);

        OutputSystem.printMessageForLottoNumber();
        List<Integer> lottoNumber = InputSystem.inputLottoNumber();

        // Lotto 객체 생성
        Lotto lotto = new Lotto(lottoNumber);

        OutputSystem.printMessageForBonusNumber();
        int bonusNumber =  InputSystem.inputBonusNumber(lottoNumber);

        int[] checkNumbers = lotto.lottoWinningCheck(lotto,bonusNumber,lottoNumbers);
        OutputSystem.printMessageForWinningStatistics();
    }
}
