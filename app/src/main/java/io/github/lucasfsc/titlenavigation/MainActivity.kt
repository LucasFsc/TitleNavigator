package io.github.lucasfsc.titlenavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.lucasfsc.titlenavigator.TitleNavBaseController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val controller = TitleNavBaseController.Builder()
            .actionBar(supportActionBar!!)
            .defaultTitle(getString(R.string.default_title))
            .fragmentManager(supportFragmentManager).build()

        controller.setInitialFragment(
            R.id.app_content,
            FragmentExample.newInstance(),
            getString(R.string.app_name)
        )

    }

    override fun onBackPressed() {

        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }

    }
}
