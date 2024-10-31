package lotto.domain;

import static lotto.domain.MAGIC_NUMBER.SIZE;
import static lotto.domain.MAGIC_NUMBER.START;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.view.Input;

public class Handler {

  private int generateRequest;
  private Lotto lotto;

  public Handler(int request) {

    this.generateRequest = request;
  }

  // 1~45 범위 정수 6개가 담긴 로또를 요청 수만큼 발행하여 전달한다
  public List<Integer> generateLotto(int request) {
    List<Integer> numbers = new ArrayList<>();
    int random = Randoms.pickNumberInRange(1, 45);
    for (int i = START.getMagicNumber(); i < SIZE.getMagicNumber(); i++) {
      numbers.add(random);
    }
    return numbers;
  }

  // 5. 내부적으로 구매 금액만큼의 로또를 발행하여 당첨 번호와 보너스 번호를 적절히 비교 하고

  // 6. 비교한 결과를 토대로 총 수익률 계산
}
