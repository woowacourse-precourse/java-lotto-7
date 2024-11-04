package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.model.LottoResult;
import lotto.service.LottoService;
import lotto.type.SystemMessage;
import lotto.util.LoopTemplate;

import java.util.List;
import java.util.Set;

import static lotto.util.Printer.breakLine;
import static lotto.util.Printer.print;

public class GameController {
    private User user;

    public int getLottoTickets() {
        return new LoopTemplate<Integer>() {
            @Override
            protected Integer doLoop() {
                print(SystemMessage.INPUT_PURCHASE_AMOUNT);
                user = User.createUser(Console.readLine());
                breakLine();

                int lottoTickets = user.getLottoTickets();
                print(lottoTickets, SystemMessage.RESULT_PURCHASED);
                return lottoTickets;
            }
        }.execute();
    }

    public List<Lotto> generateLottoNumbers(int lottoTickets) {
        return new LoopTemplate<List<Lotto>>() {
            @Override
            protected List<Lotto> doLoop() throws IllegalArgumentException {
                List<Lotto> lottoList = LottoService.generateLottoList(lottoTickets);
                user.setUpLottoList(lottoList);
                breakLine();
                return user.getLottoList();
            }
        }.execute();
    }


    public Set<Integer> getWinningNumbers() {
        return new LoopTemplate<Set<Integer>>() {
            @Override
            protected Set<Integer> doLoop() throws IllegalArgumentException {
                print(SystemMessage.INPUT_WINNING_NUMBER);
                user.setWinningNumbers(Console.readLine());
                breakLine();
                return user.getWinningNumbers();
            }
        }.execute();
    }

    public int getBonusNumber() {
        return new LoopTemplate<Integer>() {
            @Override
            protected Integer doLoop() throws IllegalArgumentException {
                print(SystemMessage.INPUT_BONUS_NUMBER);
                user.setBonusNumber(Console.readLine());
                breakLine();
                return user.getBonusNumber();
            }
        }.execute();
    }

    public void printResult(LottoResult lottoResult) {
        LottoService.printResult(lottoResult, user.getPurchaseAmount());
    }
}
