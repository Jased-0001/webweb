package xyz.jased.webweb

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class SettingsActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        initialize(savedInstanceState)
        initializeLogic()
    }

    private fun initialize(savedInstanceState: Bundle?) {
        val browseBttn = findViewById<Button>(R.id.browse_bttn)
        val clvpBttn   = findViewById<Button>(R.id.clvp_bttn)

        // Click listener for home button
        browseBttn?.setOnClickListener {
            val intent = Intent(this@SettingsActivity, MainActivity::class.java)

            startActivity(intent)
        }

        clvpBttn?.setOnClickListener {
            if (!FileUtil.deleteFile("lastVisitedPage.ww", applicationContext)) {
                // error!
                Toast.makeText(this@SettingsActivity, "Failed to delete ${applicationContext.filesDir}/lastViewedPage.ww", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initializeLogic() {}
}