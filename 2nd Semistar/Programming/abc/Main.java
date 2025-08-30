import java.util.ArrayList;

public class Main 
{
    public static void addRandomNumber(ArrayList<Integer> list) 
    {
        int n;
        do {
            n = (int) (Math.random() * 100); // yesko kam chai generate random number create garxam
            if (list instanceof ConditionArrayList) 
            {
                ConditionArrayList<Integer> conditionList = (ConditionArrayList<Integer>) list;
                if (conditionList.isEligible(n)) 
                {
                    list.add(n);
                    break;
                }
            } else 
            {
                list.add(n); // Regular ArrayList, add without checking
                break;
            }
        } while (true);
    }

    public static void main(String[] args) 
    {
        ConditionArrayList<Integer> oddList = new ConditionArrayList<>(n -> n % 2 != 0); // yesko kam only odd numbers check garne 
        ConditionArrayList<Integer> evenList = new ConditionArrayList<>(n -> n % 2 == 0); // yesko kam only even numbers
        ArrayList<Integer> regularList = new ArrayList<>();

        addRandomNumber(oddList);
        addRandomNumber(evenList);
        addRandomNumber(regularList);

        System.out.println("Odd List: " + oddList);
        System.out.println("Even List: " + evenList);
        System.out.println("Regular List: " + regularList);
    }
}