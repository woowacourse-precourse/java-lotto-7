package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.common.LottoRank;
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
        System.out.println('\n' + lottos.size() + "개를 구매했습니다.");
        for (LottoDto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    @Override
    public String readWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    public String readBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    public void displayLottoResult(List<LottoRank> lottoRanks, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<LottoRank, Integer> rankCountMap = new HashMap<>();

        for (LottoRank rank : lottoRanks) {
            rankCountMap.put(rank, rankCountMap.getOrDefault(rank, 0) + 1);
        }

        LottoRank[] values = LottoRank.values();
        for (LottoRank value : values) {
            int count = rankCountMap.getOrDefault(value, 0);
            System.out.printf("%d개 일치 (%,d원) - %d개%n",
                    value.getMatchCount(),
                    value.getPrize(),
                    count);
        }
        System.out.println("총 수익률은" + profitRate + "\\%입니다.");
    }
}
