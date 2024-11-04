package lotto.view.outputview;

import lotto.message.info.InfoMessage;
import lotto.model.service.LottoService;

public class ResultView implements Result {

    public String responseCntLotto() {
        return InfoMessage.RESPONSE_CNT_LOTTO.getMessage();
    }
}
