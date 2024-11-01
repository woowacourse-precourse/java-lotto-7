package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;
import camp.nextstep.edu.missionutils.Randoms;

// User의 로또 리스트를 저장하는 클래스
public class UserLotto {
    private int numberOfLottos;
    private final List<Lotto> userLotto;

    public UserLotto(int numberOfLottos) {
        this.numberOfLottos = numberOfLottos;
        userLotto = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            userLotto.add(lotto);
        }
    }

    public int getNumberOfLotto() {
        return numberOfLottos;
    }

    public List<Lotto> getUserLotto() {
        return userLotto;
    }
}
