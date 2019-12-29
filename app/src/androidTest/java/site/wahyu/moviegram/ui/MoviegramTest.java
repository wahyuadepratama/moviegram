package site.wahyu.moviegram.ui;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.google.android.material.tabs.TabLayout;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import site.wahyu.moviegram.R;
import site.wahyu.moviegram.ui.home.HomeActivity;
import site.wahyu.moviegram.utils.helper.EspressoIdlingResource;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

public class MoviegramTest {
    @Rule
    public ActivityTestRule<HomeActivity> activityRule = new ActivityTestRule<>(HomeActivity.class);

    @Before
    public void toMovieFragment() {
        onView(withId(R.id.navigation_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.navigation_movie)).perform(click());
    }

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void toNowPlayingMovieFragment() {
        onView(withId(R.id.img_ic_now_playing)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_now_playing)).check(matches(isDisplayed()));
        onView(withId(R.id.img_ic_now_playing)).perform(click());
        onView(withId(R.id.back_btn)).check(matches(isDisplayed()));
        onView(withId(R.id.back_btn)).perform(click());
    }

    @Test
    public void toTopRatedMovieFragment() {
        onView(withId(R.id.img_ic_top_rated)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_top)).check(matches(isDisplayed()));
        onView(withId(R.id.img_ic_top_rated)).perform(click());
        onView(withId(R.id.back_btn)).check(matches(isDisplayed()));
        onView(withId(R.id.back_btn)).perform(click());
    }

    @Test
    public void toUpcomingMovieFragment() {
        onView(withId(R.id.img_ic_upcoming)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_upcoming)).check(matches(isDisplayed()));
        onView(withId(R.id.img_ic_upcoming)).perform(click());
        onView(withId(R.id.back_btn)).check(matches(isDisplayed()));
        onView(withId(R.id.back_btn)).perform(click());
    }

    @Test
    public void toTVShowFragment() {
        onView(withId(R.id.navigation_tvshow)).check(matches(isDisplayed()));
        onView(withId(R.id.navigation_tvshow)).perform(click());
    }

    @Test
    public void toMovieDetailActivityFromMovieFragment() {
        onView(withId(R.id.rv_now_playing)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_desc)).check(matches(isDisplayed()));
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()));
    }

    @Test
    public void toMovieDetailActivityFromNowPlayingMovieFragment() {
        onView(withId(R.id.img_ic_now_playing)).perform(click());
        onView(withId(R.id.rv_movie_more)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_desc)).check(matches(isDisplayed()));
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()));
    }

    @Test
    public void toMovieDetailActivityFromUpcomingMovieFragment() {
        onView(withId(R.id.img_ic_upcoming)).perform(click());
        onView(withId(R.id.rv_movie_more)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_desc)).check(matches(isDisplayed()));
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()));
    }

    @Test
    public void toMovieDetailActivityFromTopRatedMovieFragment() {
        onView(withId(R.id.img_ic_top_rated)).perform(click());
        onView(withId(R.id.rv_movie_more)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_desc)).check(matches(isDisplayed()));
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()));
    }

    @Test
    public void toTVShowDetailActivity() {
        onView(withId(R.id.navigation_tvshow)).perform(click());
        onView(withId(R.id.rv_movie_more)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()));
    }

    @Test
    public void toFavoriteMovieFragment(){
        onView(withId(R.id.navigation_favorite)).check(matches(isDisplayed()));
        onView(withId(R.id.navigation_favorite)).perform(click());
        onView(withId(R.id.result_tabs)).check(matches(isDisplayed()));
        onView(withId(R.id.result_tabs)).perform(selectTabAtPosition(0)).check(matches(isDisplayed()));
    }

    @Test
    public void toFavoriteTVShowFragment(){
        onView(withId(R.id.navigation_favorite)).check(matches(isDisplayed()));
        onView(withId(R.id.navigation_favorite)).perform(click());
        onView(withId(R.id.result_tabs)).check(matches(isDisplayed()));
        onView(withId(R.id.result_tabs)).perform(selectTabAtPosition(1)).check(matches(isDisplayed()));
    }

    @NonNull
    private static ViewAction selectTabAtPosition(int position) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return allOf(isDisplayed(), isAssignableFrom(TabLayout.class));
            }

            @Override
            public String getDescription() {
                return "with tab at index" + position;
            }

            @Override
            public void perform(UiController uiController, View view) {
                if (view instanceof TabLayout) {
                    TabLayout tabLayout = (TabLayout) view;
                    TabLayout.Tab tab = tabLayout.getTabAt(position);

                    if (tab != null) {
                        tab.select();
                    }
                }
            }
        };
    }
}
