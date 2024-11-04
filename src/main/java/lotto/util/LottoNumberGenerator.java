package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.BonusNumber;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constant.Amount.LOTTO_NUMBERS_SIZE;
import static lotto.constant.Amount.MAXIMUM_LOTTO_NUMBER;
import static lotto.constant.Amount.MINIMUM_LOTTO_NUMBER;
import static lotto.constant.Amount.THOUSAND;

public class LottoNumberGenerator {

    private final List<List<Integer>> lottoTickets = new ArrayList<>();

    public List<List<Integer>> generateLottoNumbers(int quantity) {
        for (int i = 0; i < quantity / THOUSAND.getValue(); i++) {
            ArrayList<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER.getValue(), MAXIMUM_LOTTO_NUMBER.getValue(), LOTTO_NUMBERS_SIZE.getValue()));
            sortLottoNumbers(lottoNumbers);
            lottoTickets.add(lottoNumbers);
        }
        return lottoTickets;
    }

    public Lotto createWinningNumbers(String winningNumbers) {
        String[] separatedWinningNumbers = WinningNumberSeparator.separatedLottoNumbers(winningNumbers);
        List<Integer> parseWinningNumbers = WinningNumberParser.parseWinningNumber(separatedWinningNumbers);
        return new Lotto(parseWinningNumbers);
    }


    private void sortLottoNumbers(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }

    public BonusNumber createBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        int parsedBonusNumber = WinningNumberParser.parseBonusNumber(bonusNumber);
        return new BonusNumber(parsedBonusNumber, winningNumbers);
    }
}
