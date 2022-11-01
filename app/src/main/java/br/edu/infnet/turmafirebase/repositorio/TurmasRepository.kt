package br.edu.infnet.turmafirebase.repositorio

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class TurmasRepository private constructor() {

    companion object {

        private lateinit var auth: FirebaseAuth

        private var INSTANCE: TurmasRepository? = null
        fun initialize() {
            if (INSTANCE == null) {
                INSTANCE = TurmasRepository()

                auth = Firebase.auth

            }
        }

        fun get(): TurmasRepository {
            return INSTANCE
                ?: throw IllegalStateException("TurmaRepository deve ser inicializado.")
        }
    }

    fun signOn(email: String, password: String): Task<AuthResult> {
        return auth.createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    // Sign in success, update UI with the signed-in user's information
//                    Log.d(TAG, "createUserWithEmail:success")
//                    val user = auth.currentUser
//                    updateUI(user)
//                } else {
//                    // If sign in fails, display a message to the user.
//                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
//                    Toast.makeText(baseContext, "Authentication failed.",
//                        Toast.LENGTH_SHORT).show()
//                    updateUI(null)
//                }
//            }
    }

    fun login(email: String, password: String): Task<AuthResult> {
        return auth.signInWithEmailAndPassword(email, password)
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    // Sign in success, update UI with the signed-in user's information
//                    Log.d(TAG, "signInWithEmail:success")
//                    val user = auth.currentUser
//                    updateUI(user)
//                } else {
//                    // If sign in fails, display a message to the user.
//                    Log.w(TAG, "signInWithEmail:failure", task.exception)
//                    Toast.makeText(baseContext, "Authentication failed.",
//                        Toast.LENGTH_SHORT).show()
//                    updateUI(null)
//                }
//            }
    }

    fun logout() {
        auth.signOut()
    }

    private fun getCurrentUser() = auth.currentUser


    fun isLoggedIn() : Boolean {
        if (getCurrentUser() != null){
            return true
        }

        return false
    }

}