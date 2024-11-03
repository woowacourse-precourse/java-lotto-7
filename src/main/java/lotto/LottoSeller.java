package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoSeller {
    private static int lottoPrice = 1000;

    public void run() {
        int pay = readPay();
        List<Lotto> lottos = buyLottos(pay);
    }

    private int readPay() {
        String input;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                input = Console.readLine();
                validatePay(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(input);
    }

    private void validatePay(String input) throws IllegalArgumentException {
        int pay;
        try {
            pay = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 숫자여야 합니다.");
        }
        if (pay < 0) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 양수여야 합니다.");
        }
        if (pay % lottoPrice != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 1000원을 단위로 입력해야 합니다.");
        }
    }

    private List<Lotto> buyLottos(int pay) {
        int lottoCount = pay / lottoPrice;
        System.out.println(lottoCount + "개를 구매했습니다.");
        List<Lotto> lottos = LottoRandomGenerator.generate(lottoCount);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        return lottos;
    }
}
