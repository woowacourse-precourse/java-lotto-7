package lotto.application.validation;

import java.util.List;

public interface LottoNumberValidation extends BaseValidation<List<Integer>> {

    List<Integer> parseNumbers(String input);

    void validateNumbers(List<Integer> numbers);
}
