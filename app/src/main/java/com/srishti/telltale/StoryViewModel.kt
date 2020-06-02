package com.srishti.telltale

import android.app.Application
import android.widget.TextView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

/**
 * @author Srishti
 * @version 1.0
 * @since 29/05/20
 */
class StoryViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var _finalStory: String
    val finalStory: String
        get() = _finalStory
    private var firstOption = MutableLiveData<String>()
    private var secondOption = MutableLiveData<String>()
    private var thirdOption = MutableLiveData<String>()

    fun formCompleteStory() {
        _finalStory = getApplication<Application>().applicationContext.getString(
            R.string.full_story,
            firstOption.value,
            secondOption.value,
            thirdOption.value
        )
    }

    fun optionOneSelected(view: TextView) {
        firstOption.value = view.text.toString()
    }

    fun optionTwoSelected(view: TextView) {
        secondOption.value = view.text.toString()
    }

    fun optionThreeSelected(view: TextView) {
        thirdOption.value = view.text.toString()
    }


}