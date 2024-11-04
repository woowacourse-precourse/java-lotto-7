package lotto.application.port.input;

import lotto.application.dto.request.PurchaseLottoRequest;
import lotto.application.dto.response.PurchaseLottoResponse;

public interface PurchaseLottoUsecase {

    PurchaseLottoResponse execute(final PurchaseLottoRequest purchaseLottoRequest);
}
