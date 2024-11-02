package lotto.controller;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoRepository;
import lotto.validator.PriceValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import static lotto.constant.UtilConstants.MINIMUM_PRICE;


public class LottoController {

    private LottoRepository lottoRepository;
    private LottoGame lottoGame;
    private int purchasePrice;

    public LottoController(LottoRepository lottoRepository, LottoGame lottoGame){
        this.lottoRepository = lottoRepository;
        this.lottoGame = lottoGame;
    }

    public void run(){
        runPricePart();

        generateLottoNumbers();

        List<String> lottoNumbers = generateOutputString();
        OutputView.printPurchaseCount(purchasePrice/MINIMUM_PRICE);
        OutputView.printLottoNumbers(lottoNumbers);

    }

    private void runPricePart(){
        String purchaseAmount = InputView.getPurchaseAmount();
        PriceValidator priceValidator = new PriceValidator();
        try{
            priceValidator.validate(purchaseAmount);
            purchasePrice = Integer.parseInt(purchaseAmount);
        }catch(IllegalArgumentException e){
            OutputView.printError(e.getMessage());
            runPricePart();
        }
    }

    private void generateLottoNumbers(){
        lottoGame.setLottoCount(purchasePrice);
        lottoGame.generateLotto();
    }

    private List<String> generateOutputString(){
        List<String> generatedString = new ArrayList<>();

        List<Lotto> lottos = lottoRepository.getLottos();
        for(Lotto lotto: lottos){
            String singleGeneration = generateString(lotto.getNumbers());
            generatedString.add(singleGeneration);
        }
        return generatedString;
    }

    private String generateString(List<Integer> numbers){
        return numbers.toString();
    }
}
