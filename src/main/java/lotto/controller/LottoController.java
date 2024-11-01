package lotto.controller;

import lotto.dto.LottoResultDto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;
    private LottoResultDto lottoDto;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        lottoDto = purchaseLotto();
        outputView.printPurchaseLottoList(lottoDto);
        List<Integer> winningNumbers = receiveWinningNumbers();
        int bonusNumber = receiveBonusNumber(winningNumbers);
        setLottoResultDto(bonusNumber, winningNumbers);
        List<Map<Integer, Boolean>> resultList = lottoService.getLottoWinningResults(lottoDto);
    }

    private void setLottoResultDto(int bonusNumber, List<Integer> winningNumbers) {
        lottoDto.setBonusNumber(bonusNumber);
        lottoDto.setWinningNumbers(winningNumbers);
    }

    private LottoResultDto purchaseLotto() {
        while (true) {
            try {
                outputView.printPurchaseAmount();
                int price = inputView.readPrice();
                return lottoService.createLottoList(price);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private List<Integer> receiveWinningNumbers() {
        while (true) {
            try {
                outputView.printWinningNumberInputMessage();
                List<Integer> winningNumbers = inputView.readWinningNumbers();
                return lottoService.createWinningNumbers(winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private int receiveBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                outputView.printBonusNumberInputMessage();
                int bonusNumber = inputView.readBonusNumber();
                lottoService.checkBonusNumberValidity(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }
}
