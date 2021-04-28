package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.junit.Test
import org.junit.Assert.*

/**READABLE TESTS
 * give you test good name
 * stucture your test using  GIVEN,WHEN,THEN
 * using Assertion framework */


/**NAMING RULE
 * SubjectUnderTest_actionOrInput_resultState
 * example: getActiveCompletedStats_NoCompleted_returnsZeroHundred */


/**GIVEN,WHEN,THEN
 * comment me use kr k test ki readability ko bdha skte hai   */

/** Assertion frame work enko dependency me add krna prta hai
 * jis se assertion sentence  more human readable lgt hai  */

class StatisticsUtilTest {

    //if there is no completed task and 1 active task
    //then  there is 100% active  and 0% completed tasks.

    @Test
    fun  getActiveCompletedStats_NoCompleted_returnsZeroHundred(){
      //GIVEN a list of task with single active task
        val task = listOf<Task>( Task("title","description",isCompleted = false)
        )

       // WHEN you call getActiveAndCompletedStats
        val result = getActiveAndCompletedStats(task)

        //THEN there are 0% completed tasks and 100% active tasks
        assertThat(result.completedTasksPercent,`is`(0f))
        assertThat(result.activeTasksPercent,`is`(100f))
    }


    //if there is 2 completed task and 3 active task
    //then  there is 40% active  and 60% completed tasks.

    @Test
    fun  getActiveCompletedStats_both_returnsFortySixty(){
        val task = listOf<Task>(
                Task("title","description",isCompleted = true),
                Task("title","description",isCompleted = true),
                Task("title","description",isCompleted = false),
                Task("title","description",isCompleted = false),
                Task("title","description",isCompleted = false))

        val result = getActiveAndCompletedStats(task)
        assertThat(result.completedTasksPercent,`is`(40f))
        assertThat(result.activeTasksPercent,`is`(60f))

    }



    @Test
    fun  getActiveCompletedStats_empty_returnsZero(){
        val task = emptyList<Task>()

        val result = getActiveAndCompletedStats(task)
        assertThat(result.completedTasksPercent,`is`(0f))
        assertThat(result.activeTasksPercent,`is`(0f))
    }



    @Test
    fun  getActiveCompletedStats_error_returnsZero(){
        val task = emptyList<Task>()

        val result = getActiveAndCompletedStats(task)
        assertThat(result.completedTasksPercent,`is`(0f))
        assertThat(result.activeTasksPercent,`is`(0f))
    }

}