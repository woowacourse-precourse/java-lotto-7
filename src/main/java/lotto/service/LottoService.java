package lotto.service;

import java.util.List;
import java.util.stream.Stream;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoMatchingMachine;
import lotto.model.LottoNumberGenerator;

public class LottoService {
    private final PolicyService policyService;
    private final LottoNumberGenerator numberGenerator;

    public LottoService() {
        this.policyService = new PolicyService();
        this.numberGenerator = new LottoNumberGenerator(policyService);
    }

    public List<Lotto> buyLottos(int lottoTicketCount){
        return Stream.generate(this::buyLotto)
                .limit(lottoTicketCount)
                .toList();
    }

    public int getLottoTicketCount(int money) {
        return money / policyService.getLottoTicketPrice();
    }

    private Lotto buyLotto(){
        return new Lotto(numberGenerator.generate());
    }

    public int getLottoMatchCount(Lotto lotto, Bonus bonus, Lotto boughtLotto){
       LottoMatchingMachine matchingMachine = new LottoMatchingMachine(lotto, bonus);
       return matchingMachine.match(boughtLotto);
    }

    public boolean isBonusMatched(Lotto lotto, Bonus bonus, Lotto boughtLotto){
        LottoMatchingMachine matchingMachine = new LottoMatchingMachine(lotto, bonus);
        return matchingMachine.isBonusMatch(boughtLotto);
    }

    public Lotto generateLotto(List<Integer> numbers){
        return new Lotto(numbers);
    }

    public Bonus generateBonus(int number){
        return new Bonus(number);
    }
}
