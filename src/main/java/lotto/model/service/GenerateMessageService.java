package lotto.model.service;

import java.util.List;
import lotto.dto.LottoPurchasesDto;
import lotto.model.domain.Lotto;

public class GenerateMessageService {

    public LottoPurchasesDto generatePurchasesMessage(List<Lotto> myLottos) {
        StringBuilder purchasesMessage = new StringBuilder();
        for (Lotto myLotto : myLottos) {
            purchasesMessage.append(myLotto.showLottoNumbers()).append("%n");
        }
        return new LottoPurchasesDto(myLottos.size(), purchasesMessage.toString());
    }
}
