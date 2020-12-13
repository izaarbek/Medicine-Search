package uz.company.medicinesearch.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_medicine.*
import uz.company.medicinesearch.R
import uz.company.medicinesearch.models.Medicine



/**
 * A simple [Fragment] subclass.
 * Use the [MedicineFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MedicineFragment : Fragment(R.layout.fragment_medicine) {


    val medicineList= listOf(
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val id=requireArguments().getInt("id")

        val currentMedicine=medicineList.find { it.id==id }

        currentMedicine?.let {
            descriptionTxt.text=it.description
            priceTxt.text=it.price.toString()+" sum"

        }






    }




}