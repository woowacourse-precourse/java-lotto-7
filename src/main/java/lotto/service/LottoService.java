package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.dto.LottoResultDto;
import lotto.validator.LottoValidator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;

    public LottoResultDto createLottoList(int price) {
        LottoValidator.validateLottoPurchaseAmount(price);
        int purchaseQuantity = calculatePurchaseQuantity(price);
        return getLottoResult(purchaseQuantity);
    }

    private int calculatePurchaseQuantity(int price) {
        return price / LOTTO_PRICE;
    }

    private LottoResultDto getLottoResult(int purchaseQuantity){
        List<Lotto> lottoList = getLottoList(purchaseQuantity);
        return new LottoResultDto(purchaseQuantity, lottoList);
    }

    private List<Lotto> getLottoList(int purchaseQuantity){
        return IntStream.range(0,purchaseQuantity)
                .mapToObj(i -> new Lotto(getRandomNumbers()))
                .collect(Collectors.toList());
    }

    private List<Integer> getRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
