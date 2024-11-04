package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumberGenerator {

  private static final int LOTTO_NUMBER_COUNT = 6;
  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 45;

  public static List<Integer> generateRandomNumbers() {
    return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_COUNT);
  }
}
