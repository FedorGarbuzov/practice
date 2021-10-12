package ru.surf.practice

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val activityLauncher = registerForActivityResult(SecondActivityContract()) { result ->
        Toast.makeText(this, result.toString(), Toast.LENGTH_LONG).show()
    }

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

        val button: Button = findViewById(R.id.to_act_two_btn)
        val rv: RecyclerView = findViewById(R.id.rv)

        rv.adapter = StringListAdapter(stringList)

        button.setOnClickListener {
            activityLauncher.launch("I’ll be back")
        }
    }
}