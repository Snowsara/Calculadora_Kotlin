package com.example.my_application

import android.content.Context
import android.content.SharedPreferences

object HistoricoHelper {
    const val PREF_NAME = "prefs_calculadora"
    private const val HISTORICO_KEY = "historico"

    private fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun salvarOperacao(context: Context, operacao: String) {
        val prefs = getPrefs(context)
        val novoHistorico = "$operacao\n"
        prefs.edit().clear().apply()
        prefs.edit().putString(HISTORICO_KEY, novoHistorico).apply()
    }

    fun obterHistorico(context: Context): String {
        return getPrefs(context).getString(HISTORICO_KEY, "Sem Historico") ?: ""
    }
}