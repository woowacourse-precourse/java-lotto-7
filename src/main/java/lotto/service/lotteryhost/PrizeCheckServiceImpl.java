package lotto.service.lotteryhost;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lotto.domain.CriteriaTool;
import lotto.repository.LottoTicketRepository;
import lotto.service.constant.prize.PrizeCondition;
import lotto.service.constant.prize.PrizeConditionImpl;

public class PrizeCheckServiceImpl implements PrizeCheckService {

    private final LottoTicketRepository lottoTicketRepository;
    private final CriteriaTool prizeCheckMachine;

    public PrizeCheckServiceImpl(CriteriaTool criteriaTool) {
        this.lottoTicketRepository = LottoTicketRepository.getTicket();
        this.prizeCheckMachine = criteriaTool;
    }

    @Override
    public Optional<PrizeCondition> result() {
        List<Integer> unrevealed = lottoTicketRepository.getGame();

        if(mainNumbers(unrevealed).equals(PrizeConditionImpl.SECOND_OR_THREE_PRIZE.getCorrectNumber())) {
            return Optional.ofNullable(evaluateSecondOrThirdPrize(unrevealed));
        }

        return Optional.ofNullable(evaluateOrder(unrevealed));
    }

    private PrizeCondition evaluateOrder (List<Integer> game) {
        return Arrays.stream(PrizeConditionImpl.values())
                .filter(prizeRequire -> prizeRequire.getCorrectNumber().equals(mainNumbers(game)))
                .findFirst().orElse(null);
    }

    private PrizeCondition evaluateSecondOrThirdPrize(List<Integer> game) {
        if(luckyNumberExist(game)) {
            return PrizeConditionImpl.SECOND_PRIZE;
        }
        return PrizeConditionImpl.THIRD_PRIZE;
    }

    private Long mainNumbers (List<Integer> game) {
        return prizeCheckMachine.matchingMainNumbers(game);
    }

    private Boolean luckyNumberExist(List<Integer> game) {
        return prizeCheckMachine.matchingLuckyNumber(game);
    }

}
