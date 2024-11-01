package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchaseCalculator;
import lotto.domain.MatchStatistics;
import lotto.domain.WinningNumber;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.util.RandomNumberGenerator;
import lotto.error.LottoError;

public class LottoController {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final LottoPurchaseCalculator lottoManager;
    private final MatchStatistics matchStatistics = new MatchStatistics();

    public LottoController(InputHandler inputHandler, OutputHandler outputHandler,
                           RandomNumberGenerator randomNumberGenerator) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.lottoManager = new LottoPurchaseCalculator(randomNumberGenerator);
    }

    public void startLotto() {
        while (true) {
            try {
                outputHandler.showLottoPrice();
                String price = inputHandler.price();
                int lottoCount = lottoManager.getLottoCount(price);

                matchStatistics.setTotalSpent(Double.parseDouble(price));
                outputHandler.showLottoCount(lottoCount);

                List<Lotto> lottoNumbers = lottoManager.generateLottoNumbers(lottoCount);
                for (Lotto lotto : lottoNumbers) {
                    outputHandler.showLottoList(lotto.getNumbers());
                }

                outputHandler.showWinningNumbersMessage();
                List<Integer> winNumbers = getValidWinningNumbers();

                outputHandler.showBonusNumberMessage();
                int bonusNumber = getValidBonusNumber(winNumbers);

                WinningNumber winningNumber = new WinningNumber(winNumbers, bonusNumber);
                matchStatistics.calculateMatches(lottoNumbers, winningNumber);

                outputHandler.showMatchResult(matchStatistics.getMatchResults(), matchStatistics.getProfitRate());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getValidBonusNumber(List<Integer> winNumbers) {
        while (true) {
            String bonusInput = inputHandler.bonusNumber();
            try {
                int bonusNumber = validateBonusNumber(bonusInput);
                if (winNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException(LottoError.BONUS_NUMBER_DUPLICATE.getMessage());
                }
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("보너스 번호를 입력해 주세요.");
            }
        }
    }

    private List<Integer> getValidWinningNumbers() {
        while (true) {
            String winningInput = inputHandler.winningNumbers();
            try {
                return validateWinningNumbers(winningInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> validateWinningNumbers(String winningInput) {

        if (!winningInput.matches("(\\d+)(,\\s*\\d+)*")) {
            throw new IllegalArgumentException(LottoError.INVALID_WINNING_NUMBERS_DELIMITER.getMessage());
        }

        String[] parts = winningInput.split(",");
        if (parts.length != 6) {
            throw new IllegalArgumentException(LottoError.INVALID_WINNING_NUMBERS_COUNT.getMessage());
        }

        List<Integer> winNumbers = new ArrayList<>();
        for (String part : parts) {
            try {
                int number = Integer.parseInt(part.trim());
                if (number < 1 || number > 45) {
                    throw new IllegalArgumentException(LottoError.INVALID_WINNING_NUMBER_RANGE.getMessage());
                }
                winNumbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(LottoError.INVALID_WINNING_NUMBERS_FORMAT.getMessage());
            }
        }
        return winNumbers;
    }

    private int validateBonusNumber(String bonusInput) {
        if (bonusInput.contains(",")) {
            throw new IllegalArgumentException(LottoError.INVALID_BONUS_NUMBER.getMessage());
        }
        try {
            int bonusNumber = Integer.parseInt(bonusInput.trim());
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException(LottoError.INVALID_BONUS_NUMBER.getMessage());
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoError.INVALID_BONUS_NUMBER.getMessage());
        }
    }
}
