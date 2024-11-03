package lotto;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LottoController {
    private LottoModel model;
    private LottoView view;
    private int purchasePrice;
    private int numberOfPurchases;
    private List<Lotto> lottoNumbers;
    private List<Integer> winningNumbers;
    private List<Integer> countMatched = new LinkedList<>();
    private int bonusNumber;
    private int countHasBonusNumber;

    public LottoController(LottoModel model, LottoView view){
        this.model = model;
        this.view = view;
        lottoNumbers = new LinkedList<>();
        winningNumbers = new LinkedList<>();
    }
    public void startLotto(){
        purchasePrice = view.getPurchasePrice();

        if(purchasePrice % 1000 != 0){
            // 예외 처리
        }
        // 로또 번호 생성
        numberOfPurchases = view.getNumberOfPurchase(purchasePrice);
        createLottoNumbers();
        view.printLottoNumbers(lottoNumbers);

        // 당첨 번호 입력
        String numberString = view.getWinningNumbers();
        splitAndParse(numberString);

        // 보너스 번호 입력
        bonusNumber = view.getBonusNumber();

        matchNumbers();
        double statistic = view.printMatchedResult(countMatched, countHasBonusNumber);
        statistic = (statistic / purchasePrice) * 100;

        view.finalResult(statistic);
    }
    public void createLottoNumbers(){
        // 로또 번호 생성 및 리스트에 추가
        for(int i = 0; i < numberOfPurchases; i++){
            Lotto pickedNumbers = new Lotto(model.getLottoNumber());
            pickedNumbers.sortNumbers();
            lottoNumbers.add(pickedNumbers);
        }
    }
    public void splitAndParse(String numberString){
        if(!numberString.matches("[0-9,]+")){
            throw new IllegalArgumentException("[ERROR] 당첨번호는 숫자와 콤마(,)로만 이루어져야합니다.");
        }
        for(String n:numberString.split(",")){
            winningNumbers.add(Integer.parseInt(n));
        }
    }
    public void matchNumbers(){
        Iterator<Lotto> iterator = lottoNumbers.listIterator();
        while(iterator.hasNext()){
            Lotto currentNumeberList = iterator.next();
            int count = currentNumeberList.getMatchedSize(winningNumbers);

            if(count == 5 && currentNumeberList.hasBonusNumber(bonusNumber)){
                countHasBonusNumber++;
            }
            else{
                countMatched.add(count);
            }
        }
    }

}
