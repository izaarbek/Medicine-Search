package uz.company.medicinesearch

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import uz.company.medicinesearch.models.Stat
import kotlinx.android.synthetic.main.activity_home.*

class Home : Fragment(R.layout.activity_home) {

    private val statAdapter = StatAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRv()
        setUpStats()
    }

    private fun setUpStats() {
        val statItems = listOf(Stat(R.drawable.allergia, "Аллергия")
                , Stat(R.drawable.antibio, "Все ли вы знаете об Антибиотиках?")
                , Stat(R.drawable.antibiotics, "Антибиотики нового поколения: за и против")
                , Stat(R.drawable.fitness, "Платим за тренировки! FITNESS!")
                , Stat(R.drawable.sabzavotlar, "5 способов укрепить сосуды!")
        )

        statAdapter.setItems(statItems)
    }


    private fun setUpRv() {
        rvStats.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvStats.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.HORIZONTAL).apply {
            setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.rv_divider)!!)
        })
        rvStats.adapter = statAdapter
    }
}