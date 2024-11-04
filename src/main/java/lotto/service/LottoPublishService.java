package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.repository.Lotto;
import lotto.enums.LottoRule;
import lotto.enums.UserInterfaceMessage;

public class LottoPublishService {
    private List<Lotto> publishedLottoNumbers = new ArrayList<>();

    private Integer lottoPrice;
    private Integer boughtLottoCount;

    private LottoPublishService() {
    }

    private static class InnerLottoPublishService {
        private static final LottoPublishService INSTANCE = new LottoPublishService();
    }

    public static LottoPublishService getInstance() {
        return InnerLottoPublishService.INSTANCE;
    }

    public void clearPublishedLottoNumbers() {
        publishedLottoNumbers = new ArrayList<>();
    }

    public List<Lotto> getPublishedLottoNumbers() {
        return publishedLottoNumbers;
    }

    public void lottoPublish(String price) {
        lottoPrice = String2Integer(price);
        boughtLottoCount(lottoPrice);
        for (int i = 1; i <= boughtLottoCount; i++) {
            createLottoNumber();
        }
    }

    private void boughtLottoCount(Integer lottoPrice) {
        boughtLottoCount = lottoPrice / LottoRule.LOTTO_PRICE.getValue();
    }

    private Integer String2Integer(String numberformat) {
        Integer price = 0;
        try {
            price = Integer.parseInt(numberformat);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(String.format(UserInterfaceMessage.ERROR_INPUT_BONUS_NUMBER_INCLUSIVE.getValue(),
                    LottoRule.START.getValue(), LottoRule.END.getValue()));
        }
        return price;
    }

    private void createLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoRule.START.getValue(),
                LottoRule.END.getValue(),
                LottoRule.LOTTO_MAX_COUNT.getValue());
        publishedLottoNumbers.add(new Lotto(numbers));
    }
}
