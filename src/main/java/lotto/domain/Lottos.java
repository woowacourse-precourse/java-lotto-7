package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.LottoWinResult;
import lotto.enums.LottoErrorMessage;
import lotto.exception.LottoInputException;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        validate(lottos);
        this.lottos = lottos;
    }

    private void validate(List<Lotto> numbers) {
        if (numbers.size() != 6) {
            throw new LottoInputException(LottoErrorMessage.LOTTO_WINNING_INVALID_SIZE);
        }
    }

    public List<LottoWinResult> getWinResult(List<Integer> winningNumbers, int bonusNumber) {
        List<LottoWinResult> lottoWinResultList = new ArrayList<>();
        for(Lotto lotto : lottos){
            LottoWinResult lottoWinResult = lotto.getResult(winningNumbers, bonusNumber);
            lottoWinResultList.add(lottoWinResult);
        }
        return lottoWinResultList;
    }
}
