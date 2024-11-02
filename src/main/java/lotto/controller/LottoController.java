package lotto.controller;

import static lotto.ErrorCode.CONTIGIOUS_COMMA;
import static lotto.ErrorCode.INVALID_INPUT_FORMAT;
import static lotto.ErrorCode.INVALID_PURCHASE_AMOUNT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PublishCount;
import lotto.domain.PublishLotto;
import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoValidator;
import lotto.view.InputView;

public class LottoController {

    private static final int TICKET_PRICE = 1000;
    private static final String COMMAS = ",,";

    private final LottoValidator lottoValidator;
    private final BonusNumberValidator bonusNumberValidator;
    private final InputView inputView;

    private PublishCount publishCount;
    private Lotto lotto;
    private BonusNumber bonusNumber;
    private List<PublishLotto> publishLottos;

    public LottoController(LottoValidator lottoValidator, BonusNumberValidator bonusNumberValidator,
        InputView inputView) {
        this.lottoValidator = lottoValidator;
        this.bonusNumberValidator = bonusNumberValidator;
        this.inputView = inputView;
        publishLottos = new ArrayList<>();
    }

    public void setUp() {
        publishCountSetUp();
        lottoSetUp();
        bonusNumberSetUp();
    }

    public void publishCountSetUp() {
        int purchasePrice = getPurchasePrice();
        validatePurchaseAmount(purchasePrice);
        publishCount = createPublishCount(purchasePrice);
    }

    public void lottoSetUp() {
        lotto = createLotto();
    }

    public void bonusNumberSetUp() {
        int parsedBonusNumber = getParsedBonusNumber();
        bonusNumber = createBonusNumber(parsedBonusNumber);
    }

    public void publishLottoSetup() {
        createPublishLottos();
    }

    private void createPublishLottos() {
        for (int i = 0; i < publishCount.getPublishCount(); i++) {
            PublishLotto publishLotto = PublishLotto.from(lottoValidator);
            publishLottos.add(publishLotto); // 생성한 객체를 리스트에 추가
        }
    }

    public void validatePurchaseAmount(final int purchaseAmount) {
        if (purchaseAmount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    private BonusNumber createBonusNumber(int parsedBonusNumber) {
        return new BonusNumber(parsedBonusNumber, lotto, bonusNumberValidator);
    }

    private int getParsedBonusNumber() {
        String inputBonusNumber = inputView.printBonusNumberMessage();
        return parseInt(inputBonusNumber);
    }

    private int getPurchasePrice() {
        return parseInt(inputView.printEnterPurChasePriceMessage());
    }

    private PublishCount createPublishCount(int purchasePrice) {
        int countOfPublish = getCountOfPublish(purchasePrice);
        return PublishCount.getInstance(countOfPublish);
    }

    private Lotto createLotto() {
        List<String> splitWinningNumbers = splitByComma(inputView.printEnterWinningNumberMessage());
        List<Integer> winningNumbers = stringListToIntList(splitWinningNumbers);
        return new Lotto(winningNumbers, lottoValidator);
    }

    public int getCountOfPublish(final int purchasePrice) {
        return purchasePrice / TICKET_PRICE;
    }

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

    public List<PublishLotto> getPublishLottos() {
        return publishLottos;
    }
}
