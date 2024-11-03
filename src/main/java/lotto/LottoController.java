package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private static List<Lotto> lottos = new ArrayList<>();
    private static Lotto winNumber;
    private static int bonusNumber;
    private static HashMap<Lottery, Integer> result = new HashMap<>();

    // 로또 구매
    public void purchaseLottery() {
        String price = LottoView.inputPrice();
        createLotto(purchaseNumber(price));
    }

    // 로또 번호 출력
    public void printLottoNumber() {
        LottoView.printPurchaseCount(this.lottos.size());
        for(Lotto lotto : this.lottos) {
            LottoView.printLottos(lotto.getSortedLotto());
        }
    }

    // 당첨 번호 입력
    public void winning() {
        String input = LottoView.inputWinningNumber();
        List<String> numbers = List.of(input.split(","));
        List<Integer> winnings = numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        this.winNumber = new Lotto(winnings);
        String bonusNumber = LottoView.inputBonusNumber();
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    // 결과 출력
    public void result() {
        LottoView.printResult(result);
    }

    // 당첨 개수 확인
    private void winningMatch() {
        for(Lotto lotto : lottos) {
            int cnt = (int) winNumber.getNumbers().stream()
                    .filter(lotto.getNumbers()::contains)
                    .distinct()
                    .count();
            boolean isBonus = false;
            if(cnt == 5) {
                isBonus = lotto.getNumbers().stream()
                        .anyMatch(number -> number == bonusNumber);
            }

            Lottery lottery = Lottery.getPriceByMatch(cnt, isBonus);
            result.put(lottery, result.getOrDefault(lottery, 0) + 1);
        }
    }

    private int purchaseNumber(String price) {
        return Integer.parseInt(price) / 1000;
    }

    private void createLotto(int count) {
        for(int i=0; i<count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            this.lottos.add(lotto);
        }
    }
}
