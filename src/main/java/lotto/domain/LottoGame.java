package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.validation.Validation;

public class LottoGame {
    private final int initialMoney;
    private final int lottoCount;
    private final List<Lotto> purchasedLottos;
    private Lotto winningLotto;
    private int bonusNumber;
    private final int INITIALIZAIONNUMBER = -1;
    private final int NUMBER_ZERO = 0;
    private final int NUMBER_ONE = 1;
    private final int COUNT_NUMBER = 6;
    private final int END_RANDOM_NUMBER = 45;
    private final int DIVISION_NUMBER = 1000;
    private final int ONE_HUNDRED = 100;

    public LottoGame(int initialMoney) {
        Validation.checkPositive(initialMoney);
        Validation.checkDivisibleBy1000(initialMoney);
        this.initialMoney = initialMoney;
        this.lottoCount = initialMoney / DIVISION_NUMBER;
        this.purchasedLottos = generateLottos(lottoCount);
        this.winningLotto = null;
        this.bonusNumber = INITIALIZAIONNUMBER;
    }

    public Map<MatchResult, Integer> getMatchResults() {
        Map<MatchResult, Integer> matchCounts = new EnumMap<>(MatchResult.class);
        Arrays.stream(MatchResult.values())
                .forEach(result -> matchCounts.put(result, 0));
        purchasedLottos.forEach(lotto -> {
            MatchResult matchResult = MatchResult.from(lotto.getMatchCount(winningLotto), lotto.contains(bonusNumber));
            matchCounts.merge(matchResult, NUMBER_ONE, Integer::sum);
        });
        return matchCounts;
    }


    public int getLottoCount() {
        return lottoCount;
    }

    public double calculateProfitRate() {
        int totalPrize = purchasedLottos.stream()
                .mapToInt(this::calculatePrizeForLotto)
                .sum();

        return (double) totalPrize / initialMoney * ONE_HUNDRED;
    }

    public void setWinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void setBonusNumber(int bonusNumber) {
        Validation.checkLottoNumberRange(bonusNumber);
        Validation.checkBonusNumberUnique(winningLotto.getNumbers(), bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    private int calculatePrizeForLotto(Lotto lotto) {
        int matchCount = lotto.getMatchCount(winningLotto);
        boolean hasBonus = lotto.contains(bonusNumber);
        return MatchResult.from(matchCount, hasBonus).getPrize();
    }


    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(NUMBER_ONE, END_RANDOM_NUMBER, COUNT_NUMBER);
    }

    private List<Lotto> generateLottos(int count) {
        return IntStream.range(NUMBER_ZERO, count)
                .mapToObj(i -> new Lotto(generateLottoNumbers()))
                .collect(Collectors.toList());
    }
}
