package lotto.model.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
// 로또 번호를 랜덤으로 뽑아서 로또를 생성하는 객체
public class LottoGenerator {
    // 리펙토링 사항 발견 -> 상수 처리 추가 진행해야함
    // 랜덤으로 로또 생성하는 방법 말고 수동으로 로또를 생성해야 하는 경우는 어떻게 할까?
    // Lotto가 생성자에서 List<Number>를 받기 때문에 로또를 수동으로 생성하는 경우 로또 번호를 입력받고 주입만 해주면 된다.
    // 그럼 아래 로또를 랜덤으로 생성하는 기능을 제공하는 LottoGenerator의 이름이 적절할까? 그냥 단순히 번호만 랜덤으로 뽑아서
    // 이를 전달해주는 거면 RandomNumberGenerator 는 어떨까....?
    // 아님 전략 패턴을 이용해서 로또 생성 전략을 수동과 랜덤으로 제공하고 이를 LottoTiketGenertor가 사용하게 하는 방법은 어떨까..!
    // 지금 당첨 번호를 입력 받고 승리 로또를 생성하는 쪽이 수동 로또를 입력 받아 수동로또를 생성한느 로직과 동일
    // 지금은 승리 로또 쪽에사 입력 값에 대한 분리 및 검증을 진행하는데 이를 수동 로또 전략이 맡아 검증하고 번호를 반환하게 하는건 어떨까?
    // 승리 로또 쪽 리펙토링 해봐야겠다..
    public Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

}
