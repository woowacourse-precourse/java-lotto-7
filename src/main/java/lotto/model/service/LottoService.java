package lotto.model.service;

import java.util.HashSet;
import java.util.Set;
import lotto.model.domain.LottoConstant;
import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoWinningNumbers;

public class LottoService {
    private final LottoGenerator generator;

    public LottoService(LottoGenerator generator) {
        this.generator = generator;
    }

    public List<Lotto> createLottos(int purchaseAmount) {
        int count = calculateLottoCount(purchaseAmount);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generator.getLottoNumbers()));
        }
        return lottos;
    }

    public List<LottoPrize> drawWinners(List<Lotto> lottos, LottoWinningNumbers lottoWinningNumbers) {
        List<LottoPrize> winners = new ArrayList<>();

        Set<Integer> winningNumberSet = new HashSet<>(lottoWinningNumbers.getNumbers());

        for (Lotto lotto : lottos) {
            LottoPrize prize = getPrizeIfWinner(lotto, winningNumberSet, lottoWinningNumbers.getBonusNumber());
            if (prize != null) {
                winners.add(prize);
            }
        }
        return winners;
    }

    public double calculateProfitRatio(int purchaseAmount, List<LottoPrize> winners) {
        int totalAmount = winners.stream()
                .mapToInt(LottoPrize::getPrize)
                .sum();
        return calculatePercent(totalAmount, purchaseAmount);
    }


    private LottoPrize getPrizeIfWinner(Lotto lotto, Set<Integer> winningNumberSet, int bonusNumber) {
        Set<Integer> lottoNumberSet = new HashSet<>(lotto.getNumbers());
        boolean isBonusCorrect = lottoNumberSet.contains(bonusNumber);
        lottoNumberSet.retainAll(winningNumberSet);

        return LottoPrize.findBy(lottoNumberSet.size(), isBonusCorrect);
    }

    private double calculatePercent(int part, int whole) {
        double percent = ((double) part / (double) whole) * 100;
        return Math.round(percent * 10) / 10.0;
    }


    private int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LottoConstant.AMOUNT_UNIT;
    }
}
