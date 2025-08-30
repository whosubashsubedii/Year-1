import java.util.ArrayList;
import java.util.function.Predicate;

public class ConditionArrayList<T> extends ArrayList<T> {
    private Predicate<T> condition;

    public ConditionArrayList(Predicate<T> condition) {
        this.condition = condition;
    }

    public boolean isEligible(T item) {
        return condition.test(item);
    }

    @Override
    public boolean add(T item) {
        if (isEligible(item)) {
            return super.add(item);
        }
        return false;
    }
}

public class Main {
    public static void addRandomNumber(ArrayList<Integer> list) {
        int n;
        do {
            n = (int) (Math.random() * 100); // Generate random number
            if (list instanceof ConditionArrayList) {
                ConditionArrayList<Integer> conditionList = (ConditionArrayList<Integer>) list;
                if (conditionList.isEligible(n)) {
                    list.add(n);
                    break;
                }
            } else {
                list.add(n); // Regular ArrayList, add without checking
                break;
            }
        } while (true);
    }

    public static void main(String[] args) {
        ConditionArrayList<Integer> oddList = new ConditionArrayList<>(n -> n % 2 != 0); // Only odd numbers
        ConditionArrayList<Integer> evenList = new ConditionArrayList<>(n -> n % 2 == 0); // Only even numbers
        ArrayList<Integer> regularList = new ArrayList<>();

        addRandomNumber(oddList);
        addRandomNumber(evenList);
        addRandomNumber(regularList);

        System.out.println("Odd List: " + oddList);
        System.out.println("Even List: " + evenList);
        System.out.println("Regular List: " + regularList);
    }
}