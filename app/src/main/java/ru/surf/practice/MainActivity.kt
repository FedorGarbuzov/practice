package ru.surf.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ru.surf.practice.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val stringList = listOf(
            "Come with me if you want to live",
            "Hasta la vista, baby",
            "I’ll be back",
            "I need your clothes, your boots and your motorcycle",
            "I know now why you cry but it’s something I can never do",
        )
        val rv: RecyclerView = findViewById(R.id.rv)

        rv.adapter = StringListAdapter(stringList)
    }
}