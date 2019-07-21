package happy.mjstudio.layoutsample.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import happy.mjstudio.layoutsample.LinearLayoutFragment

class NavigationAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm,FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int) = NavigationMenu.getFragmentWithIndex(position)

    override fun getCount() = NavigationMenu.getAllNavigationMenu().size

    enum class NavigationMenu {
        LINEARLAYOUT

        ;

        companion object {
            fun getAllNavigationMenu() : List<NavigationMenu> = listOf(LINEARLAYOUT)

            fun getFragmentWithIndex(index : Int) : Fragment {
                return when(index) {
                    0 -> LinearLayoutFragment()

                    else -> throw IllegalArgumentException("Not found Fragment class for given index")
                }
            }
        }
    }
}

