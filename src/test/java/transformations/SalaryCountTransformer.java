package transformations;

import cucumber.api.Transformer;

/**
 * Created by denni_6jm52yj on 04-Mar-17.
 */
public class SalaryCountTransformer extends Transformer<Integer> {

    @Override
    public Integer transform(String salary)
    {
        return salary.length();
    }
}
