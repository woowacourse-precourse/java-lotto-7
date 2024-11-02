package lotto.view;

import lotto.viewHandler.api.Api;
import lotto.viewHandler.api.dto.output.PurchaseLottosDto;
import lotto.viewHandler.api.dto.output.ResultAmountDto;
import lotto.viewHandler.api.dto.output.ResultLottosDto;

import java.util.List;

public class Output {
    public Output() {
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
