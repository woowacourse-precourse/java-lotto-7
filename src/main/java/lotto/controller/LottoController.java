package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import lotto.model.Lotto;
import lotto.model.Price;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    LottoInputView lottoInputView;
    LottoOutputView lottoOutputView;

    public LottoController(LottoInputView lottoInputView, LottoOutputView lottoOutputView) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
    }

    public void run() {
        // 로또 구입 금액 입력받기
        int money = executeWithRetry(this::inputLottoMoney);

        // 구입한 개수만큼 로또 발행
        List<Lotto> lottos = issueLottos(money);

        // 발행한 로또 수량 및 번호 출력
        System.out.printf("\n%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            lotto.print();
        }

        // 당첨 번호 입력 받기
        List<Integer> winningNumbers = executeWithRetry(this::inputWinningNumbers);

        // 보너스 번호 입력 받기
        int bonusNumber = executeWithRetry(this::inputBonusNumber, winningNumbers);

        // 구매한 로또와 당첨 번호 비교
        HashMap<Price, Integer> prices = new HashMap<>();
        for (Lotto lotto : lottos) {
            Price p = lotto.compareWithWinningNumber(winningNumbers, bonusNumber);
            prices.put(p, prices.getOrDefault(p, 0) + 1);
        }

        // 당첨 내역 출력
        System.out.println("\n당첨 통계\n---");
        for (Price price : Price.getValues()) {
            price.print(prices.getOrDefault(price, 0));
        }

        // 수익률 출력
    }

    private int inputLottoMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();
        validateAmount(amount);
        return Integer.parseInt(amount);
    }

    private <T> T executeWithRetry(Supplier<T> action) {
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private <T> T executeWithRetry(Function<List<Integer>, T> action, List<Integer> integerList) {
        while (true) {
            try {
                return action.apply(integerList);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private void validateAmount(String amount) {
        if (amount == null || amount.isBlank()) {
            throw new IllegalArgumentException("빈 칸은 입력할 수 없습니다.");
        }
        int intAmount = Integer.parseInt(amount);
        if (intAmount <= 0) {
            throw new IllegalArgumentException("로또 금액은 1,000 이상의 값을 입력해주세요.");
        }
        if (intAmount % 1000 != 0) {
            throw new IllegalArgumentException("로또 금액은 1,000 단위로 입력해주세요.");
        }
    }

    private List<Lotto> issueLottos(int money) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = money / 1000;
        while (lottoCount-- > 0) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }
        return lottos;
    }

    private List<Integer> inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> winningNumbers = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .sorted()
                .boxed()
                .toList();
        validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("6개의 숫자를 쉼표로 구분하여 입력해주세요");
        }
        if (winningNumbers.stream().anyMatch(m -> m < 1 || m > 45)) {
            throw new IllegalArgumentException("1~45 사이의 자연수를 입력해주세요.");
        }
        if (winningNumbers.size() != new HashSet<>(winningNumbers).size()) {
            throw new IllegalArgumentException("숫자는 중복되면 안됩니다.");
        }
    }

    private int inputBonusNumber(List<Integer> lottoNumbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        validateBonusNumber(bonusNumber, lottoNumbers);
        return bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> lottoNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("1~45 사이의 자연수를 입력해주세요.");
        }
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 중복되는 보너스 번호입니다.");
        }
    }
}
