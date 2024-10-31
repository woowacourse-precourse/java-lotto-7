package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoWinResult;
import lotto.enums.LottoCriteria;
import lotto.enums.LottoErrorMessage;
import lotto.exception.LottoInputException;
import lotto.validator.LottosValidator;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        validate(lottos);
        this.lottos = lottos;
    }

    private void validate(List<Lotto> lottos) {
        if(!LottosValidator.isValidLottosCount(lottos)){
            throw new LottoInputException(LottoErrorMessage.LOTTOS_INVALID_SIZE);
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

    public String getLottosNumbersStr(){
        return lottos.stream()
                .map((lotto) -> lotto.getLottoNumberStr())
                .collect(Collectors.joining());
    }
}
