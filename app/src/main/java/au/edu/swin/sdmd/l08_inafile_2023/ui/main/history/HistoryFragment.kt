package au.edu.swin.sdmd.l08_inafile_2023.ui.main.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import au.edu.swin.sdmd.l08_inafile_2023.R
import au.edu.swin.sdmd.l08_inafile_2023.data.HistoryFile
import au.edu.swin.sdmd.l08_inafile_2023.data.SharedPrefFile

class HistoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_history, container, false)

        /**
         * check if something is stored in the shared preferences file to show,
         * and update the TextView on screen.
         */
        val sHistory: String? = SharedPrefFile.checkSharedPrefs(requireContext(),
            getString(R.string.preference_file_key),
            getString(R.string.last_input),
            getString(R.string.last_input_defval)
        )
        sHistory?.let {
            val tvHistory: TextView = root.findViewById(R.id.history)
            tvHistory.text = String.format("Last value converted was %s", it)
        }

        /**
         * The detailed retrieval of data from the file has moved to another
         * class; this gets a list of the strings in the file and provides them
         * to the list adapter. This is just using the old style list widget for
         * simplicity.
         */
        context?.let { context ->
            val numbers = HistoryFile.getFileContents(context)
            val lvNumbers: ListView = root.findViewById(R.id.history_list)
            lvNumbers.adapter = ArrayAdapter<Any?>(
                context,
                android.R.layout.simple_list_item_1, numbers
            )
        }
        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): HistoryFragment {
            return HistoryFragment()
        }
    }
}