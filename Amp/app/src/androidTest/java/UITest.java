import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.cecilerobertm.amp.MainActivity;
import com.example.cecilerobertm.amp.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by cecilerobertm on 16-02-18.
 */
public class UITest {

    // Preferred JUnit 4 mechanism of specifying the activity to be launched before each test
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void TestValidInputStandardBelow() {
        // Type text and then press the button.
        onView(withId(R.id.length))
                .perform(typeText("150"), closeSoftKeyboard());
        onView(withId(R.id.width))
                .perform(typeText("150"), closeSoftKeyboard());
        onView(withId(R.id.weight))
                .perform(typeText("30"), closeSoftKeyboard());
        onView(withId(R.id.calculate_button)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.result_text))
                .check(matches(withText("$0.49")));
    }

    @Test
    public void TestValidInputStandardAbove() {
        // Type text and then press the button.
        onView(withId(R.id.length))
                .perform(typeText("150"), closeSoftKeyboard());
        onView(withId(R.id.width))
                .perform(typeText("150"), closeSoftKeyboard());
        onView(withId(R.id.weight))
                .perform(typeText("40"), closeSoftKeyboard());
        onView(withId(R.id.calculate_button)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.result_text))
                .check(matches(withText("$0.8")));
    }
    @Test
    public void TestValidInputNonStandardBelow() {
        // Type text and then press the button.
        onView(withId(R.id.length))
                .perform(typeText("150"), closeSoftKeyboard());
        onView(withId(R.id.width))
                .perform(typeText("150"), closeSoftKeyboard());
        onView(withId(R.id.weight))
                .perform(typeText("30"), closeSoftKeyboard());
        onView(withId(R.id.switch_standard)).perform(click());
        onView(withId(R.id.calculate_button)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.result_text))
                .check(matches(withText("$0.98")));
    }

    @Test
    public void TestValidInput() {
        // Type text and then press the button.
        onView(withId(R.id.length))
                .perform(typeText("150"), closeSoftKeyboard());
        onView(withId(R.id.width))
                .perform(typeText("150"), closeSoftKeyboard());
        onView(withId(R.id.weight))
                .perform(typeText("101"), closeSoftKeyboard());
        onView(withId(R.id.switch_standard)).perform(click());
        onView(withId(R.id.calculate_button)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.result_text))
                .check(matches(withText("$2.4")));
    }

}
