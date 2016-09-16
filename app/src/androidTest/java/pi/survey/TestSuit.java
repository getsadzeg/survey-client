package pi.survey;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import pi.survey.features.MembersFeatureTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MembersFeatureTest.class,
})
public class TestSuit {


}
