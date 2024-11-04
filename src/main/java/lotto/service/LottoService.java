package lotto.service;

import static lotto.enums.Symbol.COMMA;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.enums.Prize;

public class LottoService {

    public List<Lotto> generateLotto(String purchaseAmount) {
        int lottoCount = Integer.parseInt(purchaseAmount) / 1000;

        return IntStream.range(0, lottoCount)
                .mapToObj(count -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .toList();
    }

    public Map<Prize, Integer> determineFinalResults(String finalResults, String bonusNumber, List<Lotto> lottos) {
        List<Integer> parsedWinningNumbers = parseNumbers(finalResults);
        int parsedBonusNumber = Integer.parseInt(bonusNumber.trim());

        Map<Prize, Integer> matchCounts = initializeMatchCounts();

        lottos.forEach(lotto -> {
            int matchCount = lotto.countLottoNumbers(parsedWinningNumbers);
            boolean isBonusMatch = lotto.containsBonusNumber(parsedBonusNumber);
            updateMatchCounts(matchCounts, matchCount, isBonusMatch);
        });

        return matchCounts;
    }



    private List<Integer> parseNumbers(String numbers) {
        return Arrays.stream(numbers.split(COMMA.getValue()))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    private Map<Prize, Integer> initializeMatchCounts() {
        Map<Prize, Integer> matchCounts = new EnumMap<>(Prize.class);
        Arrays.stream(Prize.values()).forEach(prize -> matchCounts.put(prize, 0));
        return matchCounts;
    }

    private void updateMatchCounts(Map<Prize, Integer> matchCounts, int matchCount, boolean isBonusRound) {
        Prize prize = determinePrize(matchCount, isBonusRound);
        if (prize != null) {
            matchCounts.merge(prize, 1, Integer::sum);
        }
    }

    private Prize determinePrize(int matchCount, boolean isBonusRound) {
        if (matchCount == 5 && isBonusRound) {
            return Prize.FIVE_BONUS_MATCH;
        }
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.getMatchCount() == matchCount)
                .findFirst()
                .orElse(null);
    }
}
