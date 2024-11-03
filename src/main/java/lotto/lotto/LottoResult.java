package lotto.lotto;

public record LottoResult(WinningNumbers winningNumbers, LottoNumber bonusNumber) {
    public LottoResult {
        validate(winningNumbers, bonusNumber);
    }

    private void validate(WinningNumbers winningNumbers, LottoNumber bonusNumber) {
        if (hasCommonNumber(winningNumbers, bonusNumber)) {
            throw LottoException.COMMON_BETWEEN_WINNING_NUMBER_AND_BONUS_NUMBER.getException();
        }
    }

    private boolean hasCommonNumber(WinningNumbers winningNumbers, LottoNumber bonusNumber) {
        return winningNumbers.contains(bonusNumber);
    }
}
