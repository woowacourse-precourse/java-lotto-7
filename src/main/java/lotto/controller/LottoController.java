package lotto.controller;

import static lotto.constant.core.LottoControllerConstant.*;

import java.util.List;
import lotto.model.LottoService;
import lotto.model.Parser;
import lotto.model.Validator;
import lotto.model.RankCounter;
import lotto.model.domain.Lotto;
import lotto.model.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        Integer lottoPurchaseAmount = getLottoPurchaseAmount();
        List<Lotto> lottoTickets = getLottoTicketsDetails(lottoPurchaseAmount);
        List<Integer> winningNumbers = getWinningTicket();
        Integer bonusNumber = getBonusNumber(winningNumbers);
        RankCounter rankCounter = getWinningStatistics(winningNumbers, bonusNumber, lottoTickets);
        getEarningRate(rankCounter, lottoPurchaseAmount);
    }

    private static Integer getLottoPurchaseAmount() {
        String lottoPurchaseAmountInput = InputView.getLottoPurchaseAmountInput();
        Integer lottoPurchaseAmount = Parser.parseInputToInt(lottoPurchaseAmountInput);
        Validator.validateLottoPurchaseAmount(lottoPurchaseAmount);
        return lottoPurchaseAmount;
    }

    private List<Lotto> getLottoTicketsDetails(Integer lottoPurchaseAmount) {
        Integer lottoCount = lottoService.calculateLottoCount(lottoPurchaseAmount);
        OutputView.printLottoCount(lottoCount);
        List<Lotto> lottoTickets = lottoService.createLottoTickets(lottoCount);
        List<String> formattedLottoTickets = Parser.formatLottoTickets(
                lottoTickets, LOTTO_TICKETS_JOINER.getStringValue());
        OutputView.printLottoTicketsDetails(formattedLottoTickets);
        return lottoTickets;
    }

    private static List<Integer> getWinningTicket() {
        String winningTicketInput = InputView.getWinningTicketInput();
        List<Integer> winningTicket = Parser.parseInputsToIntList(winningTicketInput);
        Validator.validateWinningTicket(winningTicket);
        return winningTicket;
    }

    private static Integer getBonusNumber(List<Integer> winningTicket) {
        String bonusNumberInput = InputView.getBonusNumberInput();
        Integer bonusNumber = Parser.parseInputToInt(bonusNumberInput);
        Validator.validateBonusNumber(winningTicket, bonusNumber);
        return bonusNumber;
    }

    private RankCounter getWinningStatistics(List<Integer> winningNumbers, Integer bonusNumber, List<Lotto> lottoTickets) {
        WinningLotto winningLotto = lottoService.createWinningTicket(winningNumbers, bonusNumber);
        RankCounter rankCounter = lottoService.determineWinning(winningLotto, lottoTickets);
        OutputView.printWinningStatistics(rankCounter);
        return rankCounter;
    }

    private void getEarningRate(RankCounter rankCounter, Integer lottoPurchaseAmount) {
        Double earningRate = lottoService.calculateEarningRate(rankCounter, lottoPurchaseAmount);
        OutputView.printEarningsRate(earningRate);
    }
}
