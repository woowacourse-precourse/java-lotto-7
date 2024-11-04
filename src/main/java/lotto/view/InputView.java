package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public static final String PURCHASE_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNING_LOTTO_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    public static final String BONUS_LOTTO_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private final Parser parser = new Parser();

    public int readLottoPurchasePrice() {
        System.out.println(PURCHASE_PRICE_INPUT_MESSAGE);
        try {
            return parser.parseLottoPurchasePrice(Console.readLine());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
        return readLottoPurchasePrice();
    }

    public List<Integer> readWinningLottoNumbers() {
        System.out.println(WINNING_LOTTO_NUMBERS_MESSAGE);
        try {
            return parser.parseWinningLottoNumbers(Console.readLine());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
        return readWinningLottoNumbers();
    }

    public int readBonusNumber() {
        System.out.println(BONUS_LOTTO_NUMBER_MESSAGE);
        try {
            return parser.parseStringToInteger(Console.readLine());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
        return readBonusNumber();
    }
}
