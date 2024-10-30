package lotto.domain;

import lotto.domain.enums.LottoRank;
import lotto.domain.generator.RandomNumber;
import lotto.domain.generator.RandomNumbers;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (isDuplicateNumber(numbers, numberSet)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 값을 가질 수 없습니다.");
        }
    }

    private boolean isDuplicateNumber(List<Integer> numbers, HashSet<Integer> numberSet) {
        return numberSet.size() != numbers.size();
    }

    public EnumMap<LottoRank, Integer> checkWinning(RandomNumbers randomNumbers, int bonusNumber) {

        EnumMap<LottoRank, Integer> rankCount = new EnumMap<>(LottoRank.class);
        initRankCount(rankCount);
        List<RandomNumber> totalRandomNumberList = randomNumbers.randomNumbers();

        for (RandomNumber randomNumberList : totalRandomNumberList) {
            List<Integer> randomNumber = randomNumberList.randomNumber();

            LottoRank lottoRank = getLottoRank(randomNumber, bonusNumber);
            rankCount.put(lottoRank, rankCount.getOrDefault(lottoRank, 0) + 1);
        }
        return rankCount;
    }

    private void initRankCount(EnumMap<LottoRank, Integer> rankCount) {
        for (LottoRank lottoRank : LottoRank.values()) {
            rankCount.put(lottoRank, 0);
        }
    }

    private LottoRank getLottoRank(List<Integer> randomNumber, int bonusNumber) {
        int count = calculateMatchCount(randomNumber);
        boolean isBonusNumberMatched = randomNumber.contains(bonusNumber);

        return LottoRank.findLottoRank(count, isBonusNumberMatched);
    }

    private int calculateMatchCount(List<Integer> randomNumber) {
        return Math.toIntExact(
                randomNumber.stream()
                .filter(numbers::contains)
                .count()
        );
    }
}
