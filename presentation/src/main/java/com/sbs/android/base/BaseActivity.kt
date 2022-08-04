package com.sbs.android.base

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.sbs.android.R
import com.sbs.android.exception.ErrorMessageFactory

abstract class BaseActivity : AppCompatActivity() {

    private var dialog: AlertDialog? = null

    protected fun renderError(throwable: Throwable) {
        val message = ErrorMessageFactory.create(throwable)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    /*protected fun showLoadingDialog(@StringRes message: Int) {
        dialog = AlertDialog.Builder(this).create()
        val view = layoutInflater.inflate(R.layout.dialog_loading, null)
        dialog?.setView(view)
        dialog?.setCanceledOnTouchOutside(false)
        view.findViewById<TextView>(R.id.tv_loading_title).text = getString(message)
        dialog?.show()
    }

    protected fun showLoadingDialog(message: String) {
        dialog = AlertDialog.Builder(this).create()
        val view = layoutInflater.inflate(R.layout.dialog_loading, null)
        dialog?.setView(view)
        dialog?.setCanceledOnTouchOutside(false)
        view.findViewById<TextView>(R.id.tv_loading_title).text = message
        dialog?.show()
    }*/

    protected fun hideLoadingDialog() {
        dialog?.cancel()
    }

    protected fun showToast(@StringRes message: Int) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    protected fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    protected fun hideKeyboard() {
        val view: View? = currentFocus
        if (view != null) {
            val imm: InputMethodManager? = getSystemService(
                Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}