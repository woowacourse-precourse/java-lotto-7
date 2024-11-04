package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT_QUESTION = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBER_INPUT_QUESTION = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_QUESTION = "보너스 번호를 입력해 주세요.";

    public static int getPurchaseAmount() {
        return getNumber(PURCHASE_AMOUNT_INPUT_QUESTION);
    }

    public static int getBonusNumber() {
        return getNumber(BONUS_NUMBER_INPUT_QUESTION);
    }

    public static List<Integer> getLottoNumber() {
        List<Integer> lottoNumber = null;
        while (lottoNumber == null) {
            try {
                String input = askInput(LOTTO_NUMBER_INPUT_QUESTION);
                lottoNumber = InputParser.parseLottoNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lottoNumber;
    }

    private static int getNumber(String purchaseAmountInputQuestion) {
        int getNumber = 0;
        while (getNumber == 0) {
            try {
                String input = askInput(purchaseAmountInputQuestion);
                getNumber = InputParser.parseNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return getNumber;
    }

    private static String askInput(String question) {
        System.out.println(question);
        String result = readLine();
        System.out.println();
        return result;

    }
}
