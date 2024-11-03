package lotto.utilities;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constants.RandomNumberConstants;

public class Random {
  private static final int QUANTITY_OF_NUMBERS = 6;

  public static List<Integer> lottoGenerator() {
    List<Integer> randomNumber =
        Randoms.pickUniqueNumbersInRange(
            RandomNumberConstants.MINIMUM_RANDOM_NUMBER,
            RandomNumberConstants.MAXIMUM_RANDOM_NUMBER,
            QUANTITY_OF_NUMBERS);
    return randomNumber;
  }
}
