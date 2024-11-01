package lotto.service;

import lotto.dto.LottosDto;

public interface LottoPurchaseService {
    void purchaseLottos(String rawPurchaseAmount);
    LottosDto getLottosDto();
}
