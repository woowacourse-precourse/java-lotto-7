package lotto.core.view;

import java.util.List;
import lotto.commons.util.Collections;
import lotto.core.dto.LottoDto;
import lotto.core.dto.LottoTicketDto;

public class PublishLottoTicketView implements View<LottoTicketDto> {

    public PublishLottoTicketView() {}

    @Override
    public void display(LottoTicketDto content) {
        validateContent(content);

        List<LottoDto> lottos = content.lottos();
        int count = content.lottos().size();
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = lottos.get(i).numbers();
            String lotto = Collections.joinToString(numbers, ", ", "[", "]");
            System.out.println(lotto);
        }
    }

    private void validateContent(LottoTicketDto content) {
        if (content == null || content.lottos() == null) {
            throw new IllegalStateException("로또 발행에 실패하였습니다.");
        }
    }
}
