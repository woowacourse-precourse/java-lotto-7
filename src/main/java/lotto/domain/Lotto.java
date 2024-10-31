package lotto.domain;

import lotto.domain.enums.LottoRank;
import lotto.domain.generator.RandomNumber;
import lotto.domain.generator.RandomNumbers;

import java.util.*;

import static lotto.exception.ErrorCode.DUPLICATE_LOTTO_NUMBER;
import static lotto.exception.ErrorCode.INVALID_LOTTO_NUMBER_COUNT;

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
        if (numbers.size() != 6) { // TODO 하드코딩 제거
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if (isDuplicateNumber(numbers, numberSet)) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
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
            rankCount.put(lottoRank, rankCount.getOrDefault(lottoRank, 0) + 1); // TODO 하드코딩 제거
        }
        return rankCount;
    }

    private void initRankCount(EnumMap<LottoRank, Integer> rankCount) {
        for (LottoRank lottoRank : LottoRank.values()) {
            rankCount.put(lottoRank, 0); // TODO 하드코딩 제거
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
