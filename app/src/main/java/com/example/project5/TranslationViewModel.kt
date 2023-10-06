package com.example.project5

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log

class TranslationViewModel : ViewModel() {

    val sourceText = MutableLiveData<String>()
    val translatedText = MutableLiveData<String>()
    val sourceLanguage = MutableLiveData<String>()
    val targetLanguage = MutableLiveData<String>()

    fun translateText() {
        if (sourceLanguage.value == null || targetLanguage.value == null) {
            translatedText.value = "Please select both source and target languages."
            return
        }

        Log.d("TranslationVM", "Translating from ${sourceLanguage.value} to ${targetLanguage.value}")

        // Mock translation logic
        when (sourceLanguage.value) {
            "English" -> {
                when (targetLanguage.value) {
                    "Spanish" -> translatedText.value = "${sourceText.value} in Spanish"
                    "German" -> translatedText.value = "${sourceText.value} in German"
                }
            }
            "Spanish" -> {
                when (targetLanguage.value) {
                    "English" -> translatedText.value = "${sourceText.value} in English"
                    "German" -> translatedText.value = "${sourceText.value} in German"
                }
            }
            "German" -> {
                when (targetLanguage.value) {
                    "English" -> translatedText.value = "${sourceText.value} in English"
                    "Spanish" -> translatedText.value = "${sourceText.value} in Spanish"
                }
            }
        }
    }
}
