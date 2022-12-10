package precourse.week3.domain.lottomaker;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator implements RandomNumberGenerator {

    public static final int START_NUMBER_INCLUSIVE = 1;
    public static final int END_NUMBER_INCLUSIVE = 45;
    public static final int NUMBER_COUNT = 6;

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER_INCLUSIVE, END_NUMBER_INCLUSIVE, NUMBER_COUNT);
        return sort(numbers);
    }

    private List<Integer> sort(List<Integer> numbers) {
        List<Integer> newNumbers = new ArrayList<>(numbers);
        Collections.sort(newNumbers);
        return newNumbers;
    }
}
