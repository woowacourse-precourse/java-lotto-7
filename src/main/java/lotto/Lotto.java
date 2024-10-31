package lotto;

import java.util.List;
import lotto.controller.LottoController;

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

    public String toString() {
        return numbers.toString();
    }

    public static void lottoStart() {
        LottoController lottoController = new LottoController();
        lottoController.buyLottos();
        lottoController.displayLottos();
        lottoController.inputLottoNumbers();
        lottoController.inputBonusNumber();
    }

}
