package lotto.view;

import lotto.viewHandler.api.Api;
import lotto.dto.output.PurchaseLottosDto;
import lotto.dto.output.ResultAmountDto;
import lotto.dto.output.ResultLottosDto;

import java.util.List;

import static lotto.view.ViewConstant.EXCEPTION_PREFIX;
import static lotto.view.ViewConstant.RESULT_AMOUNT_PREFIX;
import static lotto.view.ViewConstant.RESULT_AMOUNT_SUFFIX;

public class Output {
    private static final String RESULT_LOTTO_START = "당첨 통계\n---";

    public Output() {
    }

    public void viewExceptionMessage(String e) {
        System.out.println(EXCEPTION_PREFIX + e);
    }

    public void viewPurchaseLottos(Api<PurchaseLottosDto> api) {
        List<String> lottos = api.getData().getLottos();
        System.out.println(api.getData().getPurchase());
        lottos.forEach(System.out::println);
    }

    public void viewResultLottos(Api<ResultLottosDto> api) {
        List<String> results = api.getData().getResults();
        System.out.println(RESULT_LOTTO_START);
        results.forEach(System.out::println);
    }

    public void viewResultAmount(Api<ResultAmountDto> api) {
        Double amount = api.getData().getAmount();
        System.out.println(RESULT_AMOUNT_PREFIX + amount + RESULT_AMOUNT_SUFFIX);
    }
}
