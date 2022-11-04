package br.edu.infnet.turmafirebase.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.infnet.turmafirebase.R
import br.edu.infnet.turmafirebase.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root

        setup()


        return view
    }

    private fun setup() {
        setupClickListeners()
    }

    private fun setupClickListeners() {
        nav(R.id.action_mainFragment_to_turmasFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}