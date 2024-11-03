package lotto.core.view;

import java.util.List;
import lotto.commons.util.Collections;
import lotto.core.constants.Error.LottoTicketError;
import lotto.core.dto.LottoDto;
import lotto.core.dto.LottoTicketDto;

public class PublishLottoTicketView implements View<LottoTicketDto> {

    public PublishLottoTicketView() {}

    @Override
    public void display(LottoTicketDto content) {
        validateContent(content);

        List<LottoDto> lottos = content.lottos();
        int count = content.amount().lottoCount();
        String lottoNumberContent = buildLottoNumberContent(lottos, count);

        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
        System.out.print(lottoNumberContent);
    }

    private String buildLottoNumberContent(List<LottoDto> lottos, int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = lottos.get(i).numbers();
            String content = Collections.joinToString(numbers, ", ", "[", "]");
            builder.append(content);
            builder.append("\n");
        }
        return builder.toString();
    }

    private void validateContent(LottoTicketDto content) {
        if (content == null || content.lottos() == null) {
            throw new IllegalStateException(LottoTicketError.FAILED_PUBLISHED);
        }
    }
}
