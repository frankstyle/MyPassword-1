package org.tianjyan.pwd.application

import android.app.Fragment

open class BaseFragment : Fragment() {

    protected val baseActivity: BaseActivity
        get() = activity as BaseActivity

    protected fun showToast(resId: Int) {
        baseActivity.showToast(resId)
    }

    protected fun showToast(resId: Int, duration: Int) {
        baseActivity.showToast(resId, duration)
    }
}