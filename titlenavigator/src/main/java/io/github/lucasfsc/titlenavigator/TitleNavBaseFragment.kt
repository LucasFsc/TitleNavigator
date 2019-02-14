package io.github.lucasfsc.titlenavigator

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

abstract class TitleNavBaseFragment : Fragment() {

    open fun pushFragment(@IdRes containerId: Int, fragment: Fragment, title: String) {
        activity!!.supportFragmentManager.beginTransaction().add(containerId, fragment).addToBackStack(title).commit()
    }

    open fun replaceFragment(@IdRes containerId: Int, fragment: Fragment, title: String) {
        activity!!.supportFragmentManager.beginTransaction().replace(containerId, fragment).addToBackStack(title).commit()
    }

    open fun popTopFragment() {
        activity!!.supportFragmentManager.popBackStack()
    }
}