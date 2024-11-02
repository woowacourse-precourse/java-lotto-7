package lotto;

import java.util.Map;
import java.util.List;
import lotto.model.FirstRankLotto;
import lotto.model.Lotto;
import lotto.model.constant.LottoRank;
import lotto.helper.ParseHelper;
import lotto.service.FirstRankLottoService;
import lotto.service.LottoRateOfReturnService;
import lotto.service.LottoService;
import lotto.service.LottoStatisticsService;
import lotto.view.ErrorView;
import lotto.view.LottoStatisticsView;
import lotto.view.LottoView;

public class Application {

    private final Client client;

    private final LottoService lottoService;
    private final FirstRankLottoService firstRankLottoService;
    private final LottoStatisticsService lottoStatisticsService;
    private final LottoRateOfReturnService lottoRateOfReturnService;
    private final ParseHelper parseHelper;

    public Application() {
        this.client = new Client();
        this.lottoService = new LottoService();
        this.firstRankLottoService = new FirstRankLottoService();
        this.lottoStatisticsService = new LottoStatisticsService();
        this.lottoRateOfReturnService = new LottoRateOfReturnService();
        this.parseHelper = new ParseHelper();
    }

    public static void main(String[] args) {
        Application application = new Application();

        application.run();
    }

    private void run() {
        buyLotto();
        FirstRankLotto firstRankLotto = generateFirstRankLotto();
        annouceLottoStatistics(firstRankLotto);
        annouceLottoRateOfReturn(firstRankLotto);
    }

    private void buyLotto() {
        while (client.getLottos().isEmpty()) {
            try {
                String input = LottoView.inputBuyAmount();
                int buyAmount = parseHelper.parseInt(input);
                List<Lotto> lottos = lottoService.buy(buyAmount);
                client.addLotto(lottos);
            } catch (IllegalArgumentException exception) {
                ErrorView.announceError(exception);
            }
        }

        LottoView.announceBoughtLotto(client.getLottos());
    }

    private FirstRankLotto generateFirstRankLotto() {
        List<Integer> firstRankLottoNumbers = generateFirstRankLottoNumbers();
        int bonusNumber = generateBonusNumber(firstRankLottoNumbers);

        return new FirstRankLotto(firstRankLottoNumbers, bonusNumber);
    }

    private void annouceLottoStatistics(FirstRankLotto firstRankLotto) {
        Map<LottoRank, Integer> lottoStatistics = getLottoStatistics(firstRankLotto);

        LottoStatisticsView.announceStatistics(lottoStatistics);
    }

    private void annouceLottoRateOfReturn(FirstRankLotto firstRankLotto) {
        double rateOfReturn = getLottoRateOfReturn(firstRankLotto);

        LottoStatisticsView.announcePercentOfReturn(rateOfReturn);
    }

    private Map<LottoRank, Integer> getLottoStatistics(FirstRankLotto firstRankLotto) {
        List<Lotto> lottos = client.getLottos();

        return lottoStatisticsService.getStatistics(lottos, firstRankLotto);
    }

    private double getLottoRateOfReturn(FirstRankLotto firstRankLotto) {
        List<Lotto> lottos = client.getLottos();

        return lottoRateOfReturnService.getRateOfReturn(lottos, firstRankLotto);
    }

    private List<Integer> generateFirstRankLottoNumbers() {
        List<Integer> firstRankLottoNumbers = null;

        while (firstRankLottoNumbers == null) {
            try {
                String input = LottoView.inputFirstRankNumbers();
                List<Integer> parsedInput = parseHelper.parseIntegerList(input, ",");
                firstRankLottoService.validateNumbers(parsedInput);
                firstRankLottoNumbers = parsedInput;
            } catch (IllegalArgumentException exception) {
                ErrorView.announceError(exception);
            }
        }

        return firstRankLottoNumbers;
    }

    private int generateBonusNumber(List<Integer> firstRankLottoNumbers) {
        Integer bonusNumber = null;

        while (bonusNumber == null) {
            try {
                String input = LottoView.inputBonusNumber();
                int parsedInput = parseHelper.parseInt(input);
                firstRankLottoService.validateBonusNumber(firstRankLottoNumbers, parsedInput);
                bonusNumber = parsedInput;
            } catch (IllegalArgumentException exception) {
                ErrorView.announceError(exception);
            }
        }

        return bonusNumber;
    }
}
