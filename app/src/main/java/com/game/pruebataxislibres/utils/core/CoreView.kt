package com.game.pruebataxislibres.utils.core

interface CoreView {
    fun showSuccess()
    fun showError(msg: String)
    fun showProgress(raw: Int)
    fun hideProgress()
}