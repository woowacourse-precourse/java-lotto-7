package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domains.Lotto;
import lotto.service.LottoService;

public class Application {

    private static LottoService lottoService = new LottoService();
    private static Lotto winningLotto = null;
    private static int bonusNumber;

    public static void main(String[] args) {
        List<Lotto> lottos = setLottos();
        setWinningLotto();
        setBounsNumber();
        int[] winningCount = lottoService.getWinningCount(lottos, winningLotto, bonusNumber);
    }

    private static List<Lotto> setLottos() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputValue = Console.readLine();

        try {
            int cost = Integer.parseInt(inputValue);
            return lottoService.issueLotto(cost);
        } catch (IllegalArgumentException exception) {
            if (exception.getClass() == NumberFormatException.class) {
                throw new IllegalArgumentException("[Error] 구입금액의 입력이 올바르지 않습니다. 입력 값: " + inputValue);
            }
            throw exception;
        }
    }

    private static void setWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        winningLotto = lottoService.setWinningLotto(Console.readLine());
    }

    private static void setBounsNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputValue = Console.readLine();
        try {
            bonusNumber = Integer.parseInt(inputValue.strip());
            if (1 > bonusNumber || 45 < bonusNumber) {
                throw new IllegalArgumentException("[Error] 보너스 번호는 1 이상 45 이하이어야 합니다. 입력된 값: " + bonusNumber);
            }
            if (winningLotto.existsNumber(bonusNumber)) {
                throw new IllegalArgumentException("[Error] 입력된 보너스 번호가 당첨 번호에 포함되어 있습니다. 입력된 값: " + bonusNumber);
            }
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("[Error] 잘못된 값을 입력받았습니다. 입력된 보너스 번호 값: " + inputValue);
        }
    }
}
