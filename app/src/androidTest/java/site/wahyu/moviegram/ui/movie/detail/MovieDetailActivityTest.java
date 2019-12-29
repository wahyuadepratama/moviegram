package site.wahyu.moviegram.ui.movie.detail;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import site.wahyu.moviegram.R;
import site.wahyu.moviegram.data.remote.model.Movie;
import site.wahyu.moviegram.utils.config.Config;
import site.wahyu.moviegram.utils.helper.EspressoIdlingResource;
import site.wahyu.moviegram.utils.FakeDataDummy;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MovieDetailActivityTest {

    private Movie dummyMovie = FakeDataDummy.generateDummyDetailMovies().get(0);

    @Rule
    public ActivityTestRule<MovieDetailActivity> activityRule = new ActivityTestRule<MovieDetailActivity>(MovieDetailActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, MovieDetailActivity.class);
            result.putExtra(Config.EXTRA_MOVIES, dummyMovie);
            return result;
        }
    };

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadMovie() {
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovie.getTitle())));
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()));
        dummyMovie.setRelease_date("02 October 2019");
        onView(withId(R.id.tv_date)).check(matches(withText(String.format("Release Date : %s", dummyMovie.getRelease_date()))));
    }
}