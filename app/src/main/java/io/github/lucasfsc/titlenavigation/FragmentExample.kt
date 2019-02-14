package io.github.lucasfsc.titlenavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.lucasfsc.titlenavigator.TitleNavBaseFragment
import kotlinx.android.synthetic.main.fragment_example.*

class FragmentExample : TitleNavBaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_example, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            pushFragment(R.id.app_content, FragmentExample.newInstance(), getTitle())
        }

        number.text = (activity!!.supportFragmentManager.backStackEntryCount).toString()

    }

    private fun getTitle(): String {
        return getString(R.string.frag_number, (activity!!.supportFragmentManager.backStackEntryCount + 1))
    }

    companion object {
        fun newInstance(): FragmentExample {
            return FragmentExample()
        }
    }
}