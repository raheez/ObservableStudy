package com.app.observablestudy

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment(R.layout.fragment_first) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("life_cycle_method", "on_attach")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        Log.d("life_cycle_method", "on_create")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("life_cycle_method", "on_create_view")
        return inflater.inflate(R.layout.fragment_first, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("life_cycle_method", "on_activity_created")
    }

    override fun onStart() {
        super.onStart()
        Log.d("life_cycle_method", "on_start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle_method", "on_resume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle_method", "on_stop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("life_cycle_method", "on_destroy_view")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle_method", "on_destroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("life_cycle_method", "on_detach")
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}