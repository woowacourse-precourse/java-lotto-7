package lotto.controller;

import lotto.*;
import lotto.enums.LottoPrices;
import lotto.exception.LottoExceptionMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;
    private final LottoNumberMatcher lottoNumberMatcher;

    public LottoController(){
        this.inputView=new InputView();
        this.outputView=new OutputView();
        this.lottoGenerator = new LottoGenerator();
        this.lottoNumberMatcher = new LottoNumberMatcher();
    }

    public void run(){
        int givenMoneyForPurchase = getPurchaseMoney();

        List<Lotto> givenLotto = getPurchasedLottos(givenMoneyForPurchase);
        List<Integer> givenNumbers = getWinningNumbers();

        int bonusNumber = getBonusNumber(givenNumbers);

        if(givenNumbers.stream().anyMatch(num->num==bonusNumber)){
            throw new IllegalArgumentException(LottoExceptionMessage.LOTTO_NUM_DUPLICATED.getMessage());
        }

        Lotto winningLotto = lottoGenerator.generate(givenNumbers);
        List<LottoPrices> matched = lottoNumberMatcher.matchAll(givenLotto,winningLotto,bonusNumber);

        outputWinningStatistics(matched, givenMoneyForPurchase);
    }

    private int getPurchaseMoney(){
        outputView.outputLine("구입 금액을 입력해 주세요");

        while(true) {
            try{
                int money;
                if((money = inputView.getInt()) % 1000 != 0 && money == 0){
                    throw new IllegalArgumentException(LottoExceptionMessage.PURCHASING_MONEY_LASTED.getMessage());
                }
                outputView.outputLine();
                return money;
            } catch (IllegalArgumentException e){
                outputView.outputLine(e.getMessage());
            }
        }
    }

    private int getBonusNumber(List<Integer> numbers){
        outputView.outputLine("보너스 번호를 입력해 주세요");
        while(true) {
            try{
                int bonusNum;
                if(numbers.contains(bonusNum = inputView.getInt())){
                    throw new IllegalArgumentException(LottoExceptionMessage.LOTTO_NUM_DUPLICATED.getMessage());
                }
                outputView.outputLine();
                return bonusNum;
            } catch (IllegalArgumentException e){
                outputView.outputLine(e.getMessage());
            }
        }
    }

    private List<Integer> getWinningNumbers(){
        outputView.outputLine("당첨 번호를 입력해 주세요.");

        while(true) {
            try{
                List<Integer> parse = Parser.select(LottoNumberParser.class).parse(inputView.input());
                outputView.outputLine();
                return parse;
            } catch (IllegalArgumentException e){
                outputView.outputLine(e.getMessage());
            }
        }
    }

    private List<Lotto> getPurchasedLottos(int givenMoneyForPurchase){
        List<Lotto> generatedLottos = lottoGenerator.generate(givenMoneyForPurchase);

        outputView.outputLine(generatedLottos.size() + "개를 구매했습니다.");
        generatedLottos.forEach(lotto -> outputView.outputLine(lotto.toString()));
        outputView.outputLine();

        return generatedLottos;
    }

    private void outputWinningStatistics(List<LottoPrices> lottoPrices, int givenMoneyForPurchase){
        outputView.outputLine("당첨 통계\n---");

        LottoPrices.getPrices().forEach(price-> {
            long count = lottoPrices.stream().filter(picked -> picked.equals(price)).count();
            outputView.outputLine(price.getString()+count+"개");
        });

        BigDecimal totalPrices = BigDecimal.ZERO;
        for(long price: lottoPrices.stream().mapToLong(LottoPrices::getPrice).toArray()){
            totalPrices = totalPrices.add(BigDecimal.valueOf(price));
        }

        BigDecimal ans = BigDecimal.valueOf(100 / (double)givenMoneyForPurchase);
        BigDecimal earningRate = totalPrices.multiply(ans).round(new MathContext(3));

        outputView.outputLine("총 수익률은 "+earningRate+"%입니다.");
    }
}
