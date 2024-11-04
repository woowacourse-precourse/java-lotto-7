package lotto.controller;

import static lotto.utils.Constants.*;

import java.util.Arrays;
import java.util.Comparator;
import lotto.model.Cashier;
import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.LottoResult;
import lotto.model.Prize;
import lotto.model.WinningLotto;
import lotto.utils.ErrorMessage;
import lotto.view.*;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoManager lottoManager;
    private final LottoResult lottoResult;
    private final Cashier cashier;

    public LottoController(InputView inputView, OutputView outputView, LottoManager lottoManager, LottoResult lottoResult, Cashier cashier) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoManager = lottoManager;
        this.lottoResult = lottoResult;
        this.cashier = cashier;
    }

    public void run() {
        buyLotto();
        checkResult();
        checkRateOfReturn();
    }

    public void buyLotto() {
        try {
            int price = validateIsNumberAndParse(inputView.input(INPUT_PRICE_MESSAGE));
            cashier.payPrice(price);
            int count = cashier.getLottoCount();
            outputView.printBuyResult(count);
            buy(count);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
            buyLotto();
        }
    }

    public WinningLotto generateWinningLotto() {
        return new WinningLotto(generateWinningNumbers(), generateBonusNumber());
    }

    public void checkResult() {
        lottoResult.calculateResult(lottoManager.getLottos(), generateWinningLotto());
        outputView.printWinningResultHeader();
        Arrays.stream(Prize.values())
                .filter(prize -> prize != Prize.FAILURE)
                .sorted(Comparator.comparingInt(Prize::getCountOfMatchingNumbers)
                        .thenComparingInt(Prize::getPrizeMoney))
                .forEach(prize -> outputView.printWinningResult(prize.getCountOfMatchingNumbers(), prize.isBonusNumberMatch()
                        , prize.getPrizeMoney(), lottoResult.getPrizeCount(prize)));
    }

    public void checkRateOfReturn() {
        outputView.printRateOfReturn(lottoResult.calculateRateOfReturn(cashier.getPrice()));
    }

    private void buy(int count) {
        for (int i = 0; i < count; i++) {
            outputView.printLottoTicket(lottoManager.addLotto());
        }
    }

    private Lotto generateWinningNumbers() {
        try {
            String winningNumbers = inputView.input(INPUT_WINNING_NUMBERS_MESSAGE);
            return lottoManager.generateCustomLotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
            return generateWinningNumbers();
        }
    }

    private int generateBonusNumber() {
        try {
            int bonusNumber = validateIsNumberAndParse(inputView.input(INPUT_BONUS_NUMBER_MESSAGE));
            lottoManager.validateNumberInRange(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e);
            return generateBonusNumber();
        }
    }

    private int validateIsNumberAndParse(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MUST_BE_NUMBER.getMessage());
        }
    }
}
