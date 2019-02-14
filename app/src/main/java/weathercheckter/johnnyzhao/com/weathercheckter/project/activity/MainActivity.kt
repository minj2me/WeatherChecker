package weathercheckter.johnnyzhao.com.weathercheckter.project.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import weathercheckter.johnnyzhao.com.weathercheckter.R
import weathercheckter.johnnyzhao.com.weathercheckter.project.fragment.currentcity.CurrentCityFragment

class MainActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        fun buildLaunchIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }

        const val FRAGMENT_HOME = "FRAGMENT_HOME"
        const val FRAGMENT_OTHER = "FRAGMENT_OTHER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE)

        setContentView(R.layout.activity_main)

        swithToMain(savedInstanceState)

        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.actionCurrent -> {
                    swithToMain(savedInstanceState)
                }
                R.id.actionSearch -> {
                    //todo
                }
            }
            return@setOnNavigationItemSelectedListener true
        }

        supportFragmentManager.addOnBackStackChangedListener{
            if (supportFragmentManager.backStackEntryCount == 0) {
                finish()
            } else if (!supportFragmentManager.fragments.isNullOrEmpty()) {
                when (supportFragmentManager.fragments[0]) {
                    is CurrentCityFragment -> bottomNavigation.menu.getItem(0).isChecked = true
                }
            }
        }
    }

    private fun swithToMain(savedInstanceState: Bundle?) {

        val currentCityFragment = supportFragmentManager.findFragmentByTag(CurrentCityFragment.TAG)
            ?: CurrentCityFragment()

        // if we switch to home clear everything
        supportFragmentManager.popBackStack(FRAGMENT_OTHER, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        supportFragmentManager.beginTransaction()
            .replace(R.id.containerLayout, currentCityFragment, CurrentCityFragment.TAG)
            .addToBackStack(FRAGMENT_HOME)
            .commit()
    }

}
