package lotto.domain;

import java.util.List;
import lotto.dto.Lotto;
import lotto.dto.Receipt;
import lotto.dto.ResultDto;

public class ResultDtoGenerator {
    public ResultDto generateResultDto(int purchaseAmount, List<Lotto> lottos){
        return new ResultDto(new Receipt(purchaseAmount), lottos);
    }
}
