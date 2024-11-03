package lotto.view;

import java.util.List;
import lotto.dto.LottoDto;
import lotto.dto.StatisticDto;
import lotto.exception.LottoException.BonusNumberAlreadyIncludedWinningNumberException;
import lotto.util.Converter;
import lotto.util.InputValidator;
import lotto.vo.BonusNumber;
import lotto.vo.BuyLottoAmount;
import lotto.vo.TicketCount;

public class LottoView {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoView(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public BuyLottoAmount promptBuyAmount() {
        while (true) {
            try {
                String amount = inputView.inputBuyAmount();
                InputValidator.validateBuyLotteriesAmount(amount);

                return new BuyLottoAmount(Integer.parseInt(amount));
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    public List<Integer> promptWinningLotto() {
        while (true) {
            try {
                String numbers = inputView.inputWinningNumber();
                InputValidator.validateWinningNumbers(numbers);

                return Converter.convertToIntgerList(numbers);
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    public BonusNumber promptBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String number = inputView.inputBonusNumber();
                InputValidator.validateBonusNumber(number);
                int bonusNumber = Integer.parseInt(number);
                if (winningNumbers.contains(bonusNumber)) {
                    throw new BonusNumberAlreadyIncludedWinningNumberException();
                }

                return new BonusNumber(bonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    public void displayTicketCount(TicketCount ticketCount) {
        outputView.printTicketCountResult(ticketCount.count());
    }

    public void displayLotteries(List<LottoDto> lotteriesDto) {
        outputView.printLotteriesNumber(lotteriesDto);
    }

    public void displayStatistics(StatisticDto statisticDto) {
        outputView.printStatistic(statisticDto);
    }

    public void displayProfitRate(double profitRate) {
        outputView.printYeildRate(profitRate);
    }
}
