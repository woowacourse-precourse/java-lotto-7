package lotto.controller;

import lotto.dto.WinningLottoResultDTO;
import lotto.exception.ExceptionMessages;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        int buyLottoMoney = getBuyLottoMoney();
        int buyLottoCount = lottoService.getCalculateBuyLottoCount(buyLottoMoney);

        lottoService.callCreateLottos(buyLottoCount);
        outputView.printBuyLottoCount(buyLottoCount);

        printLottos();

        String winningNumbers = getWinningNumbers();
        String bonusNumber = getBonusNumber();

        processWinningNumbers(winningNumbers, bonusNumber);

        printWinningStatistics(buyLottoMoney);
    }

    private int getBuyLottoMoney() {
        while (true) {
            String input = inputView.inputBuyLottoMoney();
            try {
                int money = Integer.parseInt(input);
                lottoService.getCalculateBuyLottoCount(money);
                return money;
            } catch (NumberFormatException e) {
                outputView.printErrorMessage(ExceptionMessages.INVALID_NUMBER_FORMAT_ERROR + input);
                outputView.printWhiteSpace();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
                outputView.printWhiteSpace();
            }
        }
    }

    private String getWinningNumbers() {
        while (true) {
            try {
                String input = inputView.inputWinningNumbers();
                return input;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
                outputView.printWhiteSpace();
            }
        }
    }

    private String getBonusNumber() {
        while (true) {
            try {
                String input = inputView.inputBonusNumber();
                return input;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
                outputView.printWhiteSpace();
            }
        }
    }

    private void printLottos() {
        List<String> formattedLottoNumbers = lottoService.formatBuyLottoNumbersResult();
        for (String formattedLottoNumber : formattedLottoNumbers) {
            outputView.printLottoNumbers(formattedLottoNumber);
        }
        outputView.printWhiteSpace();
    }

    private void processWinningNumbers(String winningNumbers, String bonusNumber) {
        while (true) {
            try {
                lottoService.recordWinningLotto(winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
                outputView.printWhiteSpace();

                bonusNumber = getBonusNumber();
            }
        }
    }

    private void printWinningStatistics(int buyLottoMoney) {
        List<WinningLottoResultDTO> formatWinningLottoResults = lottoService.formatWinningLottoResults();

        outputView.printWhiteSpace();
        outputView.printBeforeWinningLottoStatistics();
        for (WinningLottoResultDTO winningLottoResultDTO : formatWinningLottoResults) {
            if (winningLottoResultDTO.hasBonus()) {
                outputView.printWinningLottoStatisticsHasBonus(
                        winningLottoResultDTO.getMatchedCount(),
                        winningLottoResultDTO.getPrize(),
                        winningLottoResultDTO.getCount()
                );
                continue;
            }

            outputView.printWinningLottoStatistics(
                    winningLottoResultDTO.getMatchedCount(),
                    winningLottoResultDTO.getPrize(),
                    winningLottoResultDTO.getCount()
            );
        }

        double lottoRateOfReturn = lottoService.callCalculateLottoRateOfReturn(buyLottoMoney);
        outputView.printRateOfReturn(lottoRateOfReturn);
    }
}
