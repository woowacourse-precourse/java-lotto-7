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
import java.util.Map;
import java.util.function.Supplier;

public class LottoApplicationServiceImpl implements LottoApplicationService {
    private static final int FULL_MATCH_COUNT = 6;
    private static final int FIVE_MATCH_COUNT = 5;
    private static final int FOUR_MATCH_COUNT = 4;
    private static final int THREE_MATCH_COUNT = 3;
    private static final double PERCENTAGE_MULTIPLIER = 100.0;
    private static final String NUMERIC_REGEX = "\\d+";

    @Override
    public boolean validateAmount(String input) {
        checkNotBlank(input);
        checkNumeric(input);
        int amount = parseAmount(input);
        checkPositiveAmount(amount);
        checkDivisibleByLottoPrice(amount);
        return true;
    }

    private void checkNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(LottoErrorMessages.INVALID_AMOUNT_NON_EMPTY.getMessage());
        }
    }

    private void checkNumeric(String input) {
        if (!input.matches(NUMERIC_REGEX)) {
            throw new IllegalArgumentException(LottoErrorMessages.INVALID_AMOUNT_NON_NUMERIC.getMessage());
        }
    }

    private int parseAmount(String input) {
        return Integer.parseInt(input);
    }

    private void checkPositiveAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(LottoErrorMessages.INVALID_AMOUNT_NON_POSITIVE.getMessage());
        }
    }

    private void checkDivisibleByLottoPrice(int amount) {
        if (amount % GlobalConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LottoErrorMessages.INVALID_AMOUNT_NOT_DIVISIBLE_BY_1000.getMessage());
        }
    }

    @Override
    public WinningResult result(List<Lotto> lottos, WinningContext context) {
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
        Map<Integer, Supplier<Rank>> rankMap = Map.of(
                FULL_MATCH_COUNT, () -> Rank.FIRST,
                FIVE_MATCH_COUNT, () -> hasBonusNumber(lotto, context.getBonusNumber()) ? Rank.SECOND : Rank.THIRD,
                FOUR_MATCH_COUNT, () -> Rank.FOURTH,
                THREE_MATCH_COUNT, () -> Rank.FIFTH
        );

        return rankMap.getOrDefault(getMatchCount(lotto, context), () -> Rank.NO_WIN).get();
    }

    private int getMatchCount(Lotto lotto, WinningContext context) {
        return (int) lotto.getNumbers().stream()
                .filter(context.getWinningNumbers().getNumbers()::contains)
                .count();
    }

    private boolean hasBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber.getNumber());
    }

}