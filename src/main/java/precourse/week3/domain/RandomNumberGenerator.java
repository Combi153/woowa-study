package precourse.week3.domain;

import java.util.List;

@FunctionalInterface
public interface RandomNumberGenerator {

    List<Integer> generate();
}