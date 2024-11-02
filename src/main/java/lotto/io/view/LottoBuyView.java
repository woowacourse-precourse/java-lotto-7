package lotto.io.view;

import lotto.dto.LottoDto;
import lotto.dto.LottosDto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoBuyView {
    private static final LottoBuyView INSTANCE = new LottoBuyView();
    private static final String PURCHASE_COUNT_PREFIX = "\n";
    private static final String PURCHASE_COUNT_SUFFIX = "개를 구매했습니다.\n";
    private static final String LOTTO_SUFFIX = "]\n";
    private static final String LOTTO_PREFIX = "[";
    private static final String LOTTO_DELIMITER = ", ";

    public static LottoBuyView getInstance() {
        return INSTANCE;
    }

    public void showBuyInfo(LottosDto lottoBuyDto) {
        int totalPurchase = lottoBuyDto.lottoNumberValues().size();
        List<LottoDto> lottos = lottoBuyDto.lottoNumberValues();
        String purchaseMessage = generatePurchaseCount(totalPurchase);
        String lottoInfo = generateLottoInfoFrom(lottos);
        System.out.print(purchaseMessage + lottoInfo);
    }

    private String generatePurchaseCount(int size) {
        return PURCHASE_COUNT_PREFIX + size + PURCHASE_COUNT_SUFFIX;
    }

    private String generateLottoInfoFrom(List<LottoDto> lottos) {
        return lottos.stream()
                .map(LottoDto::lottoValues)
                .map(this::generateLottoInfo)
                .collect(Collectors.joining(""));
    }

    private String generateLottoInfo(List<Integer> lottoValues) {
        String middle = lottoValues.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_DELIMITER));
        return LOTTO_PREFIX + middle + LOTTO_SUFFIX;
    }
}
