package View;

import Model.Lotto;
import camp.nextstep.edu.missionutils.Console;
import Constant.Constant;
import Util.Validator;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputView {
    public static Integer purchaseAmount;
    public static List<Lotto> buyLotto;
    public static Integer trialLottoCount;

    public Integer getPurchaseAmount() {
        System.out.println(Constant.MessageConstant.INPUT_PURCHASE_PROMPT);
        try {
            purchaseAmount = Integer.valueOf(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println(Constant.ErrorConstant.PURCHASE_WORD_INPUT_ERROR);
        }
        Validator.validateIsNumber(purchaseAmount);
        return purchaseAmount;
    }

    private static void validateLottoPriceThousand(Integer purchaseAmount) {
        if (purchaseAmount % Constant.GameRuleConstant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(Constant.ErrorConstant.PURCHASE_THOUSAND_ERROR);
        }
    }

    private static void calculateTrialLottoCount(Integer purchaseAmount) {
        trialLottoCount = purchaseAmount / Constant.GameRuleConstant.LOTTO_PRICE;
    }

    private static List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static List<Lotto> generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        calculateTrialLottoCount(purchaseAmount);

        for (int i = 0; i < trialLottoCount; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            lottos.add(new Lotto(lottoNumbers));
        }
        buyLotto = lottos;
        return buyLotto;
    }
}
