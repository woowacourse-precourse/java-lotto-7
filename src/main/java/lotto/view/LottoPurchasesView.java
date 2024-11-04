package lotto.view;

import java.util.List;
import lotto.dto.LottosDto;
import lotto.model.domain.Lotto;

public class LottoPurchasesView implements View {

    private static final String LOTTO_PURCHASES_OUTPUT_HEADLINE = "\n%d개를 구매했습니다.";
    private final LottosDto lottosDto;

    public LottoPurchasesView(LottosDto lottosDto) {
        this.lottosDto = lottosDto;
    }

    private void showHeadLine(List<Lotto> myLottos) {

        System.out.println(String.format(LOTTO_PURCHASES_OUTPUT_HEADLINE, myLottos.size()));
    }


    @Override
    public String display() {
        List<Lotto> myLottos = lottosDto.getMyLottos();
        showHeadLine(myLottos);
        for (Lotto myLotto : myLottos) {
            System.out.println(myLotto.showLottoNumbers());
        }
        return null;
    }
}
