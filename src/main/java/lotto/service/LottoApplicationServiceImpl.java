package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.constant.GlobalConstants;
import lotto.domain.model.bonus.BonusNumber;
import lotto.domain.model.lotto.Lotto;
import lotto.domain.model.winning.WinningContext;
import lotto.domain.model.winning.Rank;
import lotto.domain.model.winning.WinningResult;
import lotto.exception.lotto.LottoErrorMessages;

import java.util.ArrayList;
import java.util.List;

public class LottoApplicationServiceImpl implements LottoApplicationService {
    private static final int FULL_MATCH_COUNT = 6;
    private static final int FIVE_MATCH_COUNT = 5;
    private static final int FOUR_MATCH_COUNT = 4;
    private static final int THREE_MATCH_COUNT = 3;
    private static final double PERCENTAGE_MULTIPLIER = 100.0;
    private static final String NUMERIC_REGEX = "\\d+";

    @Override
    public boolean validateAmount(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(LottoErrorMessages.INVALID_AMOUNT_NON_EMPTY.getMessage());
        }

        if (!input.matches(NUMERIC_REGEX)) {
            throw new IllegalArgumentException(LottoErrorMessages.INVALID_AMOUNT_NON_NUMERIC.getMessage());
        }

        int amount = Integer.parseInt(input);
        if (amount <= 0) {
            throw new IllegalArgumentException(LottoErrorMessages.INVALID_AMOUNT_NON_POSITIVE.getMessage());
        }

        if (amount % GlobalConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LottoErrorMessages.INVALID_AMOUNT_NOT_DIVISIBLE_BY_1000.getMessage());
        }

        return true;
    }

    @Override
    public WinningResult checkResult(List<Lotto> lottos, WinningContext context) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Rank rank = determineRank(lotto, context);
            ranks.add(rank);
        }
        return new WinningResult(ranks);
    }

    @Override
    public double calculateEarningsRate(int totalPrize, int amount) {
        double rate = ((double) totalPrize / amount) * PERCENTAGE_MULTIPLIER;
        return Math.round(rate * PERCENTAGE_MULTIPLIER) / PERCENTAGE_MULTIPLIER;
    }

    @Override
    public List<Lotto> generateLottos(int amount) {
        int count = amount / GlobalConstants.LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(generateRandomLotto());
        }

        return lottos;
    }

    private Lotto generateRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(GlobalConstants.MIN_LOTTO_NUMBER, GlobalConstants.MAX_LOTTO_NUMBER, GlobalConstants.LOTTO_NUMBER_COUNT);
        return new Lotto(randomNumbers);
    }

    private Rank determineRank(Lotto lotto, WinningContext context) {
        int matchCount = getMatchCount(lotto, context);
        boolean hasBonus = hasBonusNumber(lotto, context.getBonusNumber());

        if (matchCount == FULL_MATCH_COUNT) {
            return Rank.FIRST;
        }
        if (isSecondPlace(matchCount, hasBonus)) {
            return Rank.SECOND;
        }
        if (matchCount == FIVE_MATCH_COUNT) {
            return Rank.THIRD;
        }
        if (matchCount == FOUR_MATCH_COUNT) {
            return Rank.FOURTH;
        }
        if (matchCount == THREE_MATCH_COUNT) {
            return Rank.FIFTH;
        }
        return Rank.NO_WIN;
    }

    private int getMatchCount(Lotto lotto, WinningContext context) {
        return (int) lotto.getNumbers().stream()
                .filter(context.getWinningNumbers().getNumbers()::contains)
                .count();
    }

    private boolean hasBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber.getNumber());
    }

    private boolean isSecondPlace(int matchCount, boolean hasBonus) {
        return matchCount == FIVE_MATCH_COUNT && hasBonus;
    }
}