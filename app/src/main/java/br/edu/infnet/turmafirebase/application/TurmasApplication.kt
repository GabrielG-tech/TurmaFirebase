package br.edu.infnet.turmafirebase.application

import android.app.Application
import br.edu.infnet.turmafirebase.repositorio.TurmasRepository

class TurmasApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        TurmasRepository.initialize()

    }

}