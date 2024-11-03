package lotto.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.model.domain.Customer;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoManager;
import lotto.model.dto.LottoStatisticsResponse;
import lotto.model.dto.LottosResponse;
import lotto.model.repository.LottoRepository;
import lotto.model.service.parser.NumberParser;

public class LottoService {

    private final LottoRepository lottoRepository;
    private final LottoManager lottoManager;

    public LottoService() {
        this.lottoRepository = new LottoRepository();
        this.lottoManager = new LottoManager();
    }

    public Integer savePayment(String payment) {
        Customer customer = new Customer(payment);
        lottoRepository.saveCustomer(customer);
        return customer.getId();
    }

    public LottosResponse issueLottos(Integer customerId) {
        Customer customer = lottoRepository.findById(customerId);
        int count = customer.getPayment() / 1000;

        List<Lotto> generatedLottos = IntStream.range(0, count)
                .mapToObj(iter -> {
                    List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                    numbers.sort(Integer::compareTo);
                    return new Lotto(numbers);
                })
                .toList();

        lottoRepository.updateCustomerLottos(customerId, generatedLottos);
        return new LottosResponse(generatedLottos);
    }

    public String saveWinningLottos(String winningNumbers) {
        List<Integer> numbers = NumberParser.parseWinningNumbers(winningNumbers);
        lottoManager.saveWinningLotto(new Lotto(numbers));
        return "success";
    }

    public String saveBonusNumber(String bonusNumber) {
        Integer number = NumberParser.parseBonusNumber(bonusNumber.trim());
        lottoManager.saveBonusNumber(number);
        return "success";
    }

    public LottoStatisticsResponse statisticsWinningOfCustomerLottos(Integer customerId) {
        Customer customer = lottoRepository.findById(customerId);
        List<Lotto> customerLottos = customer.getLottos();

        Map<String, Integer> statistics = lottoManager.statisticsCustomerWinning(customerLottos);
        BigDecimal revenueOfLottos = lottoManager.getRateOfRevenue(customer.getPayment());
        LottoStatisticsResponse response = new LottoStatisticsResponse(statistics, revenueOfLottos);

        lottoManager.clearCustomerWinningDetails();

        return response;
    }
}
