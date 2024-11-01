package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public static final String PURCHASE_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNING_LOTTO_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    public static final String BONUS_LOTTO_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private final Parser parser = new Parser();

    public int readLottoPurchasePrice() {
        return readNumber(PURCHASE_PRICE_INPUT_MESSAGE, readLottoPurchasePrice());
    }

    public List<Integer> readWinningLottoNumbers() {
        System.out.println(WINNING_LOTTO_NUMBERS_MESSAGE);
        try {
            return parser.parseWinningLottoNumbers(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return readWinningLottoNumbers();
    }

    public int readBonusLottoNumber() {
        return readNumber(BONUS_LOTTO_NUMBER_MESSAGE, readBonusLottoNumber());
    }

    private int readNumber(String message, int readBonusLottoNumber) {
        System.out.println(message);
        try {
            return parser.parseStringToInteger(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return readBonusLottoNumber;
    }
}
