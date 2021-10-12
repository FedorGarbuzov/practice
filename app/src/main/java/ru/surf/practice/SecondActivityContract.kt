package ru.surf.practice

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class SecondActivityContract : ActivityResultContract<String, String?>() {

    override fun createIntent(context: Context, input: String?): Intent {
        return Intent(context, SecondActivity::class.java)
            .putExtra("input_key", input)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        val message = intent?.getStringExtra("result_key")
        return if (message.isNullOrEmpty()) {
            "No Message Provided"
        } else {
            message
        }
    }
}