package lotto;

import static lotto.constant.LottoConstant.LOTTO_LENGTH;
import static lotto.constant.LottoConstant.LOTTO_PRICE;

import java.util.List;
import lotto.validator.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.service.LottoService;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void add(int lottoNumber) {
        this.numbers.add(lottoNumber);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

}
