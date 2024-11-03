package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        // 번호 범위
        for (Integer num : numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }

        // 중복 체크
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public static List<Lotto> start(Integer money) {
        List<Lotto> lottos = generateLottos(money);
        Print.printLottos(lottos);
        return lottos;
    }

    private static List<Lotto> generateLottos(int money) {
        int lottosNumber = money / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottosNumber; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6); // 1~45 범위의 유일한 번호 6개 선택
            lottos.add(new Lotto(numbers)); // Lotto 객체 생성 후 리스트에 추가
        }
        return lottos;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString(); // 로또 번호 리스트를 직접 문자열로 반환
    }
}
