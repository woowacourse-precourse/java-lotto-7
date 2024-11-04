package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class list_num {
    public List<ArrayList<Integer>> list(int num) {
        List<ArrayList<Integer>> listEach = new ArrayList<>(num);
        System.out.println(num + "개를 구매했습니다.");
        
        for (int i = 0; i < num; i++) {
            ArrayList<Integer> list = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            listEach.add(list);
            sort(listEach);
            System.out.println(listEach.get(i));
        }
        return listEach;
    }

    public void sort(List<ArrayList<Integer>> listEach) {
        for (ArrayList<Integer> list : listEach) {
            Collections.sort(list);
        }
    }
}