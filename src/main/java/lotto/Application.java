package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
* feat: 로또 발행 기능 추가
- 로또 번호를 무작위로 생성하는 기능 구현

* feat: 입력값 검증 및 IllegalArgumentException 처리 추가

- 잘못된 값 입력 시 IllegalArgumentException 발생
- [ERROR]로 시작하는 에러 메시지 출력

* test: 로또 번호 발행 및 예외 처리 테스트 코드 추가

- 1~45 사이의 중복되지 않는 6개의 숫자로 구성된 로또 번호 발행 기능 테스트
- 잘못된 값 입력 시 IllegalArgumentException 발생 여부 테스트
- [ERROR]로 시작하는 에러 메시지 출력 확인 테스트

docs: Add README.md file with project description

for (Integer number : numbers) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
        throw new IllegalArgumentException("[ERROR] 로또 번호는 " + MIN_NUMBER + "부터 " + MAX_NUMBER + " 사이의 숫자여야 합니다.");
            }
                    }
                    if (numbers.stream().distinct().count() != LOTTO_SIZE) {
        throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
public static Lotto generateRandomLotto() {
    List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
    Collections.sort(randomNumbers);
    return new Lotto(randomNumbers);
}

public List<Integer> getNumbers() {
    return numbers;
}