package happy.mjstudio.layoutsample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import happy.mjstudio.layoutsample.R
import kotlinx.android.synthetic.main.item_bottomsheet.view.*
import java.lang.ref.WeakReference



class BottomSheetRecyclerViewAdapter(listener : RecyclerViewTouchListener? = null) : RecyclerView.Adapter<BottomSheetRecyclerViewAdapter.BottomSheetHolder>() {

    /**
     * WeakReference 는 약한 참조를 의미한다. MainActivity와 이 객체간에 순환 참조가 발생하지 않게하기 위해 약한 참조를 사용한다.
     */
    val listener : WeakReference<RecyclerViewTouchListener?> = WeakReference(listener)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomSheetHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_bottomsheet,parent,false)
        return BottomSheetHolder(v)
    }

    override fun getItemCount() = NavigationAdapter.NavigationMenu.getAllNavigationMenu().size

    override fun onBindViewHolder(holder: BottomSheetHolder, position: Int) {
        val menu = NavigationAdapter.NavigationMenu.getAllNavigationMenu()[position]
        /**
         * [onBindViewHolder] 에서 뷰에 대한 많은 작업을 해주기 보다는 뷰홀더 클래스에 bind 라는 메서드를 정의해두고 아이템만 전달해주는 편이 좋다.
         */
        holder.bind(menu)
    }

    /**
     * [BottomSheetRecyclerViewAdapter] 에서 사용하는 뷰 홀더 클래스이다. 보통 뷰 홀더 클래스는 inner class 로 정의한다.
     */
    inner class BottomSheetHolder(v : View) : RecyclerView.ViewHolder(v) {

        private val textView : TextView = v.textViewBottomSheet

        init {
            v.setOnClickListener {
                val menu = NavigationAdapter.NavigationMenu.getAllNavigationMenu()[layoutPosition]
                listener.get()?.onTouchItem(menu,layoutPosition)
            }
        }

        fun bind(menu : NavigationAdapter.NavigationMenu) {
            textView.text = menu.name
        }
    }
}