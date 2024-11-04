package lotto.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBall;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.lotto.PurchaseAmount;
import lotto.domain.winning.LottoRank;
import lotto.domain.winning.WinningDraw;
import lotto.domain.winning.WinningStatistics;
import lotto.service.dto.LottoPurchaseResponse;
import lotto.service.dto.WinningDrawResponse;
import lotto.service.dto.WinningResult;

public class LottoWinningService {

    private final LottoTickets lottoTickets = new LottoTickets();
    private Lotto winningLotto;
    private LottoBall bonusBall;

    public LottoPurchaseResponse buyAutoLotto(final long purchaseAmountInput) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(purchaseAmountInput);
        saveAllLottoTicket(purchaseAmount);

        List<Lotto> tickets = lottoTickets.findAll();
        return toLottoPurchaseResponse(tickets);
    }

    public void saveWinningLotto(final String winningNumbers) {
        this.winningLotto = createWinningLotto(winningNumbers);
    }

    public void saveBonusNumber(final int bonusNumber) {
        LottoBall bonusBall = LottoBall.draw(bonusNumber);
        WinningDraw.validateBonusNumberDuplication(winningLotto, bonusBall);
        this.bonusBall = bonusBall;
    }

    public WinningDrawResponse startDrawWinning() {
        WinningDraw winningDraw = WinningDraw.draw(winningLotto, bonusBall);
        return calculateWinningStatistics(winningDraw);
    }

    private void saveAllLottoTicket(final PurchaseAmount purchaseAmount) {
        for (long count = 1L; count <= purchaseAmount.getCountOfTicket(); count++) {
            NumbersCreator randomNumbersCreator = new RandomNumbersCreator();
            List<Integer> randomNumbers = randomNumbersCreator.create();
            lottoTickets.save(Lotto.issue(randomNumbers));
        }
    }

    private Lotto createWinningLotto(final String winningNumbersInput) {
        NumbersCreator inputSplitNumbersCreator = new InputSplitNumbersCreator(winningNumbersInput);
        List<Integer> winningNumbers = inputSplitNumbersCreator.create();
        return Lotto.issue(winningNumbers);
    }

    private WinningDrawResponse calculateWinningStatistics(final WinningDraw winningDraw) {
        WinningStatistics winningStatistics = WinningStatistics.create();
        List<Lotto> tickets = lottoTickets.findAll();
        for (Lotto lotto : tickets) {
            LottoRank rank = winningDraw.compareWithWinningLotto(lotto);
            winningStatistics.save(rank);
        }
        return toWinningDrawResponse(winningStatistics, tickets.size() * 1000L);
    }

    private LottoPurchaseResponse toLottoPurchaseResponse(final List<Lotto> tickets) {
        List<List<String>> lottoNumbers = new ArrayList<>();
        for (Lotto ticket : tickets) {
            lottoNumbers.add(ticket.numbers()
                    .stream()
                    .map(String::valueOf)
                    .toList()
            );
        }
        return new LottoPurchaseResponse(tickets.size(), lottoNumbers);
    }

    private WinningDrawResponse toWinningDrawResponse(
            final WinningStatistics winningStatistics,
            final long totalAmount
    ) {
        Map<WinningResult, Long> winningResultStatistics = createWinningResultStatistics(winningStatistics);
        BigDecimal returnOnInvestment = winningStatistics.calculateReturnOnInvestment(totalAmount);
        return new WinningDrawResponse(winningResultStatistics, returnOnInvestment);
    }

    private Map<WinningResult, Long> createWinningResultStatistics(final WinningStatistics winningStatistics) {
        LinkedHashMap<WinningResult, Long> winningResultStatistics = new LinkedHashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank == LottoRank.NONE) {
                continue;
            }
            long winningCount = winningStatistics.getWinningCount(lottoRank);
            WinningResult winningResult = createWinningResult(lottoRank);
            winningResultStatistics.put(winningResult, winningCount);
        }
        return winningResultStatistics;
    }

    private WinningResult createWinningResult(final LottoRank lottoRank) {
        return new WinningResult(
                lottoRank.matchingCount(),
                lottoRank.winningMoney(),
                lottoRank.hasBonusNumber()
        );
    }

}
