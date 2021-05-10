package com.game.pruebataxislibres.ui.fragment.map

import android.content.Context
import com.game.pruebataxislibres.data.model.Movie

class MapPresenter : MapCore.Presenter {

    private lateinit var view: MapCore.View
    private lateinit var context: Context;
    private lateinit var model: MapCore.Model;

    constructor(view: MapCore.View, context: Context) {
        this.view = view
        this.context = context
        this.model = MapModel(this, context)
    }

    override fun showError(msg: String) {

    }
}