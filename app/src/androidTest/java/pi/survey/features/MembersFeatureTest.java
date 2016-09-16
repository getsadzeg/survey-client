package pi.survey.features;

import android.support.test.rule.ActivityTestRule;

import com.mauriciotogneri.greencoffee.GreenCoffeeConfig;
import com.mauriciotogneri.greencoffee.GreenCoffeeTest;
import com.mauriciotogneri.greencoffee.Scenario;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;

import pi.survey.MainActivity;
import pi.survey.steps.memberSteps;

@RunWith(Parameterized.class)
public class MembersFeatureTest extends GreenCoffeeTest {
    @Rule
    public ActivityTestRule<MainActivity> activity = new ActivityTestRule<>(MainActivity.class);

    public MembersFeatureTest(Scenario scenario) {
        super(scenario);
    }

    





    @Parameterized.Parameters
    public static Iterable<Scenario> scenarios() throws IOException {
        return new GreenCoffeeConfig()
                .withFeatureFromAssets("assets/members.feature")
                .scenarios();
    }

    @Test
    public void test() {
        start(new memberSteps());
    }

}
