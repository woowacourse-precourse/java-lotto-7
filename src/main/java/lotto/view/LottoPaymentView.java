package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.db.Lotto;

public class LottoPaymentView implements View {

    private final List<Lotto> lotties;

    public LottoPaymentView(List<Lotto> lotties) {
        this.lotties = lotties;
    }

    @Override
    public String render() {
        return "\n" +
                lotties.size() + "개를 구매했습니다.\n" +
                lotties.stream()
                        .map(Lotto::toString)
                        .collect(Collectors.joining("\n"));
    }
}
