package lotto.service;

import lotto.Exception.ExceptionType;
import lotto.model.Lotto;
import lotto.utils.LottoRules;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.LottoRules.LOTTO_PRICE;

public class LottoService {
    private static final String BONUS_NUMBER_DUPLICATE_MESSAGE = "보너스번호는 당첨번호 6개와 중복될 수 없습니다.";

    public Lotto generateLotto() {
        return new Lotto(LottoRules.pickRandomNumbers());
    }

    public List<Lotto> purchaseLottoTickets(int price) {
        List<Lotto> lottoTickets = new ArrayList<>();

        int ticketCount = price / LOTTO_PRICE;

        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(generateLotto());
        }

        return lottoTickets;
    }

    public List<List<Integer>> displayPurchasedLottoTickets(List<Lotto> myLottoTickets) {
        List<List<Integer>> allLottoNumbers = new ArrayList<>();
        for (Lotto lotto : myLottoTickets) {
            allLottoNumbers.add(lotto.getLottoNumbers());
        }
        return allLottoNumbers;
    }

    public void checkBonusNumberDuplication(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionType.PREFIX_ERROR_MESSAGE + BONUS_NUMBER_DUPLICATE_MESSAGE);
        }
    }
}
