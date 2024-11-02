package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class ConsoleHandler {

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        System.out.println();
        return invertNumber(money);
    }

    private int invertNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printPurchasedLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
    }

    private void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        sortLottoNumbers(numbers);
        System.out.println(numbers);
    }

    private void sortLottoNumbers(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
    }

}
