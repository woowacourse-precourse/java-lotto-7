package lotto.controller;

import static lotto.ErrorCode.CONTIGIOUS_COMMA;
import static lotto.ErrorCode.INVALID_INPUT_FORMAT;
import static lotto.ErrorCode.INVALID_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.PublishCount;
import lotto.validator.DefaultDuplicateValidator;
import lotto.validator.DefaultRangeValidator;
import lotto.validator.LottoValidator;

public class LottoController {

    private static final int TICKET_PRICE = 1000;
    private static final String COMMAS = ",,";
    private static String ENTER_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";

    private LottoValidator lottoValidator = new LottoValidator(new DefaultRangeValidator(),
        new DefaultDuplicateValidator());
    private PublishCount publishCount;
    private Lotto lotto;

    public void setUp() {
        printEnterPurChasePriceMessage();
        publishCount = PublishCount.from(parseInt(readLine()));
        lotto = new Lotto(stringListToIntList(splitByComma(readLine())),lottoValidator);
    }

    //구매 금액 검증
    public void validatePurchaseAmount(final int purchaseAmount) {
        if (purchaseAmount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    //당첨 번호 검증
    public void validateInputWinnigNumber(final String inputWinnigNumber) {
        if (inputWinnigNumber.contains(COMMAS)) {
            throw new IllegalArgumentException(CONTIGIOUS_COMMA.getMessage());
        }
    }

    public List<String> splitByComma(String input) {
        return Arrays.stream(input.split(",")).toList();
    }

    public void printEnterPurChasePriceMessage() {
        System.out.println(ENTER_PURCHASE_PRICE_MESSAGE);
    }

    public String readLine() {
        return Console.readLine();
    }

    public List<Integer> stringListToIntList(List<String> stringList) {
        return stringList.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT.getMessage());
        }
    }
}
