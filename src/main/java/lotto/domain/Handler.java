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

  // 입력받은 당첨번호를 쉼표, 공백 구분자와 정수를 분리한다
  private List<Integer> generateWinning(String winning){
    List<Integer> winningNumbers = new ArrayList<>();
    // 당천 번호 입력 문자열을 읽으면
    for (int i = 0; i < winning.length(); i++) {
      // 쉼표와 공백 구분자를 제외하고 각 정수를 하나씩 리스트에 추가한다
//      winningNumbers.add(index);
    }
    return winningNumbers;
  }

  // 5. 내부적으로 구매 금액만큼의 로또를 발행하여 당첨 번호와 보너스 번호를 적절히 비교 하고
  private void compareNumbers(List<Integer> winningNumbers, int bonus) {

  }

  // 6. 비교한 결과를 토대로 총 수익률 계산한다
  // 형식) x개 일치 - y개,  수익률 z%
  private void calculateRevenue(List<Integer> bonusN) {

  }
}
