package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public static MyResult gradeLotto(Lotto answer, Lotto target, Integer bonus){
        List<Integer> matchList = answer.numbers.stream().filter(num -> target.numbers.stream()
                .anyMatch(Predicate.isEqual(num))).collect(Collectors.toList());
        boolean bonusMatch = target.numbers.stream().anyMatch(Predicate.isEqual(bonus));
        MyResult myresult = new MyResult(matchList.size(), bonusMatch);

        return myresult;
    }
}
