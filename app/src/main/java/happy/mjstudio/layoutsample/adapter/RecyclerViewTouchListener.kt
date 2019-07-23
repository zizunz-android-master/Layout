package happy.mjstudio.layoutsample.adapter

import androidx.recyclerview.widget.RecyclerView

/**
 * [RecyclerView]의 아이템을 클릭했을 때 콜백을 전달해 줄 리스너 인터페이스이다.
 */
interface RecyclerViewTouchListener {
    /**
     * 클릭한 아이템에 해당하는 객체와 리사이클러뷰에서 몇번째 아이템인지 전달한다.
     *
     * @param item Item for clicked
     * @param position Index for clicked item in [RecyclerView.Adapter]
     */
    fun onTouchItem(item : Any, position : Int)
}