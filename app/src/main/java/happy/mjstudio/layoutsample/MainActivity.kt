package happy.mjstudio.layoutsample

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import happy.mjstudio.layoutsample.adapter.NavigationAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_sheet.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBottomAppBar()
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
                Log.e("TAG","home")
                val behavior = BottomSheetBehavior.from(bottomSheet)
                behavior.state = BottomSheetBehavior.STATE_EXPANDED
            }

            R.id.menu_info-> {
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

    private fun initViews() {
        viewPager.adapter = NavigationAdapter(supportFragmentManager)

    }


}
