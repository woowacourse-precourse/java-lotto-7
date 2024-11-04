package lotto.io.request;

import lotto.domain.Lotto;
import lotto.domain.extractor.LottoExtractor;
import lotto.util.ExceptionMessages;

public record LottoRequest(String winningNumbers) {

    private static final String DELIMITER = ",";
    private static final String LOTTO_PATTERN = "\\d+";
    private static final LottoExtractor lottoExtractor = new LottoExtractor();

    public LottoRequest {
        validateEmpty(winningNumbers);
        validateDelimiter(winningNumbers);
        validateLotto(winningNumbers);
    }

    private void validateEmpty(String winningNumbers) {
        if (winningNumbers == null || winningNumbers.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.EMPTY_INPUT.getMessage());
        }
    }

    private void validateDelimiter(String winningNumbers) {
        String[] winningLotto = winningNumbers.split(DELIMITER);
        for (String number : winningLotto) {
            if (!number.matches(LOTTO_PATTERN)) {
                throw new IllegalArgumentException(ExceptionMessages.INVALID_DELIMITER.getMessage());
            }
        }
    }

    private void validateLotto(String winningNumbers) {
        Lotto lotto = new Lotto(lottoExtractor.extractLotto(winningNumbers));
    }
}
