package precourse.week3.domain.lottomaker;

import java.util.List;

@FunctionalInterface
public interface RandomNumberGenerator {

    List<Integer> generate();
}
