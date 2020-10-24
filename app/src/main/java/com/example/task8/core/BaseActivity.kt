package com.example.task8.core

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

abstract class BaseActivity: AppCompatActivity() {

    abstract fun setLayoutId(): Int
    abstract fun setTooldBar(): Toolbar
    abstract val isHomeUpButtonEnable: Boolean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        setActionBar(setTooldBar(), isHomeUpButtonEnable)

    }

    private fun setActionBar(toolbar: Toolbar, isHomeUpButtonEnable: Boolean) {
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(isHomeUpButtonEnable)
        supportActionBar?.setDisplayHomeAsUpEnabled(isHomeUpButtonEnable)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun showToast(message: String)
    {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}