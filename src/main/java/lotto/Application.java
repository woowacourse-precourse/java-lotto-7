package lotto;

import handler.ConsoleHandler;
import java.util.Arrays;
import java.util.List;
import model.Lotto;
import service.LottoService;

public class Application {

    private final Client client;

    private final LottoService lottoService;

    public Application() {
        this.client = new Client();
        this.lottoService = new LottoService();
    }

    public static void main(String[] args) {
        Application application = new Application();

        application.run();
    }

    private void run() {
        buyLotto();
        WinningNumbersWithBonusNumber winningNumbersWithBonusNumber = generateWinningNumbersWithBonusNumber();
    }

    private void buyLotto() {
        while (client.getLottos().isEmpty()) {
            try {
                int buyAmount = ConsoleHandler.inputIntValue("구입금액을 입력해 주세요.");
                List<Lotto> lottos = lottoService.buy(buyAmount);
                client.addLotto(lottos);
            } catch (IllegalArgumentException exception) {
                ConsoleHandler.announceError(exception.getMessage());
            }
        }

        ConsoleHandler.announceBuyLottos(client.getLottos());
    }

    private WinningNumbersWithBonusNumber generateWinningNumbersWithBonusNumber() {
        WinningNumbersWithBonusNumber winningNumbersWithBonusNumber = null;

        WinningLottoNumbers winningLottoNumbers = generateWinningNumbers();

        while (winningNumbersWithBonusNumber == null) {
            try {
                LottoNumber bonusNumber = generateBonusNumber();
                winningNumbersWithBonusNumber = new WinningNumbersWithBonusNumber(winningLottoNumbers, bonusNumber);
            } catch (IllegalArgumentException exception) {
                ConsoleHandler.announceError(exception.getMessage());
            }
        }

        return winningNumbersWithBonusNumber;
    }

    private WinningLottoNumbers generateWinningNumbers() {
        WinningLottoNumbers winningLottoNumbers = null;

        while (winningLottoNumbers == null) {
            try {
                List<Integer> winningNumbers =
                        stringToIntegerList(ConsoleHandler.inputStringValue("당첨 번호를 입력해 주세요."));
                winningLottoNumbers = new WinningLottoNumbers(winningNumbers.stream().map(LottoNumber::new).toList());
            } catch (IllegalArgumentException exception) {
                ConsoleHandler.announceError(exception.getMessage());
            }
        }

        return winningLottoNumbers;
    }

    private LottoNumber generateBonusNumber() {
        LottoNumber bonusNumber = null;

        while (bonusNumber == null) {
            int number = ConsoleHandler.inputIntValue("보너스 번호를 입력해 주세요.");

            bonusNumber = new LottoNumber(number);
        }

        return bonusNumber;
    }

    private List<Integer> stringToIntegerList(String value) {
        try {
            return Arrays.stream(value.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("int형으로 변환할 수 없습니다.");
        }
    }
}
