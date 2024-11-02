package lotto.view;

import lotto.viewHandler.api.Api;
import lotto.dto.output.PurchaseLottosDto;
import lotto.dto.output.ResultAmountDto;
import lotto.dto.output.ResultLottosDto;

import java.util.List;

public class Output {
    private final String EXCEPTION_PREFIX = "[ERROR] ";

    public Output() {
    }

    public void viewExceptionMessage(String e) {
        System.out.println(EXCEPTION_PREFIX + e);
    }

    public void viewPurchaseLottos(Api<PurchaseLottosDto> api) {
        List<String> lottos = api.getData().getLottos();
        lottos.forEach(System.out::println);
    }

    public void viewResultLottos(Api<ResultLottosDto> api) {
        List<String> results = api.getData().getResults();
        results.forEach(System.out::println);
    }

    public void viewResultAmount(Api<ResultAmountDto> api) {
        Double amount = api.getData().getAmount();
        System.out.println("총 수익률은 " + amount +"%입니다.");
    }
}
