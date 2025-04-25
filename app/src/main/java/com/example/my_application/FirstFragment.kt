package com.example.my_application

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.my_application.HistoricoHelper.PREF_NAME
import com.example.my_application.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonSoma.setOnClickListener {
            val numero1 = binding.textInputLayout1.editText?.text.toString()
            val numero2 = binding.textInputLayout2.editText?.text.toString()

            val resultado = numero1.toDouble() + numero2.toDouble()
            binding.resultadoTextView.text = resultado.toString()

            val operacaoCompleta = "$numero1 + $numero2 = $resultado"
            HistoricoHelper.salvarOperacao(requireContext(), operacaoCompleta)
        }

        binding.buttonSubtracao.setOnClickListener {
            val numero1 = binding.textInputLayout1.editText?.text.toString()
            val numero2 = binding.textInputLayout2.editText?.text.toString()

            val resultado = numero1.toDouble() - numero2.toDouble()
            binding.resultadoTextView.text = resultado.toString()

            val operacaoCompleta = "$numero1 - $numero2 = $resultado"
            HistoricoHelper.salvarOperacao(requireContext(), operacaoCompleta)
        }

        binding.buttonMultiplicacao.setOnClickListener {
            val numero1 = binding.textInputLayout1.editText?.text.toString()
            val numero2 = binding.textInputLayout2.editText?.text.toString()

            val resultado = numero1.toDouble() * numero2.toDouble()
            binding.resultadoTextView.text = resultado.toString()

            val operacaoCompleta = "$numero1 * $numero2 = $resultado"
            HistoricoHelper.salvarOperacao(requireContext(), operacaoCompleta)

        }

        binding.buttonDivisao.setOnClickListener {
            val numero1 = binding.textInputLayout1.editText?.text.toString()
            val numero2 = binding.textInputLayout2.editText?.text.toString()

            val resultado = numero1.toDouble() / numero2.toDouble()
            binding.resultadoTextView.text = resultado.toString()

            val operacaoCompleta = "$numero1 / $numero2 = $resultado"
            HistoricoHelper.salvarOperacao(requireContext(), operacaoCompleta)

        }


        binding.btnHistorico.setOnClickListener {
            val historico = HistoricoHelper.obterHistorico(requireContext())
            binding.txtHistorico.text = historico
        }

    }

}