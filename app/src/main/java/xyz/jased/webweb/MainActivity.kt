package xyz.jased.webweb

import android.app.Activity
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        initialize(savedInstanceState);
        initializeLogic();
    }

    private fun initialize(savedInstanceState: Bundle?) {
        val go_bttn = findViewById<Button>(R.id.go_bttn)
        val home_bttn = findViewById<Button>(R.id.home_bttn)

        val webview1 = findViewById<WebView>(R.id.webview1)

        val edittext1 = findViewById<EditText>(R.id.edittext1)

        webview1.webViewClient = object : WebViewClient() {
            override fun onPageStarted(_param1: WebView, _param2: String, _param3: Bitmap?) {
                edittext1.setText(_param2)
                super.onPageStarted(_param1, _param2, _param3)
            }

            override fun onPageFinished(_param1: WebView, _param2: String) {
                val _url = _param2
                super.onPageFinished(_param1, _param2)
            }
        }

        go_bttn?.setOnClickListener() {
            webview1.loadUrl(edittext1.text.toString())
        }

        home_bttn?.setOnClickListener {
            webview1.loadUrl("https://google.com/")
            edittext1.setText("https://google.com/")
        }
    }

    private fun initializeLogic() {}
}