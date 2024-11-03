package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoCalculateRequest;
import lotto.dto.LottoWinResult;
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

    public List<LottoWinResult> getWinResult(LottoCalculateRequest lottoCalculateRequest) {
        List<LottoWinResult> lottoWinResultList = new ArrayList<>();
        List<Integer> winningNumbers = lottoCalculateRequest.winningNumbers();
        int bonusNumber = lottoCalculateRequest.bonusNumber();
        for(Lotto lotto : lottos){
            LottoWinResult lottoWinResult = lotto.calculateWinResult(winningNumbers, bonusNumber);
            lottoWinResultList.add(lottoWinResult);
        }
        return lottoWinResultList;
    }

    public String getLottosNumbersStr(){
        return lottos.stream()
                .map((lotto) -> lotto.getLottoNumbersStr())
                .collect(Collectors.joining());
    }
}
