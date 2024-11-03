package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

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
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또는 중복된 숫자를 가질 수 없습니다.");
        }
    }

    public int matchLotto(List<Integer> winningNumbers) {
        boolean bonusFlag = numbers.contains(winningNumbers.get(6));
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (numbers.contains(winningNumbers.get(i))) {
                count += 1;
            }
        }
        if (count == 6) {
            return 1;
        } else if (bonusFlag && count == 5) {
            return 2;
        }
        return 8 - count;
    }

    public static List<Lotto> issueLottoList(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(Lotto.issueLotto());
        }

        return lottoList;
    }

    public static Lotto issueLotto() {
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(integers);
    }

    public void printNumbers() {
        System.out.println(numbers);
    }
}
