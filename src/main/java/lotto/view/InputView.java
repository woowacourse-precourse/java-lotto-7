package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.global.Error.LOTTO_NUMBER_COMMA_COUNT_IS_NOT_FIVE;
import static lotto.global.Error.NOT_INTEGER;
import static lotto.global.Message.BONUS_NUMBER_MESSAGE;
import static lotto.global.Message.BUY_LOTTO_MESSAGE;
import static lotto.global.Message.WINNING_NUMBER_MESSAGE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Buy;
import lotto.domain.Lotto;
import lotto.domain.LottoBonus;

public class InputView {

    private static final String COMMA = ",";

    public Buy buyLotto() {
        System.out.println(BUY_LOTTO_MESSAGE.getMsg());
        try {
            int money = convertToInt(readLine());
            return new Buy(money);
        } catch (NumberFormatException e) {
            System.out.println(NOT_INTEGER.getErrorMsg());
            return buyLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return buyLotto();
        }
    }

    public Lotto inputWinningLottoNumbers() {
        System.out.println(WINNING_NUMBER_MESSAGE.getMsg());
        try {
            List<String> splitNumbersByComma = splitNumbersByComma(validateCommaSizeIsFive(readLine()));
            List<Integer> lottoNumbers = convertToIntList(splitNumbersByComma);
            return new Lotto(lottoNumbers);
        } catch (NumberFormatException e) {
            System.out.println(NOT_INTEGER.getErrorMsg());
            return inputWinningLottoNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningLottoNumbers();
        }
    }

    private String validateCommaSizeIsFive(String winningLottoNumber) {
        long commaCount = winningLottoNumber.chars().filter(ch -> ch == COMMA.charAt(0)).count();
        if (commaCount != 5) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COMMA_COUNT_IS_NOT_FIVE.getErrorMsg());
        }
        return winningLottoNumber;
    }

    public LottoBonus inputLottoBonusNumber(List<Integer> winningLottoNumbers) {
        System.out.println(BONUS_NUMBER_MESSAGE.getMsg());
        try {
            int bonusNumber = convertToInt(readLine());
            return new LottoBonus(bonusNumber, winningLottoNumbers);
        } catch (NumberFormatException e) {
            System.out.println(NOT_INTEGER.getErrorMsg());
            return inputLottoBonusNumber(winningLottoNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLottoBonusNumber(winningLottoNumbers);
        }
    }

    private List<String> splitNumbersByComma(String numbers) {
        return Arrays.stream(numbers.split(COMMA)).collect(Collectors.toList());
    }

    private List<Integer> convertToIntList(List<String> numbers) {
        return numbers.stream().map(number -> convertToInt(number)).collect(Collectors.toList());
    }

    private int convertToInt(String money) throws NumberFormatException {
        return Integer.parseInt(money);
    }
}
