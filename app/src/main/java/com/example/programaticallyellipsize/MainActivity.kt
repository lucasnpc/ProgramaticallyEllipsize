package com.example.programaticallyellipsize

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.programaticallyellipsize.databinding.ActivityTextBinding


class MainActivity : AppCompatActivity() {

    private val binding: ActivityTextBinding by lazy { ActivityTextBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyCustomView(this))
//        setContentView(binding.root)
        val displayMetrics = resources.displayMetrics
        val dpWidth = displayMetrics.widthPixels / displayMetrics.density
        val string = getString(R.string.lorem_ipsum).substring(
            0,
            (dpWidth / 7.25).toInt()
        ) + "..."
        binding.textviewFirst.apply {
            text = string
            setOnClickListener {
                val dialog = AlertDialog.Builder(this@MainActivity).apply {
                    setTitle("Teste")
                    setMessage(getString(R.string.lorem_ipsum))
                    setPositiveButton(
                        "OK"
                    ) { dialog, which -> dialog.dismiss() }
                }
                dialog.show()
            }
        }
    }
}