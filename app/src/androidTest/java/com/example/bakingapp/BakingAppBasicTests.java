package com.example.bakingapp;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import org.junit.Rule;

import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)

public class BakingAppBasicTests {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule=new ActivityTestRule<> (MainActivity.class);

    @Test
    public void mainActivityTest(){
        onView(withId(R.id.myRecyclerView)).perform(click());
    }
    @Test
    public void ingredientsActivityBasicTest(){
        mainActivityTest();
        onView(withId(R.id.ingredientRecyclerView)).perform(click());
        onView(withId(R.id.ingredientButton)).perform(click());
        onView(withId(R.id.descriptionText)).check(matches(withText("0")));

    }
}
