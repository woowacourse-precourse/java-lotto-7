package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> lottoNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static List<Lotto> makeRandomLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            // 오름 차순 정렬기능 추가 예정
            lottos.add(new Lotto(randomNumbers));
        }
        return lottos;
    }
    // TODO: 추가 기능 구현
}
