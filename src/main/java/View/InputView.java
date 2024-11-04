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
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요. (쉼표로 구분)";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 입력값 %s는 올바른 숫자 형식이 아닙니다.";

    public static Integer getPurchaseAmount() {
        System.out.println(Constant.MessageConstant.INPUT_PURCHASE_PROMPT);
        try {
            purchaseAmount = Integer.valueOf(Console.readLine());
            Validator.validateIsNumber(purchaseAmount);
            validateLottoPriceThousand(purchaseAmount);
        } catch (NumberFormatException e) {
            System.out.println(Constant.ErrorConstant.PURCHASE_WORD_INPUT_ERROR);
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
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

    public static List<Integer> inputWinningNumbers() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        String[] numberStrings = Console.readLine().split(",");
        return convertStringToInteger(numberStrings);
    }

    public static Integer inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력된 값이 정수가 아닙니다.");
            return null;
        }
    }

    private static List<Integer> convertStringToInteger(String[] numberStrings) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            try {
                int number = Integer.parseInt(numberString.trim());
                winningNumbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println(String.format(NUMBER_FORMAT_ERROR_MESSAGE, numberString));
            }
        }
        return winningNumbers;
    }
}
