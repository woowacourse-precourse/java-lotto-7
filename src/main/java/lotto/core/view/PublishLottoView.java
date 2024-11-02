package lotto.core.view;

import java.util.List;
import lotto.commons.util.Collections;
import lotto.core.dto.LottoDto;

public class PublishLottoView implements View<List<LottoDto>> {

    public PublishLottoView() {}

    @Override
    public void display(List<LottoDto> content) {
        validateContent(content);

        int count = content.size();
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = content.get(i).numbers();
            String lotto = Collections.joinToString(numbers, ", ", "[", "]");
            System.out.println(lotto);
        }
    }

    private void validateContent(List<LottoDto> content) {
        if (content == null) {
            throw new IllegalStateException("로또 발행에 실패하였습니다.");
        }
    }
}
