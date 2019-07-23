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

    /**
     * 이와 같이 한 Class에 대한 TAG 를 지정할 수 있다.
     *
     * 클래스이름::class 는 코틀린에서 KClass<T> 객체를, 클래스이름::class.java 는 Class<T> 객체를 반환한다.
     *
     * 이는 각각 코틀린 클래스와 자바 클래스를 의미하는데, 자바 클래스 객체에서 simpleName 을 가져오면 클래스의 이름이 나온다.
     *
     * 그냥 private val TAG = "MainActivity" 같이 사용하는 것과 차이 없지만, 클래스의 이름이 변경될 때 문자열을 변경하지 않아도 자동으로 태그가 변경되어 편하다.
     *
     * 코드에서 String 을 큰 따옴표를 이용한 상수 그대로 사용하는 것은 위험한 코딩이다.
     */
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBottomAppBar()
        initBottomSheet()
        initViews()
    }

    /**
     * [BottomAppBar] 를 초기화한다. 기존에는 [setSupportActionBar] 메서드를 이용해서 커스텀 툴바를 앱바로 지정했지만 [BottomAppBar] 를 지정한다.
     *
     * 또한, [replaceMenu] 메서드를 이용해서 메뉴를 변경한다. 이는 [onCreateOptionMenu] 콜백 메서드를 호출한다.
     */
    private fun initBottomAppBar() {
        setSupportActionBar(bottomAppBar)
        bottomAppBar.replaceMenu(R.menu.main_menu)
    }

    /**
     * [MenuInflater] 객체를 이용해서 메뉴를 Inflate 하고 참을 반환한다.
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    /**
     * res/menu 에 정의 해둔 메뉴 파일의 아이템들이 각각 갖고있는 id 를 이용해서 어떤 메뉴가 클릭되었는지 분기한다.
     */
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

    /**
     * BottomSheet 에서 RecylerView의 어댑터를 초기화한다.
     *
     * LayoutManager는 xml 파일에서 지정한다.
     *
     * bottom_sheet.xml 레이아웃 파일을 참고한다.
     */
    private fun initBottomSheet() {
        bottomSheetRecyclerView.adapter = BottomSheetRecyclerViewAdapter(this)
    }

    /**
     * [RecyclerViewTouchListener] 인터페이스를 구현한 메서드이다. 리사이클러 뷰에서 아이템을 클릭했을 때 이 메서드가 호출된다.
     */
    override fun onTouchItem(item: Any, position: Int) {
        this.viewPager.setCurrentItem(position,true)
        val behavior = BottomSheetBehavior.from(bottomSheet)
        behavior.state = BottomSheetBehavior.STATE_HIDDEN
    }

    /**
     * 기타 다른 뷰들을 초기화하는 메서드이다. 뷰 페이저를 초기화했다.
     */
    private fun initViews() {
        viewPager.adapter = NavigationAdapter(supportFragmentManager)
    }
}
