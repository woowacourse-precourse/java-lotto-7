package lotto.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoWinnings {
    private final List<Integer> lottoNum;
    private final int bonusNum;
    private final List<List<Integer>> publicationNumbers;

    public LottoWinnings(List<Integer> lottoNum, int bonusNum, List<List<Integer>> publicationNumbers) {
        this.lottoNum = lottoNum;
        this.bonusNum = bonusNum;
        this.publicationNumbers = publicationNumbers;
    }

    private int findLottoRank(long matchingCount) {
        boolean hasBonusMatch = lottoNum.contains(bonusNum);

        if (matchingCount == 6) {
            return 1;
        }
        if (matchingCount == 5 && hasBonusMatch) {
            return 2;
        }
        if (matchingCount == 5) {
            return 3;
        }
        if (matchingCount == 4) {
            return 4;
        }
        if (matchingCount == 3) {
            return 5;
        }

        return 0;
    }

    public List<Integer> findMatchNumber() {
        List<Integer> duplicateCountList = new ArrayList<>();
        Set<Integer> set = new HashSet<>(lottoNum);

        for (List<Integer> numbers : publicationNumbers) {
            long duplicateCount = numbers.stream()
                    .filter(set::contains)
                    .count();

            duplicateCountList.add(findLottoRank(duplicateCount));
        }

        return duplicateCountList;
    }

    public List<Integer> findMatchNumberCount() {
        List<Integer> duplicateCountList = findMatchNumber();
        List<Integer> result = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));

        for (int number : duplicateCountList) {
            result.set(number, result.get(number) + 1);
        }

        return result;
    }
}
