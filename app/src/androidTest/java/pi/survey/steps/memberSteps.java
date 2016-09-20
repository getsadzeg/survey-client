package pi.survey.steps;


import android.support.test.espresso.Espresso;

import com.mauriciotogneri.greencoffee.GreenCoffeeSteps;
import com.mauriciotogneri.greencoffee.annotations.Given;
import com.mauriciotogneri.greencoffee.annotations.Then;
import com.mauriciotogneri.greencoffee.annotations.When;

import pi.survey.R;

public class memberSteps extends GreenCoffeeSteps {
    @Given("^I see an empty login form")
    public void iSeanemptyloginform() {
        onViewWithId(R.id.editText).isEmpty();
        onViewWithId(R.id.editText2).isEmpty();
        onViewWithId(R.id.editText3).isEmpty();
        onViewWithId(R.id.editText4).isEmpty();
    }
    @When("^I introduce an invalid members$")
    public void introduceInvalidMembers() {
        onViewWithId(R.id.editText4).type("50");
        Espresso.closeSoftKeyboard();
        //onViewWithId(R.id.editText4).scrollTo().click();
    }
    @When("^I press the login button$")
    public void iPressTheLoginButton()
    {

        onViewWithId(R.id.button).click();
    }
    @Then("^I see an error message saying 'Invalid members'$")
    public void anErrorMessage() {
        onViewWithText(R.string.error_msg);
    }
}
