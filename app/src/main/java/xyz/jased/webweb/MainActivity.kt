package xyz.jased.webweb

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        initialize(savedInstanceState)
        initializeLogic()
    }

    private fun initialize(savedInstanceState: Bundle?) {
        val goBttn = findViewById<Button>(R.id.go_bttn)
        val homeBttn = findViewById<Button>(R.id.home_bttn)
        val webview1 = findViewById<WebView>(R.id.webview1)
        val edittext1 = findViewById<EditText>(R.id.edittext1)

        // Click listener for GO button
        goBttn?.setOnClickListener {
            loadURL(webview1, edittext1, edittext1.text.toString())
        }

        // Click listener for HOME button (go to google)
        // TODO: when settings page made, make this changeable
        homeBttn?.setOnClickListener {
            loadURL(webview1, edittext1, "https://google.com")
        }

        // Load lastVisitedPage.ww
        val urlToLoad = FileUtil.readFile("lastVisitedPage.ww", applicationContext) // TODO: bug: opens chrome
        if (urlToLoad != null) {
            loadURL(webView = webview1, editText = edittext1, url = urlToLoad)
        } else {
            Log.i(null, "INFO: FileUtil.readFile failed, maybe lVP file wasn't found?")
        }
    }

    private fun initializeLogic() {}

    // Other utilities for me
    private fun loadURL(webView: WebView, editText: EditText, url: String) {
        Log.d(null,"DEBUG: loadURL $url")
        editText.setText(url)
        webView.loadUrl(editText.text.toString())

        FileUtil.writeFile("lastVisitedPage.ww", editText.text.toString(), applicationContext)
    }
    private fun error(e: Throwable) {
        // TODO: tell user about errors (custom webpage?)
        println("ERROR: ${e.message}")

        return
    }
}