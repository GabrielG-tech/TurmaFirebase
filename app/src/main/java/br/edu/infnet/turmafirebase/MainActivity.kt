package br.edu.infnet.turmafirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.infnet.turmafirebase.databinding.ActivityLoginBinding
import br.edu.infnet.turmafirebase.databinding.ActivityMainBinding
import br.edu.infnet.turmafirebase.repositorio.TurmasRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val repositorio = TurmasRepository.get()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setup()
    }

    private fun setup() {
        setupView()
        setupClickListeners()
    }

    private fun setupView() {
        binding.tvEmail.text = repositorio
            .getCurrentUser()?.email ?: "Email não identificado"
    }

    private fun setupClickListeners() {
        binding.btnExit.setOnClickListener {
            onExitClick()
        }
    }

    private fun onExitClick() {
        repositorio.logout()
        startLoginActivity()
    }

    private fun startLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}

