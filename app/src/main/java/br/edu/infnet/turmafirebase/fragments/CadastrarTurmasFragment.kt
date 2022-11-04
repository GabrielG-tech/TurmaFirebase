package br.edu.infnet.turmafirebase.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import br.edu.infnet.turmafirebase.databinding.FragmentCadastrarTurmasBinding
import br.edu.infnet.turmafirebase.models.Turma
import br.edu.infnet.turmafirebase.viewmodel.MainViewModel


class CadastrarTurmasFragment : Fragment() {

    val viewModel by activityViewModels<MainViewModel>()

    private var _binding: FragmentCadastrarTurmasBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCadastrarTurmasBinding.inflate(inflater, container, false)
        val view = binding.root
        setup()


        return view
    }

    private fun setup() {
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnCadastrar.setOnClickListener {
            onCadastrarClick()
        }
    }

    private fun onCadastrarClick() {
        val turma = getTurmaFromInputs()
        viewModel.cadastrarTurma(turma)
            .addOnSuccessListener { doc ->
                toast("Cadastrado com sucesso com id: ${doc.id}")
            }
            .addOnFailureListener {
                toast("Falha ao cadastrar")
            }
    }


    private fun getTurmaFromInputs(): Turma {
        return Turma(
            nomeTurma = binding.inputNomeTurma.text.toString(),
            nomeProfessor = binding.inputNomeProfessor.text.toString(),
            horario = binding.inputHorario.text.toString()
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}