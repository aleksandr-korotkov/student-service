package repositories;

import java.util.List;

public interface MarksRepository {

    List<Integer> getMarks();

    void addMark(Integer mark);
}
