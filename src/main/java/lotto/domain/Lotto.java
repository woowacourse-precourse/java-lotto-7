package lotto.domain;

import lotto.domain.enums.LottoRank;
import lotto.exception.custom.DuplicateLottoNumber;
import lotto.exception.custom.InvalidLottoNumberCount;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;

import static lotto.common.Lotto.LOTTO_NUMBER_SIZE;
import static lotto.common.Number.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberSize(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new InvalidLottoNumberCount();
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (isDuplicateNumber(numbers, numberSet)) {
            throw new DuplicateLottoNumber();
        }
    }

    private boolean isDuplicateNumber(List<Integer> numbers, HashSet<Integer> numberSet) {
        return numberSet.size() != numbers.size();
    }

    public EnumMap<LottoRank, Integer> checkWinning(List<List<Integer>> randomNumbers, int bonusNumber) {
        EnumMap<LottoRank, Integer> rankCount = new EnumMap<>(LottoRank.class);
        initRankCount(rankCount);

        for (List<Integer> randomNumber : randomNumbers) {
            LottoRank lottoRank = getLottoRank(randomNumber, bonusNumber);
            rankCount.put(lottoRank, rankCount.getOrDefault(lottoRank, ZERO) + ONE);
        }
        return rankCount;
    }

    private void initRankCount(EnumMap<LottoRank, Integer> rankCount) {
        for (LottoRank lottoRank : LottoRank.values()) {
            rankCount.put(lottoRank, ZERO);
        }
    }

    private LottoRank getLottoRank(List<Integer> randomNumber, int bonusNumber) {
        int count = calculateMatchCount(randomNumber);
        return LottoRank.findLottoRank(count, randomNumber.contains(bonusNumber));
    }

    private int calculateMatchCount(List<Integer> randomNumber) {
        return Math.toIntExact(
                randomNumber.stream()
                .filter(numbers::contains)
                .count()
        );
    }
}
