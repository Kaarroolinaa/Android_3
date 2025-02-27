package com.example.android_3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)

        val textViewResult: TextView = view.findViewById(R.id.textViewResult)
        val buttonCancel: Button = view.findViewById(R.id.buttonCancel)

        val selectedBook = arguments?.getString(ARG_BOOK)
        val selectedYear = arguments?.getString(ARG_YEAR)

        textViewResult.text = "Ви обрали: $selectedBook ($selectedYear)"

        buttonCancel.setOnClickListener {
            (activity as MainActivity).showInputFragment()
        }

        return view
    }

    companion object {
        private const val ARG_BOOK = "book"
        private const val ARG_YEAR = "year"

        fun newInstance(book: String, year: String): ResultFragment {
            val fragment = ResultFragment()
            val args = Bundle()
            args.putString(ARG_BOOK, book)
            args.putString(ARG_YEAR, year)
            fragment.arguments = args
            return fragment
        }
    }
}