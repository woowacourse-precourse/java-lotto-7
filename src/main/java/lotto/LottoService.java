package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class LottoService {

    private List<Lotto> lottos = new ArrayList<>();
    private List<Integer> winningNumbers = null;
    private int bonusNumber = -1;

    public void run() {
        purchaseLotto();
        inputWinningNumbersAndBonusNumber();
        List<LottoRank> result = lottos.stream()
                .map(lotto -> lotto.checkRank(winningNumbers, bonusNumber))
                .toList();
        result.forEach(this::printStatus);
    }

    private void purchaseLotto() {
        int price = -1;
        // IllegalArgumentException 발생 시 오류 메시지 출력하고 다시 입력 받도록 함
        while (price == -1) {
            try {
                price = inputPrice();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        generateLotto(price / 1000);
    }

    private void generateLotto(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
            System.out.println(numbers);
        }
    }

    private int inputPrice() {
        System.out.println("\n구입금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            int price = Integer.parseInt(input.trim());
            if (price % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 로또 구입금액은 1000원 단위여야 합니다.");
            }
            if (price / 1000 < 1) {
                throw new IllegalArgumentException("[ERROR] 로또 구입금액은 최소 1000원 이상이어야 합니다.");
            }
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
    }

    private void inputWinningNumbersAndBonusNumber() {
        // IllegalArgumentException 발생 시 오류 메시지 출력하고 다시 입력 받도록 함
        while (winningNumbers == null) {
            try {
                winningNumbers = inputWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (bonusNumber == -1) {
            try {
                bonusNumber = inputBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printStatus(LottoRank lottoRank) {
        System.out.println(lottoRank);
    }

    private List<Integer> inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        try {
            List<Integer> numbers = Stream.of(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
            LottoValidator.validateLottoNumber(numbers);
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }

    private int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        try {
            int bonusNumber = Integer.parseInt(input.trim());
            LottoValidator.validateBonusNumber(winningNumbers, bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

}
