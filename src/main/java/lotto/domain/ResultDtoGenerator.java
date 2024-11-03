package lotto.domain;

import java.util.List;
import lotto.dto.entity.Lotto;
import lotto.dto.entity.Receipt;
import lotto.dto.ReceiptAndLottoDto;

public class ResultDtoGenerator {
    public ReceiptAndLottoDto generateResultDto(int purchaseAmount, List<Lotto> lottos){
        return new ReceiptAndLottoDto(new Receipt(purchaseAmount), lottos);
    }
}
