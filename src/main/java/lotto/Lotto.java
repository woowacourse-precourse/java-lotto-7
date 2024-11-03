package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> sortedNumbers = numbers.stream().sorted().toList();
        validate(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    public Lotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoInfo.startNumber, LottoInfo.endNumber, LottoInfo.count);
        this.numbers = numbers.stream().sorted().toList();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void printNumbers() {
        System.out.print("[");
        for (int i = 0; i < LottoInfo.count - 1; i++) {
            System.out.printf("%d, ", numbers.get(i));
        }
        System.out.printf("%d]\n", numbers.get(LottoInfo.count - 1));
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoInfo.count) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + LottoInfo.count + "개여야 합니다.");
        }
        for (int i = 0; i < LottoInfo.count; i++) {
            if (numbers.get(i) < LottoInfo.startNumber || numbers.get(i) > LottoInfo.endNumber) {
                throw new IllegalArgumentException(
                        "[ERROR] 로또 번호는 " + LottoInfo.startNumber + "~" + LottoInfo.endNumber + " 사이여야 합니다.");
            }
        }
        for (int i = 0; i < LottoInfo.count - 1; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
            }
        }
    }

}
