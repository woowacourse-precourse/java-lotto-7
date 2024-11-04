package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validation.LottoValidator;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validateLotto(numbers);
        this.numbers = numbers;
    }

    public static Lotto drawLotto(){
        List<Integer> numberValueOfLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numberValueOfLotto.stream().sorted().toList());
    }

    public void printLottoInfo(){
        String message = numbers.stream()
                .map(String::valueOf)         // 각 요소를 문자열로 변환
                .collect(Collectors.joining(", ", "[", "]"));

        OutputView.printMessage(message);
    }
}
