package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class IssuedLotto {
    public static int LOTTO_NUMBER_RANGE_MIN = 1;
    public static int LOTTO_NUMBER_RANGE_MAX = 45;
    public static int NUMBER_OF_LOTTO_ISSUED = 6;

    public List<List<Integer>> lottoIssues(int numberOfLottoes) {
        List<List<Integer>> issuedLottoNumbers = new ArrayList<>();

        for (int i = 0; i < numberOfLottoes; i++) {
            List<Integer> randomLottoNum = generateRandomLottoNum();
            Collections.sort(randomLottoNum);
            issuedLottoNumbers.add(randomLottoNum);
        }
        return issuedLottoNumbers;
    }

    public List<Integer> generateRandomLottoNum() {
        Set<Integer> randomLottoNumSet = new HashSet<>();

        while (randomLottoNumSet.size() < NUMBER_OF_LOTTO_ISSUED) {
            randomLottoNumSet.add(Randoms.pickNumberInRange(LOTTO_NUMBER_RANGE_MIN, LOTTO_NUMBER_RANGE_MAX));
        }
        return new ArrayList<>(randomLottoNumSet);
    }
}
