package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domains.Lotto;
import lotto.enums.LottoRank;

public class LottoService {
    private static final int LOTTO_COST = 1_000;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public int getLottoCost() {
        return LOTTO_COST;
    }

    public int issueLottoCount(int cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("[Error] 구입 금액은 0 이상의 정수이어야 합니다. 입력 값: " + cost);
        }
        if (cost % LOTTO_COST > 0) {
            throw new IllegalArgumentException("[Error] 구입 금액은 " + LOTTO_COST + "원 단위이어야 합니다. 입력 값: " + cost);
        }

        return cost / LOTTO_COST;
    }


    public List<Lotto> issueLotto(int cost) {
        int lottoCount = issueLottoCount(cost);
        List<Lotto> issueLottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            issueLottos.add(generateRandomLotto());
        }

        return issueLottos;
    }

    private Lotto generateRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                START_INCLUSIVE, END_INCLUSIVE, LOTTO_NUMBER_COUNT
        );

        return new Lotto(numbers);
    }

    public Lotto setWinningLotto(String inputValue) {
        return new Lotto(getNumbers(inputValue));
    }

    private List<Integer> getNumbers(String inputValue) {
        String delimiter = ",";
        Set<Integer> inputNumbers = new HashSet<>();
        String[] splitInputValue = inputValue.split(delimiter);
        for (String value: splitInputValue) {
            inputNumbers.add(convertStringToNumber(value));
        }

        if (inputNumbers.size() != 6) {
            throw new IllegalArgumentException("[Error] 중복되지 않은 입력 번호가 6개이어야 합니다. 입력된 번호 개수: " + inputNumbers.size());
        }

        List<Integer> numbers = new ArrayList<>(inputNumbers);
        Collections.sort(numbers);
        return numbers;
    }

    private int convertStringToNumber(String value) {
        try {
            int number = Integer.parseInt(value.strip());
            if (0 < number && number <= 45) {
                return number;
            }
            throw new IllegalArgumentException("[Error] 당첨 번호는 1 이상 45 이하의 번호만 가능합니다. 입력 번호: " + number);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("[Error] 번호가 아닌 값을 입력받았습니다. 입력 값: " + value);
        }
    }

    public long getWinningCost(int[] counts) {
        long cost = 0L;
        for (LottoRank rank : LottoRank.values()) {
            cost += (long)counts[rank.ordinal()] * rank.getGetPrize();
        }

        return cost;
    }

    public int[] getWinningCount(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        int[] counts = new int[LottoRank.values().length];

        for (Lotto issueLotto: lottos) {
            LottoRank rank = getLottoRank(issueLotto, winningLotto, bonusNumber);
            counts[rank.ordinal()]++;
        }

        return counts;
    }

    public LottoRank getLottoRank(Lotto issueLotto, Lotto winningLotto, int bonusNumber) {
        int matchCount = issueLotto.getCount(winningLotto);
        boolean existBonusNumber = issueLotto.existsNumber(bonusNumber);
        return getLottoRank(matchCount, existBonusNumber);
    }

    private LottoRank getLottoRank(int matchCount, boolean existBonusNumber) {
        if(matchCount == 5) {
            if (existBonusNumber) {
                return LottoRank.SECOND;
            }
            return LottoRank.THIRD;
        }

        for (LottoRank rank : LottoRank.values()) {
            if(matchCount == rank.getMatchCount()) {
                return rank;
            }
        }

        return LottoRank.NONE;
    }
}
