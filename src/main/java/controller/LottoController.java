package controller;

import camp.nextstep.edu.missionutils.Console;
import model.Lotto;
import model.LottoResult;
import service.LottoService;
import util.Message;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void start() {
        int purchaseAmount = inputPurchaseCost();
        List<Lotto> lottos = issueLottos(purchaseAmount);

        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber(winningNumbers);

        List<LottoResult> results = checkWinningResults(lottos, winningNumbers, bonusNumber);
        printResultsAndProfitRate(results, purchaseAmount);
    }

    private int inputPurchaseCost() {
        while (true) {
            System.out.println(Message.PURCHASE_COST);
            try {
                int purchaseCost = Integer.parseInt(Console.readLine().trim());
                if (purchaseCost % 1000 != 0) {
                    throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
                }
                return purchaseCost;
            } catch (NumberFormatException e) {
                outputView.printError("유효한 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }

    }

    private List<Lotto> issueLottos(int purchaseAmount) {
        int ticketCount = purchaseAmount / 1000;
        outputView.printTicketCount(ticketCount);
        List<Lotto> lottos = lottoService.issueLottos(ticketCount);
        outputView.printLottos(lottos);
        return lottos;
    }

    private List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                List<Integer> winningNumbers = inputView.inputWinningNumbers();
                lottoService.validateWinningNumbers(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private int inputBonusNumber(List<Integer >winningNumbers) {
        while (true) {
            try {
                int bonusNumber = inputView.inputBonusNumber();
                lottoService.validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private List<LottoResult> checkWinningResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        return lottos.stream().map(lotto -> lottoService.checkWin(lotto, winningNumbers, bonusNumber)).toList();
    }

    private void printResultsAndProfitRate(List<LottoResult> results, int purchaseAmount) {
        outputView.printResults(results);
        double profitRate = lottoService.calculateProfitRate(results, purchaseAmount);
        outputView.printProfitRate(profitRate);
    }
}
