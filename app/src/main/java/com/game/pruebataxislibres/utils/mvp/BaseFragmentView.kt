package com.game.pruebataxislibres.utils.mvp

import android.os.Looper
import android.view.View
import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.game.pruebataxislibres.R
import com.game.pruebataxislibres.utils.core.CoreView
import com.game.pruebataxislibres.utils.snack
import com.game.pruebataxislibres.utils.ui.LoadingAnimation
import java.util.logging.Handler

open class BaseFragmentView<T : ViewBinding>(@LayoutRes contentLayoutId: Int) :
    Fragment(contentLayoutId), CoreView {
    private var loadingAnimation: LoadingAnimation? = null
    var bindingInit: T? = null;
    val binding get() = bindingInit!!
    private var raw: Int = R.raw.map_point

    override fun onDestroyView() {
        super.onDestroyView()
        bindingInit = null;
    }

    override fun showSuccess() {

    }


    override fun showError(msg: String) {
        var cl: View? = this.activity?.findViewById(R.id.parent)
        cl?.snack(msg);
    }

    override fun showProgress(raw: Int) {
        loadingAnimation = LoadingAnimation(this.requireActivity(), raw);
        loadingAnimation?.playAnimation(true)
    }

    override fun hideProgress() {
        loadingAnimation?.stopAnimation()
    }
}