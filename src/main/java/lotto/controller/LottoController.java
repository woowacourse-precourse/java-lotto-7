package lotto.controller;

import static lotto.constant.ErrorCode.CONTIGIOUS_COMMA;
import static lotto.constant.ErrorCode.INVALID_INPUT_FORMAT;
import static lotto.constant.ErrorCode.INVALID_PURCHASE_AMOUNT;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.PublishCount;
import lotto.repository.PublishLottoRepository;
import lotto.service.LottoResultService;
import lotto.service.ProfitCalculate;
import lotto.service.PublishLottoService;
import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final int TICKET_PRICE = 1000;
    private static final String COMMAS = ",,";

    private PublishLottoService publishLottoService;
    private final LottoResultService lottoResultService;
    private final LottoValidator lottoValidator;
    private final BonusNumberValidator bonusNumberValidator;
    private final InputView inputView;
    private final OutputView outputView;

    private PublishCount publishCount;
    private Lotto lotto;
    private BonusNumber bonusNumber;
    private PublishLottoRepository publishLottoRepository;

    public LottoController(
        LottoResultService lottoResultService, LottoValidator lottoValidator,
        BonusNumberValidator bonusNumberValidator,
        InputView inputView, OutputView outputView) {
        this.lottoResultService = lottoResultService;
        this.lottoValidator = lottoValidator;
        this.bonusNumberValidator = bonusNumberValidator;
        this.inputView = inputView;
        this.outputView = outputView;
        publishLottoRepository = PublishLottoRepository.getInstance();
    }

    public void setUp() {
        publishCountSetUp();
        publishLottoSetup();
        lottoSetUp();
        bonusNumberSetUp();
    }

    public void publishCountSetUp() {
        int purchasePrice = getPurchasePrice();
        validatePurchaseAmount(purchasePrice);
        publishCount = createPublishCount(purchasePrice);
        outputView.printPublishCountMessage(publishCount.getPublishCount());
    }

    private PublishCount createPublishCount(int purchasePrice) {
        int countOfPublish = getCountOfPublish(purchasePrice);
        return PublishCount.getInstance(countOfPublish);
    }

    public int getCountOfPublish(final int purchasePrice) {
        return purchasePrice / TICKET_PRICE;
    }

    private int getPurchasePrice() {
        return parseInt(inputView.printEnterPurChasePriceMessage());
    }

    public int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT.getMessage());
        }
    }

    public void validatePurchaseAmount(final int purchaseAmount) {
        if (purchaseAmount == 0 || purchaseAmount % TICKET_PRICE != 0 ) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    public void publishLottoSetup() {
        publishLottoService = new PublishLottoService(publishCount, lottoValidator);
        publishLottoService.publishLotto();
        outputView.printPublishLottos(publishLottoRepository.findAll());
    }

    public void lottoSetUp() {
        lotto = createLotto();
    }

    private Lotto createLotto() {
        String inputWinningNumbers = inputView.printEnterWinningNumberMessage();
        validateInputWinnigNumber(inputWinningNumbers);
        List<String> splitWinningNumbers = splitByComma(inputWinningNumbers);
        List<Integer> winningNumbers = stringListToIntList(splitWinningNumbers);
        return new Lotto(winningNumbers, lottoValidator);
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
        try {
            return stringList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT.getMessage());
        }
    }

    public void bonusNumberSetUp() {
        int parsedBonusNumber = getParsedBonusNumber();
        bonusNumber = createBonusNumber(parsedBonusNumber);
    }

    private int getParsedBonusNumber() {
        String inputBonusNumber = inputView.printBonusNumberMessage();
        return parseInt(inputBonusNumber);
    }

    private BonusNumber createBonusNumber(int parsedBonusNumber) {
        return BonusNumber.getInstance(parsedBonusNumber, lotto, bonusNumberValidator);
    }

    public void run() {
        Map<Prize, Integer> winningCounts = getWinningCounts();
        getProfit(winningCounts);
    }

    private void getProfit(Map<Prize, Integer> winningCounts) {
        BigDecimal profit = ProfitCalculate.calculateProfit(
            publishCount.getPublishCount() * TICKET_PRICE, winningCounts);
        outputView.printProfit(profit);
    }

    private Map<Prize, Integer> getWinningCounts() {
        Map<Prize, Integer> winningCounts = lottoResultService.calculatePrize(lotto, bonusNumber,
            publishLottoRepository.findAll());
        outputView.printWinningStatMessage(winningCounts);
        return winningCounts;
    }

}
