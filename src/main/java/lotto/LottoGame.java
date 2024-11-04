package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    public List<Lotto> lottos = new ArrayList<>();
    LottoGameValidator lottoGameValidate = new LottoGameValidator();

    int amount;
    int lottoQuantity;

    public void inputAmount() {
        // 로또 구매액 설정
        this.amount = lottoGameValidate.readAmount(LOTTO_PRICE);
        this.lottoQuantity = amount / LOTTO_PRICE;
    }

    public void buyLotto() {
        // 로또 구매
        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> ref = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(ref); // 오름차순 정렬
            Lotto lotto = new Lotto(ref);
            lottos.add(lotto);
        }
    }

    public void setWinningNumbers() {
        // 당첨 번호 설정
        List<Integer> winningNumbers;
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                winningNumbers = lottoGameValidate.parseWinningNumbers(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식이 올바르지 않습니다. 다시 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}