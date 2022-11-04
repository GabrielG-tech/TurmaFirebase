package br.edu.infnet.turmafirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.edu.infnet.turmafirebase.databinding.ActivityLoginBinding
import br.edu.infnet.turmafirebase.repositorio.TurmasRepository

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val repositorio = TurmasRepository.get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setup()
    }

    override fun onStart() {
        super.onStart()
        if (repositorio.isLoggedIn()) {
            startMainActivity()
        }
    }

    private fun setup() {
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.apply {
            btnSignOn.setOnClickListener {
                onSignOnClick()
            }
            btnLogin.setOnClickListener {
                onLoginClick()
            }
        }
    }

    private fun onLoginClick() {
        repositorio.login(
            binding.inputEmail.text.toString(),
            binding.inputPassword.text.toString()
        )
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(
                        this,
                        "Logado com Sucesso",
                        Toast.LENGTH_SHORT
                    ).show()
                    startMainActivity()
                } else {
                    Toast.makeText(
                        this,
                        "Falha da Autenticação",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }


    private fun onSignOnClick() {
        repositorio.signOn(
            binding.inputEmail.text.toString(),
            binding.inputPassword.text.toString()
        )
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(
                        this,
                        "Cadastrado com Sucesso",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this,
                        "Falha da Autenticação",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

    }

    fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }


}