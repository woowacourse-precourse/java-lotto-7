package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;
import lotto.domain.exception.InvalidBonusNumberException;
import lotto.domain.exception.InvalidLottoNumberException;
import lotto.domain.exception.InvalidPriceException;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    static LottoService lottoService = new LottoService();
    static int savePoint = 0;

    public static void main(String[] args) {
        while (true) {
            try {
                List<Integer> winners = List.of();
                if (savePoint == 0) {
                    int price = InputView.getPrice();
                    List<Lotto> lottos = lottoService.buy(price);
                    OutputView.printLotto(lottos);
                    savePoint++;
                }

                if (savePoint == 1) {
                    winners = InputView.getWinnerNumbers();
                    savePoint++;
                }
                if (savePoint == 2) {
                    int bonus = InputView.getBonusNumber();
                    WinningResult result = lottoService.getResult(winners, bonus);
                    OutputView.printWinning(result);
                    savePoint++;
                }
                break;
            } catch (InvalidPriceException e) {
                System.out.println("[ERROR] " + e.getMessage());
                savePoint = 0;
            } catch (InvalidLottoNumberException e) {
                System.out.println("[ERROR] " + e.getMessage());
                savePoint = 1;
            } catch (InvalidBonusNumberException e) {
                System.out.println("[ERROR] " + e.getMessage());
                savePoint = 2;
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
