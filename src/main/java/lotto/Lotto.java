package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
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
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public static Lotto getLotto(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
    }

    public static Lotto sortLotto(Lotto lotto){
        Collections.sort(lotto.numbers);
        return lotto;
    }

    public static void printLotto(Lotto lotto){
        String joinString = "[";
        joinString = String.join(", ", lotto.numbers.toString());
        joinString = joinString + "]";
        System.out.println(joinString);
    }
}
