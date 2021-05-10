package com.game.pruebataxislibres.ui.fragment.map

import android.content.Context

class MapModel : MapCore.Model {
    private lateinit var presenter: MapCore.Presenter
    private lateinit var context: Context;

    constructor(presenter: MapCore.Presenter, context: Context) {
        this.presenter = presenter;
        this.context = context;
    }

}
