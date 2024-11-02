package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoManager {

  private static final int DEFAULT_LOTTO_SIZE = 6;
  private static final int MIN_LOTTO_NUMBER = 1;
  private static final int MAX_LOTTO_NUMBER = 45;
  private static final int DEFAULT_LOTTO_PRICE = 1000;

  private final int price;

  public LottoManager(int price) {
    validatePrice(price);
    validateDivisiblePrice(price);
    this.price = price;
  }

  private void validatePrice(int price) {
    if (price < DEFAULT_LOTTO_PRICE) {
      throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1000원 이상이어야 합니다.");
    }
  }

  private void validateDivisiblePrice(int price) {
    if (price % DEFAULT_LOTTO_PRICE != 0) {
      throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1000원 단위로만 가능합니다.");
    }
  }

  public Lottos generateLottos() {
    List<Lotto> lottos = new ArrayList<>();
    for (int i = 0; i < calculateLottoCount(); i++) {
      lottos.add(generateSingleLotto());
    }
    return new Lottos(lottos);
  }

  private Lotto generateSingleLotto() {
    return new Lotto(provideSortedNumbers());
  }

  private List<Integer> provideSortedNumbers() {
    List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, DEFAULT_LOTTO_SIZE));
    randomNumbers.sort(Comparator.comparingInt(o -> o));
    return randomNumbers;
  }

  private int calculateLottoCount() {
    return price / DEFAULT_LOTTO_PRICE;
  }

  public int getPrice() {
    return price;
  }
}
