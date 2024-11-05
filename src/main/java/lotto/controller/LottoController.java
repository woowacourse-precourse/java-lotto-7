package lotto.controller;

import static lotto.validator.Validator.validateBuyAmount;

import java.util.EnumMap;
import java.util.Map;
import lotto.config.LottoConfig;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.dto.UserLotto;
import lotto.dto.WinningResult;
import lotto.exception.BonusNumberDuplicatedLottoNumberException;
import lotto.exception.BonusNumberOutOfRangeException;
import lotto.exception.BuyAmountHasChangeException;
import lotto.exception.DuplicatedLottoNumberException;
import lotto.exception.EmptyWinningNumberInputException;
import lotto.exception.IllegalNumberFormatException;
import lotto.exception.LottoCountOutOfRangeException;
import lotto.exception.LottoNumberCountOutOfRangeException;
import lotto.exception.LottoNumberOutOfRangeException;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.service.LottoService;

public class LottoController {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    private final LottoService lottoService;


    public LottoController(LottoConfig lottoConfig,
                           LottoService lottoService) {

        this.inputHandler = lottoConfig.getInputHandler();
        this.outputHandler = lottoConfig.getOutputHandler();

        this.lottoService = lottoService;
    }

    public void run() {
        try {
            playLottoGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void playLottoGame() {

        long buyAmount = getValidBuyAmount();

        UserLotto userLotto = lottoService.getValidUserLotto(buyAmount);
        outputHandler.userLottoHandle(userLotto);

        WinningLotto winningLotto = getValidWinningLotto();

        int bonusNumber = getValidBonusNumber(winningLotto);

        WinningResult result = lottoService.calculateWinningResult(userLotto, buyAmount, winningLotto, bonusNumber);
        outputHandler.winningResultHandle(result);
    }

    private long getValidBuyAmount() {
        while (true) {
            try {
                long buyAmount = inputHandler.readBuyAmount();
                validateBuyAmount(buyAmount);
                return buyAmount;
            } catch (IllegalNumberFormatException | LottoCountOutOfRangeException |
                     BuyAmountHasChangeException exception) {
                System.out.println(exception.getMessage());
            }
        }

    }

    private WinningLotto getValidWinningLotto() {
        while (true) {
            try {
                String winningNumbers = inputHandler.readWinningNumbers();
                return lottoService.convertWinningNumbers(winningNumbers);
            } catch (EmptyWinningNumberInputException | IllegalNumberFormatException |
                     LottoNumberCountOutOfRangeException | LottoNumberOutOfRangeException |
                     DuplicatedLottoNumberException exception
            ) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private int getValidBonusNumber(WinningLotto winningLotto) {
        while (true) {
            try {
                int inputBonusNumber = inputHandler.readBonusNumber();
                return lottoService.validateBonusNumber(inputBonusNumber, winningLotto);
            } catch (IllegalNumberFormatException | BonusNumberOutOfRangeException |
                     BonusNumberDuplicatedLottoNumberException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static Map<Rank, Integer> initializeResultMap() {
        Map<Rank, Integer> initialMap = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            initialMap.put(rank, 0);
        }
        return initialMap;
    }
}
