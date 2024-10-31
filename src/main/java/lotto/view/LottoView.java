package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoView {
    public String inputLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(String lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public String inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = Console.readLine();
        System.out.println();
        return winningNumber;
    }

    public String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        System.out.println();
        return bonusNumber;
    }

    public void printWinningTrace(String winningTrace) {
        System.out.println("당첨 통계\n---");
        System.out.println(winningTrace);
    }

    public void printWinningRate(String winningRate) {
        System.out.println("총 수익률은 " + winningRate + "%입니다.");
    }
}
