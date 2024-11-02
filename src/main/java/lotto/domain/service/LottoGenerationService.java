package lotto.domain.service;

import lotto.domain.model.Lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;


//로또 티켓을 생성하는 클래스
public class LottoGenerationService {
    public Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
