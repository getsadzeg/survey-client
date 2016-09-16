package pi.survey.steps;


import com.mauriciotogneri.greencoffee.GreenCoffeeSteps;
import com.mauriciotogneri.greencoffee.annotations.And;
import com.mauriciotogneri.greencoffee.annotations.Then;
import com.mauriciotogneri.greencoffee.annotations.When;

import pi.survey.R;

public class memberSteps extends GreenCoffeeSteps {
    @When("^I introduce an invalid members$")
    public void introduceInvalidMembers() {
        onViewWithId(R.id.editText4).type("3.14");
    }
    @And("^I press the login button$")
    public void IpressTheLoginButton() {
        onViewWithId(R.id.button).click();
    }
    @Then("^I see an error message saying 'Invalid members'$")
    public void anErrorMessage() {
        onViewWithText(R.string.error_msg);
    }
}
