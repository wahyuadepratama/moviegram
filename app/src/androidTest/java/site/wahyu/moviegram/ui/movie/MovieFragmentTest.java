package site.wahyu.moviegram.ui.movie;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import site.wahyu.moviegram.R;
import site.wahyu.moviegram.testing.SingleFragmentActivity;
import site.wahyu.moviegram.utils.helper.EspressoIdlingResource;
import site.wahyu.moviegram.utils.RecyclerViewItemCountAssertion;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MovieFragmentTest {

    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private MovieFragment movieFragment = new MovieFragment();

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
        activityRule.getActivity().setFragment(movieFragment);
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadNowPlayingMovie() {
        onView(withId(R.id.rv_now_playing)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_now_playing)).check(new RecyclerViewItemCountAssertion(20));
    }

    @Test
    public void loadTopRatedMovie() {
        onView(withId(R.id.rv_top)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_top)).check(new RecyclerViewItemCountAssertion(20));
    }

    @Test
    public void loadUpcomingMovie() {
        onView(withId(R.id.rv_upcoming)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_upcoming)).check(new RecyclerViewItemCountAssertion(20));
    }
}