package happy.mjstudio.layoutsample.ui

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import happy.mjstudio.layoutsample.R
import happy.mjstudio.layoutsample.adapter.BottomSheetRecyclerViewAdapter
import happy.mjstudio.layoutsample.adapter.NavigationAdapter
import happy.mjstudio.layoutsample.adapter.RecyclerViewTouchListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_sheet.*

class MainActivity : AppCompatActivity() , RecyclerViewTouchListener {

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBottomAppBar()
        initBottomSheet()
        initViews()
    }

    private fun initBottomAppBar() {
        setSupportActionBar(bottomAppBar)
        bottomAppBar.replaceMenu(R.menu.main_menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            android.R.id.home-> {
                val behavior = BottomSheetBehavior.from(bottomSheet)
                behavior.state = BottomSheetBehavior.STATE_EXPANDED
            }

            R.id.menu_info -> {
                AlertDialog.Builder(this)
                    .setTitle("Layout Sample")
                    .setMessage("Orgarnization : Zizunz Android Master\n\nLicense : Free\n\nGithub : https://github.com/zizunz-android-master/Layout")
                    .setIcon(R.drawable.ic_launcher_foreground)
                    .setNegativeButton("Show", object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            Intent(Intent.ACTION_VIEW).apply {
                                data = Uri.parse("https://github.com/zizunz-android-master/Layout")
                                startActivity(this)
                            }
                        }
                    })
                    .setPositiveButton("Ok",object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface?, which: Int) {

                        }
                    })
                    .create()
                    .show()
            }
        }

        return true
    }

    private fun initBottomSheet() {
        bottomSheetRecyclerView.adapter = BottomSheetRecyclerViewAdapter(this)
    }

    override fun onTouchItem(item: Any, position: Int) {
        this.viewPager.setCurrentItem(position,true)
        val behavior = BottomSheetBehavior.from(bottomSheet)
        behavior.state = BottomSheetBehavior.STATE_HIDDEN
    }

    private fun initViews() {
        viewPager.adapter = NavigationAdapter(supportFragmentManager)

    }


}
