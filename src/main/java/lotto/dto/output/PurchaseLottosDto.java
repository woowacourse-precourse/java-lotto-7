package lotto.dto.output;

import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.PurchaseLottos.LOTTO_UNIT;

public class PurchaseLottosDto {
    private static final String PURCHASE_END = "개를 구매했습니다.";
    private static final String COMMA = ", ";
    private static final String LOTTO_NUMBER_START = "[";
    private static final String LOTTO_NUMBER_END = "]";

    private final String purchase;
    private final List<String> lottos;

    public PurchaseLottosDto(List<Lotto> lottos) {
        this.purchase = purchaseMoney(lottos.size());
        this.lottos = lottos.stream()
                .map(this::transformDto)
                .toList();
    }

    public String getPurchase() {
        return purchase;
    }

    public List<String> getLottos() {
        return lottos.stream().toList();
    }

    private String purchaseMoney(Integer lottoSize) {
        return  lottoSize + PURCHASE_END;
    }

    private String transformDto(Lotto lotto) {
        String lottoNumbers = lotto.getNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(COMMA));
        return LOTTO_NUMBER_START + lottoNumbers + LOTTO_NUMBER_END;
    }
}
