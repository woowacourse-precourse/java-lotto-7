package lotto;

import java.util.List;

import lotto.answer.Answer;
import lotto.answer.LottoRank;
import lotto.io.Input;
import lotto.provider.LottoProvider;
import lotto.user.User;
import lotto.validator.Validator;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = Input.readPurchaseAmount();

        User user = new User();
        LottoProvider lottoProvider = new LottoProvider(purchaseAmount, user);
        lottoProvider.pickLottoNumbers();
        lottoProvider.printPickedLottoResults();

        List<Integer> answerLottos = Input.readAnswerLotto();
        int bonusLotto = Input.readBonusLotto();
        Answer answer = new Answer(answerLottos, bonusLotto);

        List<LottoRank> lottoRanks = lottoProvider.calculateRank(answer);
        for (LottoRank lottoRank : lottoRanks) {
            user.updateRank(lottoRank);
        }
        user.calculateRateOfReturns();
        user.printResult();
    }
}
