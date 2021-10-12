package ru.surf.practice

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity(R.layout.activity_second) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val result = Intent().putExtra(
            "result_key",
            "Hasta la vista, baby",
        )

        setResult(Activity.RESULT_OK, result)
        finish()
    }
}