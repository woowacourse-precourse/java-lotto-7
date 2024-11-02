package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public void run() {
        // input
        int lottoCount = getLottoCount();
        List<Lotto> lottoList = issueLotto(lottoCount);
        List<Integer> winningNumbers = getWinningNumbers();
        winningNumbers.add(getBonusNumber());
    }

    private List<Lotto> issueLotto(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(Lotto.getLotto());
        }

        return lottoList;
    }

    private int getLottoCount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int purchaseAmount = parseInt(input);
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력된 금액이 1,000원으로 나누어 떨어지지 않습니다.");
        }
        return purchaseAmount / 1000;
    }

    private List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] inputList = Console.readLine().split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String input : inputList) {
            int number = parseInt(input);
            validateLottoNumber(number);
            winningNumbers.add(number);
        }
        return winningNumbers;
    }

    private void validateLottoNumber(int winningNumber) {
        if (winningNumber < 1 || winningNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 입력된 값이 1과 45 사이의 값이 아닙니다.");
        }
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력된 값이 정수가 아닙니다.");
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("[ERROR] 입력된 값이 없습니다.");
        }
    }

    private int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        int bonusNumber = parseInt(input);
        validateLottoNumber(bonusNumber);
        return bonusNumber;
    }

}
