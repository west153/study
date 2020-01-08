package com.example.mvvmcalc

import android.app.Activity
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.mvvmcalc.view.MainActivity
import org.hamcrest.CoreMatchers
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class MainActivityTest {

  @Test
  fun clickButtonNum123Test() {
    //given - launch activity
    launchActivity()

    // when - click button 1,2,3
    onView(withId(R.id.btnNum1)).perform(click())
    onView(withId(R.id.btnNum2)).perform(click())
    onView(withId(R.id.btnNum3)).perform(click())


    //then - check input text
    onView(withId(R.id.input)).check(matches(withText("123")))
  }

  @Test
  fun clickButtonNum456Test() {
    //given - launch activity
    launchActivity()

    // when - click button 4,5,6
    onView(withId(R.id.btnNum4)).perform(click())
    onView(withId(R.id.btnNum5)).perform(click())
    onView(withId(R.id.btnNum6)).perform(click())


    //then - check input text
    onView(withId(R.id.input)).check(matches(withText("456")))
  }

  @Test
  fun clickButtonNum7890Test() {
    //given - launch activity
    launchActivity()

    // when - click button 7,8,9,0
    onView(withId(R.id.btnNum7)).perform(click())
    onView(withId(R.id.btnNum8)).perform(click())
    onView(withId(R.id.btnNum9)).perform(click())
    onView(withId(R.id.btnNum0)).perform(click())


    //then - check input text
    onView(withId(R.id.input)).check(matches(withText("7890")))
  }

  @Test
  fun addTest() {
    //given - launch activity
    launchActivity()

    // when - click buttons => 1 + 2
    onView(withId(R.id.btnNum1)).perform(click())
    onView(withId(R.id.btnAdd)).perform(click())
    onView(withId(R.id.btnNum2)).perform(click())
    onView(withId(R.id.btnEquals)).perform(click())

    //then - check input text
    onView(withId(R.id.input)).check(matches(withText("3")))
  }

  @Test
  fun subTest() {
    //given - launch activity
    launchActivity()

    // when - click buttons => 10 - 6
    onView(withId(R.id.btnNum1)).perform(click())
    onView(withId(R.id.btnNum0)).perform(click())
    onView(withId(R.id.btnSub)).perform(click())
    onView(withId(R.id.btnNum6)).perform(click())
    onView(withId(R.id.btnEquals)).perform(click())

    //then - check input text
    onView(withId(R.id.input)).check(matches(withText("4")))
  }

  @Test
  fun mulTest() {
    //given - launch activity
    launchActivity()

    // when - click buttons => 22 * 3
    onView(withId(R.id.btnNum2)).perform(click())
    onView(withId(R.id.btnNum2)).perform(click())
    onView(withId(R.id.btnMul)).perform(click())
    onView(withId(R.id.btnNum3)).perform(click())
    onView(withId(R.id.btnEquals)).perform(click())

    //then - check input text
    onView(withId(R.id.input)).check(matches(withText("66")))
  }

  @Test
  fun divTest() {
    //given - launch activity
    launchActivity()

    // when - click buttons => 25 / 5
    onView(withId(R.id.btnNum2)).perform(click())
    onView(withId(R.id.btnNum5)).perform(click())
    onView(withId(R.id.btnDiv)).perform(click())
    onView(withId(R.id.btnNum5)).perform(click())
    onView(withId(R.id.btnEquals)).perform(click())

    //then - check input text
    onView(withId(R.id.input)).check(matches(withText("5")))
  }

  @Test
  fun showErrorToastTest() {
    //given - launch activity
    var activity: Activity? = null
    launchActivity().onActivity {
      activity = it
    }

    // when - not complete expression
    onView(withId(R.id.btnNum1)).perform(click())
    onView(withId(R.id.btnAdd)).perform(click())
    onView(withId(R.id.btnEquals)).perform(click())

    //then - check error toast
    onView(withText(R.string.toast_expression_error))
      .inRoot(RootMatchers.withDecorView(CoreMatchers.not(CoreMatchers.`is`(activity?.window?.decorView))))
      .check(matches(ViewMatchers.isDisplayed()))
  }

  private fun launchActivity(): ActivityScenario<MainActivity> {
    return launch(MainActivity::class.java)
  }
}