package repositories;

import java.util.ArrayList;
import java.util.List;

public class MarksRepositoryImpl implements MarksRepository{

    private List<Integer> marks;

    public MarksRepositoryImpl() {
        marks = new ArrayList<>();
    }

    @Override
    public void addMark(Integer mark){
        marks.add(mark);
    }

    @Override
    public List<Integer> getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "MarksRepositoryImpl{" +
                "marks=" + marks +
                '}';
    }
}
