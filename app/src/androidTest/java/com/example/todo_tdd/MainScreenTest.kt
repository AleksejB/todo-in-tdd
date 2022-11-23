package com.example.todo_tdd

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.data_core.model.NoteDataModel
import com.example.domain_core.model.NoteType
import com.example.todo_tdd.ui.theme.Todo_tddTheme
import com.example.ui_main_screen.MainScreenContent
import com.example.ui_main_screen.MainScreenState
import com.example.ui_main_screen.util.MainScreenTestingConstants.ADD_NOTE_FAB_TAG
import com.example.ui_main_screen.util.MainScreenTestingConstants.NOTES_TITLE_TAG
import com.example.ui_main_screen.util.MainScreenTestingConstants.NOTE_ITEM_TAG
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            Todo_tddTheme {
                MainScreenContent(
                    state = MainScreenState(
                        notes = listOf(
                            NoteDataModel(
                                id = 0,
                                noteTitle = "TestTitle",
                                text = "TestText",
                                type = NoteType.NOTE
                            )
                        )
                    ),
                    eventHandler = {}
                )
            }
        }
    }

    @Test
    fun verifyAllItemsExist() {
        with(composeTestRule) {
            onNodeWithTag(NOTES_TITLE_TAG).assertExists()
            onNodeWithTag(NOTE_ITEM_TAG).assertExists()
            onNodeWithText("TestTitle").assertExists()
            onNodeWithTag(ADD_NOTE_FAB_TAG).assertExists()
        }
    }
}