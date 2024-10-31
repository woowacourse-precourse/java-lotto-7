package lotto.utilities;

import java.util.Collections;
import java.util.List;

public class Sorter {
  public static List<Integer> inAscendingOrder(List<Integer> listOfLottoNumbers) {
    Collections.sort(listOfLottoNumbers);
    return listOfLottoNumbers;
  }
}
