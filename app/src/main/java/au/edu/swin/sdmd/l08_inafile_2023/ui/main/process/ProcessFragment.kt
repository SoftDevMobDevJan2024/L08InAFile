package au.edu.swin.sdmd.l08_inafile_2023.ui.main.process

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import au.edu.swin.sdmd.l08_inafile_2023.R
import au.edu.swin.sdmd.l08_inafile_2023.data.RawResourceFile

class ProcessFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_process, container, false)

        val text = root.findViewById<TextView>(R.id.text_process)
//        val process = resources.openRawResource(R.raw.binary_process)
//            .bufferedReader().readText()
        val process = RawResourceFile.readContent(resources, R.raw.binary_process)

        text.text = Html.fromHtml(process, Html.FROM_HTML_MODE_COMPACT)
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
        fun newInstance(sectionNumber: Int): ProcessFragment {
            return ProcessFragment()
        }
    }
}