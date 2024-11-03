package lotto.model;

import java.util.HashMap;
import java.util.List;
import lotto.dto.LottoStatus;
import lotto.dto.LottoTicketStatus;
import lotto.dto.WinningStatistics;

public class LottoCalculator {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoCalculator(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public WinningStatistics getWinningStatistics(LottoTicket lottoTicket) {
        HashMap<Rank, Integer> lottoResult = getLottoResult(lottoTicket);
        double earningRate = calculateEarningRate(lottoResult, lottoTicket);

        return new WinningStatistics(lottoResult, earningRate);
    }

    private HashMap<Rank, Integer> getLottoResult(LottoTicket lottoTicket) {
        HashMap<Rank, Integer> lottoResult = initLottoResult();

        LottoTicketStatus lottoTicketStatus = lottoTicket.getLottoTicketStatus();
        List<LottoStatus> lottoStatuses = lottoTicketStatus.getLottoStatuses();

        for (LottoStatus lottoStatus : lottoStatuses) {
            Rank rank = getRank(lottoStatus);
            lottoResult.put(rank, lottoResult.get(rank) + 1);
        }

        return lottoResult;
    }

    private HashMap<Rank, Integer> initLottoResult() {
        HashMap<Rank, Integer> lottoResult = new HashMap<>();

        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            lottoResult.put(rank, 0);
        }

        return lottoResult;
    }

    private Rank getRank(LottoStatus lottoStatus) {
        List<Integer> numbers = lottoStatus.getNumbers();
        int correctNumberCount = getCorrectNumberCount(numbers);
        boolean containBonusNumber = containBonusNumber(numbers);

        return Rank.determineRank(correctNumberCount, containBonusNumber);
    }

    private int getCorrectNumberCount(List<Integer> numbers) {
        int correctNumberCount = 0;
        LottoStatus winningLottoStatus = winningLotto.getStatus();
        List<Integer> winningNumbers = winningLottoStatus.getNumbers();

        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                correctNumberCount++;
            }
        }
        return correctNumberCount;
    }

    private boolean containBonusNumber(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }

    private double calculateEarningRate(HashMap<Rank, Integer> lottoResult, LottoTicket lottoTicket) {
        long totalPrize = 0;

        LottoTicketStatus lottoTicketStatus = lottoTicket.getLottoTicketStatus();
        int purchaseAmount = lottoTicketStatus.getPurchaseAmount();

        for (Rank rank : lottoResult.keySet()) {
            long prize = rank.getPrize();
            long count = lottoResult.get(rank);
            totalPrize += prize * count;
        }

        double earningRate = (double) totalPrize / purchaseAmount * 100;
        return (double) Math.round(earningRate * 10) / 10;
    }
}
