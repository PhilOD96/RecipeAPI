package com.example.phil.bladerunner;

import org.junit.Test;

import static org.junit.Assert.*;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.action.ViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.EditText;
import android.widget.EditText;

import org.hamcrest.Matchers;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.not;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

     @Test
    public void testSearch() {
        // Click on the search icon
        onView(withId(R.id.simpleSearchView)).perform(click());

        // Type the text in the search field and submit the query
        onView(isAssignableFrom(EditText.class)).perform(typeText("Burger"), pressImeActionButton());


    }

@Test
    public void testSearchSuggestionDisplayed() {
        onView(withId(R.id.simpleSearchView)).perform(click());
        onView(isAssignableFrom(EditText.class)).perform(typeText("Lamb Curry"), pressImeActionButton());

        // Go back to previous screen
        pressBack();

        // Clear the text in search field
        onView(isAssignableFrom(EditText.class)).perform(clearText());

        // Enter the first letter of the previously searched word
        onView(isAssignableFrom(EditText.class)).perform(typeText("La"));

    }

    // @Test
    public void getRecipes() {
        onView(withId(R.id.value_recipe_name)).check(matches(withHint("Lamb Curry")));
        // enter name

         onView(withId(R.id.difficulty)).check(matches(withText("Easy")));
    }



}