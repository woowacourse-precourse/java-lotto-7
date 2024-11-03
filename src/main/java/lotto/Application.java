package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domains.Lotto;
import lotto.service.LottoService;

public class Application {

    private static LottoService lottoService = new LottoService();
    private static Lotto winningLotto;

    public static void main(String[] args) {
        List<Lotto> lottos = setLottos();
        setWinningLotto();
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
}
