package lottoController;

import lotto.Lotto;
import view.InputView;
import view.OutputView;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class GenerateLottoController {
    private final int LOTTO_PRICE = 1000;

    private static List<Lotto> lottoList = new ArrayList<>();
    private static int lottoCount;

    public void generateLotto() {
        try {
            int money = validateMoney(InputView.inputMoney());
            lottoCount = getLottoCount(money);
            buyLotto(lottoCount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int validateMoney(String inputMoney) {
        try {
            int validMoney = Integer.parseInt(inputMoney);

            if (validMoney < 1000) {
                throw new IllegalArgumentException("[ERROR] 1000원보다 더 커야 합니다.");
            }

            if (validMoney % LOTTO_PRICE != 0) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력 가능합니다.");
            }

            return validMoney;

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    public int getLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    public void buyLotto(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            generateLottoNumber();
        }
        OutputView.printLotto(lottoCount, lottoList);
    }

    public void generateLottoNumber() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Lotto lotto = new Lotto(numbers);
        lottoList.add(lotto);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getLottoPrice() {
        return lottoCount * LOTTO_PRICE;
    }
}
