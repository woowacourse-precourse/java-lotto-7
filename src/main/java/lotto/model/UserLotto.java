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

    // 입력된 숫자의 개수 만큼 랜덤의 로또 생성
    public UserLotto(int numberOfLottos) {
        this.numberOfLottos = numberOfLottos;
        userLotto = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> numbers = new ArrayList<>(randomNumbers);
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

    // 유저 로또 (index) 한 줄을 반환
    public List<Integer> getLottoAt(int index) {
        List<Integer> numbers;

        numbers = userLotto.get(index).getNumbers();
        return numbers;
    }
}
