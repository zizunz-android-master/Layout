package happy.mjstudio.layoutsample.ui

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import happy.mjstudio.layoutsample.R
import kotlinx.android.synthetic.main.fragment_coordinatorlayout.*
import kotlinx.android.synthetic.main.item_coordinator_layout.view.*

class CoordinatorLayoutFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_coordinatorlayout,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initFab()
        initRecyclerView()
    }

    private fun initFab() {
        fab.setOnClickListener {
            Snackbar.make(coordinatorLayout,"Hello",Snackbar.LENGTH_LONG).apply {
                show()
            }
        }
    }
    private fun initRecyclerView(){
        with(recyclerView) {
            adapter = CoordinatorLayoutFragmentAdapter()
            addItemDecoration(CoordinatorLayoutItemDecoration())
        }
    }

    class CoordinatorLayoutFragmentAdapter : RecyclerView.Adapter<CoordinatorLayoutFragmentAdapter.CoordinatorFragmentViewHolder>() {

        private var sampleItems = (1..100).map { it.toString() }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoordinatorFragmentViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return CoordinatorFragmentViewHolder(inflater.inflate(R.layout.item_coordinator_layout,parent,false))
        }

        override fun getItemCount() = sampleItems.size

        override fun onBindViewHolder(holder: CoordinatorFragmentViewHolder, position: Int) {
            holder.bind(sampleItems[position])
        }

        inner class CoordinatorFragmentViewHolder(private val v : View) : RecyclerView.ViewHolder(v) {
            fun bind(item : String) {
                v.textView.text = item
            }
        }
    }

    class CoordinatorLayoutItemDecoration : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            val pos = parent.getChildLayoutPosition(view)
            outRect.bottom = 3
        }

        override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
            super.onDraw(c, parent, state)

            c.drawColor(Color.LTGRAY)
        }
    }
}