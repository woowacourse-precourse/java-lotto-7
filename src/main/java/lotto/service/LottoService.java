package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.util.WinnigResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoService {
    static final int LOTTO_PRICE = 1000;
    private final List<Lotto> purchasedLottos = new ArrayList<>();

    public List<Lotto> buyLotto(int money) {
        validatePurchaseAmount(money);
        int lottoCount = money / LOTTO_PRICE;

        for (int i = 0; i < lottoCount; i++) {
            purchasedLottos.add(generateLotto());
        }
        return purchasedLottos;
    }

    private void validatePurchaseAmount(int money) {
        if (money % LOTTO_PRICE != 0) {
            int remainder = money % LOTTO_PRICE;
            int neededMoney = LOTTO_PRICE - remainder;
            throw new IllegalArgumentException(
                    String.format("[ERROR] %d원으로는 구매가 불가능합니다. %d원 더 채워주세요", remainder, neededMoney)
            );
        }
    }

    //당첨번호
    public Lotto parseWinnigNumbers(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new Lotto(numbers);
    }

    public Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public WinnigResult checkWinningResults(Lotto winningLotto, int bonusNumber) {
        Map<LottoRank, Long> ranckCounts = purchasedLottos.stream()
                .map(lotto -> calculateRank(lotto,winningLotto,bonusNumber))
                .collect(Collectors.groupingBy(rank -> rank,Collectors.counting()));

        long totalPrize = calculateToalPrize(ranckCounts);
        double returnRate = calculateReturnRate(totalPrize,purchasedLottos.size());

        return new WinnigResult(ranckCounts, returnRate);
    }

    private LottoRank calculateRank(Lotto userLotto, Lotto winningLotto, int bonusNumber) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        List<Integer> userNumbers = userLotto.getNumbers();

        long matchCount = userNumbers.stream()
                .filter(winningNumbers::contains)
                .count();

        boolean hasBonusMatched = userNumbers.contains(bonusNumber);

        return LottoRank.of((int) matchCount, hasBonusMatched);
    }

    private long calculateToalPrize(Map<LottoRank, Long> rankCounts) {
        return rankCounts.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private double calculateReturnRate(long totalPrize, int lottoCount) {
        return Math.round((totalPrize * 100.0) / (lottoCount * LOTTO_PRICE)) / 100.0;
    }
}
