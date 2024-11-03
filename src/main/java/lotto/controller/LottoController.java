package lotto.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import lotto.config.ErrorMessage;
import lotto.model.Lotto;
import lotto.service.ValidationService;
import lotto.view.LottoInputView;
import lotto.view.View;

public class LottoController implements Supplier<Lotto> {

    private final View lottoView;
    private final ValidationService validator;

    public LottoController() {
        lottoView = new LottoInputView();
        validator = new ValidationService();
    }

    @Override
    public Lotto get() {
        try {
            Optional<String> optionalLotto = lottoView.render();
            optionalLotto.orElseThrow(() -> new IllegalArgumentException(ErrorMessage.STOP));
            List<String> strNumbers = validator.isListFormat(optionalLotto.get());
            List<Integer> numbers = strNumbers.stream()
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toList();
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            View.of(e.getMessage(), true);
            return get();
        }
    }
}
