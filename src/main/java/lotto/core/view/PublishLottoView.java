package lotto.core.view;

import java.util.List;
import lotto.commons.util.Collections;
import lotto.core.dto.LottoDto;

public class PublishLottoView implements View<List<LottoDto>> {

    private List<LottoDto> content;

    public PublishLottoView() {}

    @Override
    public void setContent(List<LottoDto> content) {
        this.content = content;
    }

    @Override
    public void display() {
        validateContent();

        int count = this.content.size();
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = this.content.get(i).numbers();
            String lotto = Collections.joinToString(numbers, ", ", "[", "]");
            System.out.println(lotto);
        }
    }

    private void validateContent() {
        if (this.content == null) {
            throw new IllegalStateException("로또 발행에 실패하였습니다.");
        }
    }
}
