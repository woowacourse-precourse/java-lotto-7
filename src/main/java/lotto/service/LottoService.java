package lotto.service;

import java.util.*;
import lotto.global.exception.Messages;

public class LottoService {
    private static final String GET_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUM_OF_LOTTO_MESSAGE = "개를 구매했습니다.";
    private static final Integer LOTTO_NUM_START = 1;
    private static final Integer LOTTO_NUM_END = 45;
    private static final Integer NUM_OF_LOTTO_NUMS = 6;
    private static final String GET_WINNING_NUM_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_NUM_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final Integer NUM_OF_WINNING_NUMS = 6;
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String CONTOUR = "---";
    private static final String COLLECT_MESSAGE = "개 일치";
    private static final String COLLECT_BONUS_MESSAGE = "보너스 볼 일치";
    private static final String WON = "원";


    // 구입 금액 입력받기
    public Integer inputPrice(){

        Scanner scanner = new Scanner(System.in);
        Integer price = 0;

        while (price!=0 && price%1000==0){
            System.out.println(GET_PRICE_MESSAGE);
            price = scanner.nextInt();

            if(price%1000!=0){
                throw new IllegalArgumentException(Messages.DEFAULT_ERROR + Messages.PRICE_ERROR);
            }
        }

        return price;
    }

    //로또 구매
    public List<List<Integer>> buy(Integer price){
        Integer num = price/1000;
        System.out.println(num+NUM_OF_LOTTO_MESSAGE);

        List<List<Integer>> myLotto = new ArrayList<>();

        for(int i=0;i<num;i++){
            List<Integer> lotto = getLotto();
            myLotto.add(lotto);
            System.out.println(lotto);
        }

        return myLotto;
    }

    //로또 발행 메서드
    private List<Integer> getLotto() {
        Set<Integer> numbers = new HashSet<>();

        Random random = new Random();

        while (numbers.size() < NUM_OF_LOTTO_NUMS) {
            int num = random.nextInt(LOTTO_NUM_END) + LOTTO_NUM_START;
            numbers.add(num);
        }

        List<Integer> lottoNumbers = new ArrayList<>(numbers);
        Collections.sort(new ArrayList<>(lottoNumbers));

        return lottoNumbers;
    }

}
