# 로또 💰

## _**목표**_

**간단한 로또 발매기를 구현한다.**

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

## 기능 목록 📋

* 메인 클래스
* 입력 클래스
    + 구입금액 입력 메서드
        - n개를 구매했습니다.
    + 당첨번호 입력 메서드
        - 당첨 번호를 입력해 주세요.
    + 보너스 번호 입력 메서드
        - 보너스 번호를 입력해 주세요.
* 출력 클래스
    + 구입로또 출력 메서드
        - n개 구매했습니다.
        - [n, n, n, n, n, n]
    + 당첨 통계 출력 메서드
        - n개 일치 (n,nnn,nnn,nnn원) - n개
        - 총 수익률은 nn.n%입니다.(소수점 둘째 자리 반올림)
* 예외처리 클래스
    + 입력 예외 메서드
        - [ERROR] 로 시작하는 메시지 출력 후 재입력


## 예외 처리 목록 ✅
* 올바르지 않은 구입 금액 입력
    + !(n % 1000 == 0)
    + (n < 1000)
* 올바르지 않은 당첨 번호 입력
    + !(n > 0 && n < 46)
    + 당첨 번호가 6개 미만, 7개 이상인 경우
* 올바르지 않은 보너스 번호 입력
    + !(n > 0 && n < 46)
    + 1개가 아닌 경우
* 숫자가 아닌 입력 

### 라이브러리 🦾
* camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다. 
* Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용한다. 
* 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
#### 사용 예시
* 1에서 45 사이의 중복되지 않은 정수 6개 반환
```
Randoms.pickUniqueNumbersInRange(1, 45, 6);
```
### Lotto 클래스
+ 제공된 Lotto 클래스를 사용하여 구현해야 한다.
+ Lotto에 numbers 이외의 필드(인스턴스 변수)를 추가할 수 없다.
+ numbers의 접근 제어자인 private은 변경할 수 없다.
+ Lotto의 패키지를 변경할 수 있다.
```Lotto
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
```
