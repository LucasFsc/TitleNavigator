package io.github.lucasfsc.titlenavigator

import androidx.annotation.IdRes
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class TitleNavBaseController private constructor(
    private val fragmentManager: FragmentManager,
    private val defaultTitle: String?,
    private val toolbar: ActionBar
) {

    init {
        fragmentManager.apply {
            addOnBackStackChangedListener {
                if (this.backStackEntryCount > 0) setTitle(this.getBackStackEntryAt(this.fragments.lastIndex -1).name!!)
                else setTitle(defaultTitle)
            }
        }
    }

    fun setInitialFragment(@IdRes containerId: Int, fragment: Fragment, title: String?) {
        if (title != null) toolbar.title = title
        fragmentManager.beginTransaction().replace(containerId, fragment).commit()
    }

    private fun setTitle(title: String?){
        toolbar.title = title
    }

    class Builder {

        private lateinit var fragmentManager: FragmentManager
        private var defaultTitle: String? = null
        private var toolbar: ActionBar? = null

        fun defaultTitle(title: String?) : Builder {
            this.defaultTitle = title
            return this
        }

        fun fragmentManager(fragmentManager: FragmentManager) : Builder {
            this.fragmentManager = fragmentManager
            return this
        }

        fun actionBar(actionBar: ActionBar): Builder {
            this.toolbar = actionBar
            if (toolbar == null){
                throw IllegalAccessException("ActionBar required")
            }
            return this
        }

        fun build() : TitleNavBaseController {
            if (toolbar != null){
                return TitleNavBaseController(fragmentManager, defaultTitle, toolbar!!)
            }else {
                throw IllegalAccessException("Arguments required")
            }
        }
    }

}