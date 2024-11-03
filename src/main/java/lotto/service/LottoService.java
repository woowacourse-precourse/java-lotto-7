package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoWinningNumbers;

import java.util.*;

public interface LottoService {

    public int purchaseLottoCount(int lottoCost);

    public int toInt(String lottoCost);

    public List<Lotto> generateRandomLottoNumbers(int ticketCount);

    public List<String> splitWinningNumbers(String winningNumbers);

    public List<Integer> convertToInt(List<String> trimWinningNumbers);

    public List<String> trimWinningNumbers(List<String> splitWinningNumbers);

    public LottoWinningNumbers winningLotto(List<Integer> winningNumbers, int bonusNumber);

    public LottoResult getLottoResult();

    public Map<LottoRank, Integer> getResult();

    public void putLottoResult(Map<LottoRank, Integer> lottoResultMap);

    public void putLottoResultMap(LottoRank rankByMatchCount, Map<LottoRank, Integer> lottoResultMap);

    public LottoRank compareBonusNumber(LottoRank rankByMatchCount, int bonusNumber);

    public int checkWinningNumbers(LottoWinningNumbers lottoWinning, int i);

    public void setLottoRate(double rate);

    public double calculateRate(int amount, int lottoCost);

    public int sumAmount(Map<LottoRank, Integer> lottoResultMap);
}
