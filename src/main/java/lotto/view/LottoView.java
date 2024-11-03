package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.PurchaseAmount;

public class LottoView {

    // TODO: 의존성 주입
    private final RankMessageGenerator rankMessageGenerator = new RankMessageGenerator();
    private final LottoMessageGenerator lottoMessageGenerator = new LottoMessageGenerator();

    public PurchaseAmount getPurchaseAmountFromUser() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();
        return PurchaseAmount.from(amount);
    }

    public Lotto getWinningNumberFromUser() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] split = input.split(",");

        List<Integer> numbers = toIntList(split);

        return Lotto.of(numbers);
    }

    // TODO: 변환하는 책임 다른 클래스로 분리하기, 테스트 작성 필요
    private List<Integer> toIntList(String[] split) {
        try {
            return Arrays.stream(split)
                    .map(Integer::valueOf)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해주세요.");
        }
    }

    public void showWinningResult(Map<LottoRank, Integer> ranks) {
        List<LottoRank> lottoRanks = LottoRank.getRanksOrderByReward();
        for (LottoRank lottoRank : lottoRanks) {
            String message = rankMessageGenerator.getMessage(lottoRank, ranks);
            System.out.println(message);
        }
    }

    public void showPurchasedLottos(List<Lotto> purchasedLottos) {
        String purchaseQuantityMessage = lottoMessageGenerator.getPurchaseQuantityMessage(purchasedLottos.size());
        System.out.println(purchaseQuantityMessage);

        for (Lotto lotto : purchasedLottos) {
            String sortedNumbersMessage = lottoMessageGenerator.getSortedNumbersMessage(lotto);
            System.out.println(sortedNumbersMessage);
        }

        System.out.println();
    }

}
