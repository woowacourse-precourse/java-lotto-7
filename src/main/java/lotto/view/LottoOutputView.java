package lotto.view;

import java.util.List;

public class LottoOutputView {
    public String getLottoCountMessage(int count) {
        return count + "개를 구매했습니다.";
    }

    public String getLottoNumbersMessage(List<Integer> numbers) {
        return numbers.toString();
    }
}