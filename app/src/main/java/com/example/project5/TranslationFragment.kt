package com.example.project5

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import android.widget.EditText
import android.widget.Button


class TranslationFragment : Fragment() {
    val viewModel: TranslationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_translation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val inputText: EditText = view.findViewById(R.id.inputText)
        val translateButton: Button = view.findViewById(R.id.translateButton)

        val mainActivityView = activity?.findViewById<View>(R.id.fragmentContainer)?.rootView
        val sourceLanguageGroup: RadioGroup = mainActivityView?.findViewById(R.id.sourceLanguageGroup)!!
        val targetLanguageGroup: RadioGroup = mainActivityView.findViewById(R.id.targetLanguageGroup)!!
        val translatedText: TextView = mainActivityView.findViewById(R.id.translatedText)

        translateButton.setOnClickListener {
            val sourceLanguage = when (sourceLanguageGroup.checkedRadioButtonId) {
                R.id.englishSource -> "English"
                R.id.spanishSource -> "Spanish"
                R.id.germanSource -> "German"
                else -> ""
            }

            val targetLanguage = when (targetLanguageGroup.checkedRadioButtonId) {
                R.id.englishTarget -> "English"
                R.id.spanishTarget -> "Spanish"
                R.id.germanTarget -> "German"
                else -> ""
            }

            viewModel.sourceLanguage.value = sourceLanguage
            viewModel.targetLanguage.value = targetLanguage
            viewModel.sourceText.value = inputText.text.toString()

            viewModel.translateText()
        }

        viewModel.translatedText.observe(viewLifecycleOwner, Observer { text ->
            translatedText.text = text
        })
    }
}

