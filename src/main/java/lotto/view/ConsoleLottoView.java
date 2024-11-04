package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.lotto.LottoDto;
import lotto.domain.purchase.PurchaseDto;

public class ConsoleLottoView implements LottoView {
    @Override
    public String readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    public void displayLottoNumbers(PurchaseDto purchaseDto) {
        List<LottoDto> lottos = purchaseDto.getLottoDtos();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (LottoDto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
