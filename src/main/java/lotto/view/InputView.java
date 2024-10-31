package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.global.Error.NOT_INTEGER;
import static lotto.global.Message.BUY_LOTTO_MESSAGE;
import static lotto.global.Message.WINNING_NUMBER_MESSAGE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Buy;
import lotto.domain.Lotto;

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
            List<Integer> lottoNumbers = convertToIntList(splitNumbersByComma(readLine()));
            return new Lotto(lottoNumbers);
        } catch (NumberFormatException e) {
            System.out.println(NOT_INTEGER.getErrorMsg());
            return inputWinningLottoNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningLottoNumbers();
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
