package lotto.service;

public interface LottoValidateService {
    public void validateLottoCost(String lottoPrice);

    public void validateWinningNumbers(String lottoWinningNumbers);

    public void validateBonusNumbers(String bonusNumber);
}
