package lotto.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.PublishCount;
import lotto.repository.PublishLottoRepository;
import lotto.service.LottoResultService;
import lotto.service.ProfitCalculate;
import lotto.service.PublishLottoService;
import lotto.util.InputHandler;
import lotto.validator.BonusNumberValidator;
import lotto.validator.CommaValidator;
import lotto.validator.LottoValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final int TICKET_PRICE = 1000;
    private PublishLottoService publishLottoService;
    private final LottoResultService lottoResultService;
    private final LottoValidator lottoValidator;
    private final BonusNumberValidator bonusNumberValidator;
    private final InputView inputView;
    private final OutputView outputView;
    private final PublishLottoRepository publishLottoRepository;

    private PublishCount publishCount;
    private Lotto lotto;
    private BonusNumber bonusNumber;

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
        PurchaseAmountValidator.validate(purchasePrice);
        publishCount = createPublishCount(purchasePrice);
        outputView.printPublishCountMessage(publishCount.getPublishCount());
    }

    public PublishCount createPublishCount(final int purchasePrice) {
        int countOfPublish = purchasePrice / TICKET_PRICE;
        return PublishCount.getInstance(countOfPublish);
    }

    private int getPurchasePrice() {
        return InputHandler.parseInt(inputView.printEnterPurChasePriceMessage());
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
        CommaValidator.validate(inputWinningNumbers);
        List<String> splitWinningNumbers = InputHandler.splitByComma(inputWinningNumbers);
        List<Integer> winningNumbers = InputHandler.stringListToIntList(splitWinningNumbers);
        return new Lotto(winningNumbers, lottoValidator);
    }

    public void bonusNumberSetUp() {
        int parsedBonusNumber = getParsedBonusNumber();
        bonusNumber = createBonusNumber(parsedBonusNumber);
    }

    private int getParsedBonusNumber() {
        String inputBonusNumber = inputView.printBonusNumberMessage();
        return InputHandler.parseInt(inputBonusNumber);
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
