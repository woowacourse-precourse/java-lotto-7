package lotto.View.Output;

import lotto.model.Lotto;
import lotto.model.PrizeType;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Output {

    public void printInputCash(){
        System.out.println(OutputMessage.PAYMENT.getMessage());
    }

    public void printLottoCount(int lottoCount) {
        System.out.println(OutputMessage.PURCHASED_TICKETS_COUNT.getArgsMessage(lottoCount));
    }

    public void printGeneratedLotto(List<Lotto> winningLotto) {
        for(int i=0;i<winningLotto.size(); i++){
            Lotto lotto = winningLotto.get(i);
            System.out.println(OutputMessage.LOTTO_NUM.getArgsMessage(lotto.getNumbers()));
        }
    }

    public void printInputLottoNum(){
        System.out.println();
        System.out.println(OutputMessage.EXPECTED_LOTTO_NUM.getMessage());
    }

    public void printInputBonusNum(){
        System.out.println();
        System.out.println(OutputMessage.EXPECTED_BONUS_NUM.getMessage());
    }

    public void printWinningPrize(List<PrizeType> prizeTypes){
        System.out.println();
        System.out.println(OutputMessage.RESULT.getMessage());
        System.out.println(OutputMessage.DOTTED_LINE.getMessage());

        EnumMap<PrizeType, Integer> prizeCounts = new EnumMap<>(PrizeType.class);

        // prizeTypes에 있는 각 PrizeType의 개수를 EnumMap에 저장
        for (PrizeType prize : prizeTypes) {
            prizeCounts.put(prize, prizeCounts.getOrDefault(prize, 0) + 1);
        }

        // 모든 PrizeType에 대해 결과 메시지를 생성하고 출력
        for (PrizeType type : PrizeType.values()) {
            String prizeMessage = formatPrizeMessage(type, prizeCounts.getOrDefault(type, 0));
            System.out.println(prizeMessage);
        }

    }

    private String formatPrizeMessage(PrizeType prizeType, int count) {
        String bonusMessage = BONUS_MESSAGE_MAP.get(prizeType.getIsBonusBallMatch());
        String formattedPrizeAmount = String.format("%,d", prizeType.getPrizeAmount());
        return OutputMessage.RANK_COUNT.getArgsMessage(
                prizeType.getMatchNum(),
                bonusMessage,
                formattedPrizeAmount,
                count
        );
    }

    private static final Map<Boolean, String> BONUS_MESSAGE_MAP = Map.of(
            true, OutputMessage.BONUS.getMessage(),
            false, OutputMessage.NONE.getMessage()
    );

    public void printRateOfReturn(double rateOfReturn){
        System.out.println( OutputMessage.RATE_OR_RETURN.getArgsMessage(rateOfReturn));
    }

}
