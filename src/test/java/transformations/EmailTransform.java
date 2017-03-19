package transformations;

import cucumber.api.Transformer;

/**
 * Created by denni_6jm52yj on 04-Mar-17.
 */
public class EmailTransform extends Transformer<String> {

    @Override
    public String transform(String userName){

        return userName.concat("@ea.com");

    }


}
