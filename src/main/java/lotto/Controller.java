package lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Controller {
    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENT = 100;

    private static LottoMachine lotto;
    private static final List<Lotto> userLottos = new ArrayList<>();
    private static final Map<LottoMatch, Integer> match = new EnumMap<>(LottoMatch.class);

    public void run() {
        while (true) {
            try {
                start();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("처음으로 돌아갑니다.");
            }
        }
    }

    public void start() {
        lotto = new LottoMachine(InputView.inputUserAmount());
        int tickets = lotto.buyLottoTickets();
        OutputView.outputLottoAmount(tickets);
        generateLotto(tickets);
        Lotto winningNumber = new Lotto(InputView.inputUserWinningNumber());
        int bonus = InputView.inputUserBonusNumber();
        winningNumber.checkForBonusNumberDuplicates(bonus);
        lottoMatch(winningNumber, bonus);
        calculatePrizeTotal(tickets);

    }

    public void generateLotto(int buyTicket) {
        for (int i = 0; i < buyTicket; i++) {
            Lotto userLotto = new Lotto(UserLottoGenerator.lottoGenerate());
            userLottos.add(userLotto);
            userLotto.outputLottoNumbers();
        }
    }

    public void lottoMatch(Lotto winningNumber, int bonus) {
        for (Lotto userLotto : userLottos) {
            int matchCount = userLotto.MatchCount(winningNumber);
            boolean matchBonus = userLotto.contains(bonus);

            LottoMatch lottoMatch = LottoMatch.getLottoMatch(matchCount, matchBonus);
            if (lottoMatch != null) {
                match.put(lottoMatch, match.getOrDefault(lottoMatch, 0) + 1);
            }
        }
        OutputView.outputMatchResult(match);
    }

    public void calculatePrizeTotal(int lottoTickets) {
        int totalPrize = match.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        int Tickets = lotto.buyLottoTickets() * LOTTO_PRICE;
        double rateOfReturn = ((double) totalPrize / Tickets) * PERCENT;
        OutputView.outputPrizeTotal(rateOfReturn);
    }


}
