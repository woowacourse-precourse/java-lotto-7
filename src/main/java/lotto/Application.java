package lotto;

import java.util.Map;
import lotto.handler.ConsoleHandler;
import java.util.List;
import lotto.model.FirstRankLotto;
import lotto.model.Lotto;
import lotto.model.constant.LottoRank;
import lotto.parser.IntegerListParser;
import lotto.service.FirstRankLottoService;
import lotto.service.LottoService;
import lotto.service.LottoStatisticsService;
import lotto.view.LottoStatisticsView;

public class Application {

    private final Client client;

    private final LottoService lottoService;
    private final FirstRankLottoService firstRankLottoService;
    private final LottoStatisticsService lottoStatisticsService;
    private final IntegerListParser integerListParser;
    private final LottoStatisticsView lottoStatisticsView;

    public Application() {
        this.client = new Client();
        this.lottoService = new LottoService();
        this.firstRankLottoService = new FirstRankLottoService();
        this.lottoStatisticsService = new LottoStatisticsService();
        this.integerListParser = new IntegerListParser();
        this.lottoStatisticsView = new LottoStatisticsView();
    }

    public static void main(String[] args) {
        Application application = new Application();

        application.run();
    }

    private void run() {
        buyLotto();
        FirstRankLotto firstRankLotto = generateFirstRankLotto();
        annouceLottoStatistics(firstRankLotto);
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

    private FirstRankLotto generateFirstRankLotto() {
        List<Integer> firstRankLottoNumbers = generateFirstRankLottoNumbers();
        int bonusNumber = generateBonusNumber(firstRankLottoNumbers);

        return new FirstRankLotto(firstRankLottoNumbers, bonusNumber);
    }

    private void annouceLottoStatistics(FirstRankLotto firstRankLotto) {
        Map<LottoRank, Integer> lottoStatistics = getLottoStatistics(firstRankLotto);

        lottoStatisticsView.announce(lottoStatistics);
    }

    private Map<LottoRank, Integer> getLottoStatistics(FirstRankLotto firstRankLotto) {
        List<Lotto> lottos = client.getLottos();

        return lottoStatisticsService.getStatistics(lottos, firstRankLotto);
    }

    private List<Integer> generateFirstRankLottoNumbers() {
        List<Integer> firstRankLottoNumbers = null;

        while (firstRankLottoNumbers == null) {
            try {
                String input = ConsoleHandler.inputStringValue("당첨 번호를 입력해 주세요.");
                List<Integer> parsedInput = integerListParser.parse(input, ",");
                firstRankLottoService.validateNumbers(parsedInput);
                firstRankLottoNumbers = parsedInput;
            } catch (IllegalArgumentException exception) {
                ConsoleHandler.announceError(exception.getMessage());
            }
        }

        return firstRankLottoNumbers;
    }

    private int generateBonusNumber(List<Integer> firstRankLottoNumbers) {
        Integer bonusNumber = null;

        while (bonusNumber == null) {
            try {
                int input = ConsoleHandler.inputIntValue("보너스 번호를 입력해 주세요.");

                firstRankLottoService.validateBonusNumber(firstRankLottoNumbers, input);
                bonusNumber = input;
            } catch (IllegalArgumentException exception) {
                ConsoleHandler.announceError(exception.getMessage());
            }
        }

        return bonusNumber;
    }
}
