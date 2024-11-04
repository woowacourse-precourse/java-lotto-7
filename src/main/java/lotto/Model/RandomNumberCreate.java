package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberCreate {
    static private final int maxNumber=45; //로또 번호 최대 숫자
    static private final int minNumber=1;  //로또 번호 최소 숫자
    static private final int lottoNumberCount=6; //로또 번호의 개수
    private static List<Integer> lottoNumberList;

    public static List<Integer> setRandomNumbers(){
        lottoNumberList=Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, lottoNumberCount);
        List<Integer> lottoTicketNumberList = new ArrayList<>(lottoNumberList); //정렬을 하기위해 복사본 생성
        Collections.sort(lottoTicketNumberList);
        return lottoTicketNumberList;
    }





}
