package site.wahyu.moviegram.ui.movie.nowplayingmovie;

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

public class NowPlayingMovieFragmentTest {

    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private NowPlayingMovieFragment nowPlayingMovieFragment = new NowPlayingMovieFragment();

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
        activityRule.getActivity().setFragment(nowPlayingMovieFragment);
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadMovie() {
        onView(withId(R.id.rv_movie_more)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie_more)).check(new RecyclerViewItemCountAssertion(20));
    }
}