package br.edu.infnet.turmafirebase.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.edu.infnet.turmafirebase.models.Turma
import br.edu.infnet.turmafirebase.repositorio.TurmasRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.ktx.toObject

class MainViewModel: ViewModel() {

    val TAG = "ViewModel"

    fun cadastrarTurma(turma: Turma): Task<DocumentReference> {
        return repository.cadastrarTurma(turma)
    }

    val repository = TurmasRepository.get()

    // Para por no Recycle View
    val _listaTurmas = MutableLiveData<List<Turma>>(listOf<Turma>())
    val listaTurmas : LiveData<List<Turma>> = _listaTurmas
    fun setListaTurmas(value: List<Turma>){
        _listaTurmas.postValue(value)
    }

    fun getTurmas(){
        repository.getTurmas().addOnSuccessListener { documentos ->

            val listaTurmas = mutableListOf<Turma>()

            for (doc in documentos) {
                listaTurmas.add(doc.toObject())
            }
            setListaTurmas(listaTurmas)

            Log.i(TAG, "lista Documentos: ${documentos}")
            Log.i(TAG, "lista Turmas: ${listaTurmas}")

        }
    }

}