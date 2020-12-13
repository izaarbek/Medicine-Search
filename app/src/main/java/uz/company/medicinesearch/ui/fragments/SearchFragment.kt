package uz.company.medicinesearch.ui.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_search.*
import uz.company.medicinesearch.R
import uz.company.medicinesearch.adapter.MedicineAdapter
import uz.company.medicinesearch.models.Medicine

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment(R.layout.fragment_search) {





private lateinit var medicineAdapter:MedicineAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchEdit.requestFocus()
        showKeyboard(requireActivity())
        setUpRv()
        setupData()


        searchEdit.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                p0?.let {
                    medicineAdapter.filter.filter(it.toString())
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

        })
    }








   private fun hideKeyboard(activity: Activity) {
        val view = activity.currentFocus
        val methodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        assert(view != null)
        methodManager.hideSoftInputFromWindow(requireView().windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    private fun showKeyboard(activity: Activity) {
        val view = activity.currentFocus
        val methodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        assert(view != null)
        methodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }

    override fun onPause() {
        super.onPause()
        hideKeyboard(requireActivity())
    }

    private fun setUpRv(){
        rvSearchLayout.layoutManager=LinearLayoutManager(requireContext())

        rvSearchLayout.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }

    private fun setupData(){
        val medicineList= arrayListOf(
                Medicine(1,"test1","description 1",false,100),
                Medicine(2,"test2","description 2",false,100),
                Medicine(3,"test3","description 3",false,100),
                Medicine(4,"test4","description 4",false,100),
                Medicine(5,"test5","description 5",false,100),
                Medicine(6,"test6","description 6",false,100),
                Medicine(7,"test7","description 7",false,100),
                Medicine(8,"test8","description 8",false,100),
                Medicine(9,"test9","description 9",false,100),
                Medicine(10,"test10","description 10",false,100)
        )
        medicineAdapter= MedicineAdapter(medicineList)
        rvSearchLayout.adapter=medicineAdapter

        medicineAdapter.onItemClick={id,name->
           findNavController().navigate(R.id.medicineFragment, bundleOf("id" to id,"name" to name))
        }
    }


}