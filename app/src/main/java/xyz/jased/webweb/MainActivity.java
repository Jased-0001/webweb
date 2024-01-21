package xyz.jased.webweb;

import android.animation.*;
import android.annotation.SuppressLint;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.*;
import android.widget.Button;
import android.widget.EditText;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends Activity {
	
	private EditText edittext1;
	private Button button;
	private Button button1;
	private WebView webview1;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	@SuppressLint("SetJavaScriptEnabled")
	private void initialize(Bundle _savedInstanceState) {
		edittext1 = findViewById(R.id.edittext1);
		button = findViewById(R.id.button);
		button1 = findViewById(R.id.button1);
		webview1 = findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);

		edittext1.addTextChangedListener(new TextWatcher() { // https://www.geeksforgeeks.org/how-to-set-restriction-for-url-in-android-edittext/
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			// whenever text size changes it will check
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// if text written matches the pattern then
				// it will show a toast of pattern matches
				if (!Patterns.WEB_URL.matcher(edittext1.getText().toString()).matches()) {
					// otherwise show error of invalid url
					edittext1.setError("Invalid URL");
					button.setEnabled(false);
				} else {
					button.setEnabled(true);
				}
			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				webview1.loadUrl(edittext1.getText().toString());
			}
		});

		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				webview1.loadUrl("https://google.com/");
				edittext1.setText("https://google.com/");
			}
		});
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;

				edittext1.setText(_url);
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				
				super.onPageFinished(_param1, _param2);
			}
		});
	}
	
	private void initializeLogic() {
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}
