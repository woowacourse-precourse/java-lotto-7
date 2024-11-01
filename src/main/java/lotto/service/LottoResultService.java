package lotto.service;

public interface LottoResultService {
    void receiveWinningLottoNumbers(String rawWinningNumbers);
    void receiveBonusNumber(String rawBonusNumbers);

}
