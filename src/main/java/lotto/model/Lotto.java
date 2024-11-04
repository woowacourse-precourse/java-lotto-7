package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.constant.WinningInfo;
import lotto.validation.LottoValidator;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.common.constant.LottoInfo.DEFAULT_LOTTO;

public class Lotto {
    private final List<Integer> numbers;
    private final String joiningDelimiter = ", ";
    private final String prefix = "[";
    private final String suffix = "]";

    public Lotto(List<Integer> numbers) {
        LottoValidator.validateLotto(numbers);
        this.numbers = numbers;
    }

    public static Lotto drawLotto() {
        List<Integer> numberValueOfLotto = Randoms.pickUniqueNumbersInRange(
                DEFAULT_LOTTO.getLowBoundOfLottoNumber(),
                DEFAULT_LOTTO.getHighBoundOfLottoNumber(),
                DEFAULT_LOTTO.getCountOfLottoNumber()
        );
        return new Lotto(numberValueOfLotto.stream().sorted().toList());
    }

    public void printLottoInfo() {
        String message = numbers.stream()
                .map(String::valueOf)         // 각 요소를 문자열로 변환
                .collect(Collectors.joining(joiningDelimiter, prefix, suffix));

        OutputView.printMessage(message);
    }

    public WinningInfo matchWithWinningLotto(WinningLotto winningLotto) {
        return winningLotto.matchWithLotto(numbers);
    }
}
