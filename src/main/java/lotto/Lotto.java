package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Messages.ErrorMessage;
import lotto.Model.MyResults;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.*;
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
            //OutputView.printError(ErrorMessage.LOTTO_NUM.getError());
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUM.getError());
        }
        if (!InputView.checkRangeList(numbers)) {
            //OutputView.printError(ErrorMessage.LOTTO_RANGE.getError());
            throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE.getError());
        }
        Set<Integer> numberSet = numbers.stream()
                .collect(Collectors.toSet());
        if (numberSet.size() != numbers.size()) {
            //OutputView.printError(ErrorMessage.LOTTO_DUPLICATE.getError());
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATE.getError());
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public static Lotto getLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public static Lotto sortLotto(Lotto lotto) {
        List<Integer> sortedNumbers = new ArrayList<>(lotto.numbers);
        Collections.sort(sortedNumbers);
        return new Lotto(sortedNumbers);
    }


    public static List<Lotto> sortLottoList(int lottoCount) {
        List<Lotto> myLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto newLotto = Lotto.getLotto();
            newLotto = Lotto.sortLotto(newLotto);
            myLottos.add(newLotto);
            OutputView.printLotto(newLotto);
        }
        OutputView.printBlank();
        return myLottos;
    }

    public static MyResults gradeLotto(Lotto answer, Lotto target, int bonus) {
        List<Integer> matchNums = answer.numbers.stream().filter(num -> target.numbers.stream()
                .anyMatch(Predicate.isEqual(num))).collect(Collectors.toList());
        boolean bonusMatch = target.numbers.stream().anyMatch(Predicate.isEqual(bonus));
        MyResults myresult = new MyResults(matchNums.size(), bonusMatch);

        return myresult;
    }

}
