package lotto.view.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.money.PurchaseAmount;
import lotto.exception.LottoApplicationException;

public class InputHandler {

    public PurchaseAmount getPurchaseAmount() {
        String amount = Console.readLine();
        return PurchaseAmount.from(toInt(amount));
    }

    public Lotto getWinningNumbers() {
        String input = Console.readLine();
        String[] split = input.split(",");

        List<Integer> numbers = toIntList(split);
        return Lotto.of(numbers);
    }

    public LottoNumber getBonusNumber() {
        String input = Console.readLine();
        int intInput = toInt(input);
        return new LottoNumber(intInput);
    }

    // TODO: 변환하는 책임 다른 클래스로 분리하기, 테스트 작성 필요
    private List<Integer> toIntList(String[] split) {
        try {
            return Arrays.stream(split)
                    .map(Integer::valueOf)
                    .toList();
        } catch (NumberFormatException e) {
            throw new LottoApplicationException("정수를 입력해주세요.");
        }
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new LottoApplicationException("정수를 입력해주세요.");
        }
    }

}
