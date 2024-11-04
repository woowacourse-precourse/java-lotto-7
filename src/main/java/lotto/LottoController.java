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
        // 로또 정보 생성 및 저장
        setLottoInfo();

        // 로또 번호 매치
        matchNumbers();

        // 당첨 결과 출력 및 수익률 계산
        double statistic = view.printMatchedResult(countMatched, countHasBonusNumber);
        statistic = (statistic / purchasePrice) * 100;

        view.finalResult(statistic);
    }
    public void setLottoInfo(){
        // 로또 구입 금액 입력 받고 적절한 입력인지 확인
        while(!setValidPurchasePrice());

        // 로또 번호 생성 및 출력
        numberOfPurchases = view.getNumberOfPurchase(purchasePrice);
        createLottoNumbers();
        view.printLottoNumbers(lottoNumbers);

        // 당첨 번호 입력 및 저장
        while(!validWinningNumber());

        // 보너스 번호 입력
        bonusNumber = view.getBonusNumber();
    }
    public boolean setValidPurchasePrice(){
        try {
            // 구매 금액 String으로 입력 받고 Integer로 형변환
            purchasePrice = Integer.parseInt(view.getPurchasePrice());
            return true;
        }catch (NumberFormatException e){
            // 숫자 이외의 문자가 포함 돼 있으면 NumberFormatException 발생
            System.out.println("\n[ERROR] 구매금액은 숫자로만 작성해야합니다.");
            return false;
        }
    }
    public void createLottoNumbers(){
        // 로또 번호 생성 및 리스트에 추가
        for(int i = 0; i < numberOfPurchases; i++){
            try {
                lottoNumbers.add(model.getLottoNumber());
            }catch (IllegalArgumentException e){
                // 로또 번호 개수가 6개가 아니거나 중복된 숫자가 포함 돼 있을 경우 예외 발생
                // i-- 후 로또 번호 재생성
                System.out.println(e.getMessage());
                i--;
            }
        }
    }
    public void setWinninNumber(String numberString){
        // 당첨 번호 리스트에 저장
        for(String n:numberString.split(",")){
            winningNumbers.add(Integer.parseInt(n));
        }
        // 객체 생성 하여 validate Number인지 확인
        Lotto winningLotto = new Lotto(winningNumbers);
    }
    public boolean validWinningNumber(){
        // 당첨 번호 입력 받기
        // 적절하지 않은 입력일 때 예외 발생
        // ex)숫자와 콤마 이외의 문자가 포함 등
        try{
            String numberString = view.getWinningNumbers();
            if(!numberString.matches("[0-9,]+")){
                throw new IllegalArgumentException("\n[ERROR] 당첨번호는 숫자와 콤마(,)로만 이루어져야합니다.");
            }
            setWinninNumber(numberString);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
            return false;
        }
    }
    public void matchNumbers(){
        // 구매 로또와 당첨 번호 매치
        // 몇 개 일치하는지 count 후 리스트에 count 저장
        Iterator<Lotto> iterator = lottoNumbers.listIterator();
        while(iterator.hasNext()){
            Lotto currentNumeberList = iterator.next();
            int count = currentNumeberList.getMatchedSize(winningNumbers);

            // 숫자가 5개 일치 + 보너스 번호 O
            if(count == 5 && currentNumeberList.hasBonusNumber(bonusNumber)){
                countHasBonusNumber++;
                continue;
            }
            countMatched.add(count);
        }
    }
}
