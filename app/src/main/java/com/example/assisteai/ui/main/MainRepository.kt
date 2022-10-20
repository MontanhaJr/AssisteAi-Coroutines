package com.example.assisteai.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.security.auth.callback.Callback

class MainRepository {
    fun getFilmes(callback: (filmes: List<Filme>) -> Unit)  {
        Thread {
            callback.invoke(
                listOf(
                    Filme(1, "Título"),
                    Filme(2, "Título2")
                )
            )
        }.start()
    }

    suspend fun getFilmesCoroutines(): List<Filme> {
        return withContext(Dispatchers.Default) {
            listOf(
                Filme(1, "Título"),
                Filme(2, "Título2")
            )
        }
    }
}