package lotto.util.generator;

import camp.nextstep.edu.missionutils.Randoms;

import lotto.Lotto;

import java.util.List;

public final class LottoGenerator {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int NUMBERS_SIZE = 6;

    private LottoGenerator() {
    }

    public static Lotto generateLotto(List<Integer> numbers) {
        List<Integer> lottoNumbers = numbers.stream().sorted().toList();
        return new Lotto(lottoNumbers);
    }

    public static Lotto generateAutoLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBERS_SIZE);
        List<Integer> lottoNumbers = numbers.stream().sorted().toList();
        return new Lotto(lottoNumbers);
    }

}
