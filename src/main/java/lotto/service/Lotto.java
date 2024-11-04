package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {

  private final List<Integer> numbers;

  // 생성자를 통해 번호 생성 및 초기화
  public Lotto() {
    this.numbers = createNumbers();
  }


  // 1~45 사이의 중복 없는 숫자 6개 생성
  private List<Integer> createNumbers() {
    List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    validate(lottoNumbers);
    return lottoNumbers;
  }

  // 번호 유효성 검사
  private void validate(List<Integer> numbers) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
    }
  }

  // 번호를 외부에 제공하는 메서드
  public List<Integer> getNumbers() {
    return this.numbers;
  }
}
