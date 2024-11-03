package lotto.service;

import lotto.domain.*;
import lotto.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private final static Integer LOTTO_START_NUMBER = 1;
    private final static Integer LOTTO_END_NUMBER = 45;
    private final static Integer LOTTO_MAX_LENGTH = 6;
    private final static Integer MATCH_ZERO = 0;
    private final static Integer MATCH_NUMBER = 1;

    public void buyLottoes(Consumer consumer, int numberLimit) {
        int count = consumer.getMoney() / numberLimit;
        for (int i = 0; i < count; i++) {
            buyLotto(consumer);
        }
    }

    private void buyLotto(Consumer consumer) {
        Lotto lottoNumber = createLottoNumber();
        consumer.buyLotto(lottoNumber);
    }
    private Lotto createLottoNumber() {
        List<Integer> lottoNumbers = Utils.randomLottoNumbers(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_MAX_LENGTH);
        return new Lotto(lottoNumbers);
    }

    public void calculationLottoRank(Consumer consumer, LottoRankManager lottoRankManager, LottoPrize lottoPrize) {
        ArrayList<Lotto> lottoes = consumer.getLottoes();
        List<Integer> lottoPrizeNumbers = lottoPrize.getLottoPrizeNumbers();
        Integer bonusNumber = lottoPrize.getBonusNumber();

        findMatchingNumbers(lottoRankManager, lottoes, lottoPrizeNumbers, bonusNumber);
    }

    public void findMatchingNumbers(LottoRankManager lottoRankManager, ArrayList<Lotto> lottoes, List<Integer> lottoPrizeNumbers, Integer bonusNumber) {
        int matchNumbers;
        boolean matchBonusNumber;

        for (Lotto lotto : lottoes) {

            matchNumbers = MATCH_ZERO;

            matchNumbers = countMatchNumbers(matchNumbers, lotto.getNumbers(), lottoPrizeNumbers);
            matchBonusNumber = countBonusMatches(lotto.getNumbers(), bonusNumber);

            if (matchBonusNumber) {
                matchNumbers += MATCH_NUMBER;
            }

            lottoRankManager.updateLottoRank(matchNumbers, matchBonusNumber);
        }
    }

    public int countMatchNumbers(int matchNumbers, List<Integer> lottoNumbers, List<Integer> prizeNumbers) {
        for (Integer number : lottoNumbers) {
            if (prizeNumbers.contains(number)) {
                matchNumbers += MATCH_NUMBER;
            }
        }
        return matchNumbers;
    }

    public boolean countBonusMatches(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public double resultLotto(LottoRankManager lottoRankManager) {
        return lottoRankManager.calculateYield();
    }
}
