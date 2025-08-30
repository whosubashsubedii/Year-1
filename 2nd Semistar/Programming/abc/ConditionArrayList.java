import java.util.ArrayList;
import java.util.function.Predicate;

public class ConditionArrayList<T> extends ArrayList<T> 
{
    private Predicate<T> condition;

    public ConditionArrayList(Predicate<T> condition) 
    {
        this.condition = condition;
    }

    public boolean isEligible(T item) 
    {
        return condition.test(item);
    }

    @Override
    public boolean add(T item) 
    {
        if (isEligible(item)) 
        {
            return super.add(item);
        }
        return false;
    }
}