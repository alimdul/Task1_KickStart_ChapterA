package test.by.pivovarevich.task1.validation;

import by.pivovarevich.task1.validation.ValidationOnData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidationOnDataPositiveTest {

    @Test
    public void validationOnDataPositiveTest() {

        String string = "1.0 1.0 1.0 2.0 2.0 2.0 3.0 3.0 3.0";

        ValidationOnData validationOnData = new ValidationOnData();
        boolean isValid = validationOnData.validation(string);

        Assert.assertEquals(isValid, true);
    }
}