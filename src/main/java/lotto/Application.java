package lotto;

import java.util.List;
import java.util.function.Supplier;

import lotto.answer.Answer;
import lotto.answer.LottoRank;
import lotto.io.Input;
import lotto.provider.LottoProvider;
import lotto.user.User;
import lotto.validator.Validator;

public class Application {
    public static void main(String[] args) {

        User user = new User();
        LottoProvider lottoProvider = attempt(() -> createLottoProvider(user));
        lottoProvider.pickLottoNumbers();
        lottoProvider.printPickedLottoResults();

        Lotto lottoAnswer = attempt(() -> createLottoAnswer());
        int bonusLotto = attempt(() -> createBonusLotto());
        Answer answer = new Answer(lottoAnswer, bonusLotto);

        List<LottoRank> lottoRanks = lottoProvider.calculateRank(answer);
        for (LottoRank lottoRank : lottoRanks) {
            user.updateRank(lottoRank);
        }
        user.calculateRateOfReturns();
        user.printResult();

    }

    private static <T> T attempt(Supplier <T> inputSupplier) {
        try {
            return inputSupplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return attempt(inputSupplier);
        }
    }

    private static LottoProvider createLottoProvider(User user) {
        int purchaseAmount = Input.readPurchaseAmount();
        return new LottoProvider(purchaseAmount, user);
    }

    private static Lotto createLottoAnswer() {
        return Input.readAnswerLotto();
    }

    private static int createBonusLotto() {
        return Input.readBonusLotto();
    }
}
