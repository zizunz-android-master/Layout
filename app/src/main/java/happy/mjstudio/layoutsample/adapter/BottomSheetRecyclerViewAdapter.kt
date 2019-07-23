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

    val listener : WeakReference<RecyclerViewTouchListener?> = WeakReference(listener)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomSheetHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_bottomsheet,parent,false)
        return BottomSheetHolder(v)
    }

    override fun getItemCount() = NavigationAdapter.NavigationMenu.getAllNavigationMenu().size

    override fun onBindViewHolder(holder: BottomSheetHolder, position: Int) {
        val menu = NavigationAdapter.NavigationMenu.getAllNavigationMenu()[position]
        holder.bind(menu)
    }

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