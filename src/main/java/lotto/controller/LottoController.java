package lotto.controller;

import static lotto.ErrorCode.CONTIGIOUS_COMMA;
import static lotto.ErrorCode.INVALID_INPUT_FORMAT;
import static lotto.ErrorCode.INVALID_PURCHASE_AMOUNT;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.PublishCount;
import lotto.validator.LottoValidator;
import lotto.view.InputView;

public class LottoController {

    private static final int TICKET_PRICE = 1000;
    private static final String COMMAS = ",,";

    private final LottoValidator lottoValidator;
    private final InputView inputView;

    private PublishCount publishCount;
    private Lotto lotto;

    public LottoController(LottoValidator lottoValidator, InputView inputView) {
        this.lottoValidator = lottoValidator;
        this.inputView = inputView;
    }

    public void publishCountSetUp() {
        //구매 금액
        int purchasePrice = getPurchasePrice();
        validatePurchaseAmount(purchasePrice);
        publishCount = createPublishCount(purchasePrice);
    }

    public void lottoSetUp() {
        lotto = createLotto();
    }

    private int getPurchasePrice() {
        return parseInt(inputView.printEnterPurChasePriceMessage());
    }

    private PublishCount createPublishCount(int purchasePrice) {
        int countOfPublish = getCountOfPublish(purchasePrice);
        return PublishCount.from(countOfPublish);
    }

    private Lotto createLotto() {
        List<String> splitWinningNumbers = splitByComma(inputView.printEnterWinningNumber());
        List<Integer> winningNumbers = stringListToIntList(splitWinningNumbers);
        return new Lotto(winningNumbers, lottoValidator);
    }

    public void validatePurchaseAmount(final int purchaseAmount) {
        if (purchaseAmount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    public int getCountOfPublish(final int purchasePrice) {
        return purchasePrice / TICKET_PRICE;
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
