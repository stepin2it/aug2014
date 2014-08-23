package com.stepin2it.stepin2it;

import com.stepin2it.stepin2it.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.webkit.WebView;

/**
 * Class to handle all calls from JS & from Java too
 **/
public class JsHandler
{

	Activity activity;
	String TAG = "JsHandler";
	WebView webView;

	public JsHandler(Activity _contxt, WebView _webView)
	{
		activity = _contxt;
		webView = _webView;
	}

	/**
	 * This function handles call from JS
	 */
	public void jsFnCall(String jsString)
	{
		showDialog(jsString);
	}

	/**
	 * This function handles call from Android-Java
	 */
	public void javaFnCall(String jsString)
	{

		final String webUrl = "javascript:diplayJavaMsg('" + jsString + "')";
		// Add this to avoid android.view.windowmanager$badtokenexception unable
		// to add window
		if (!activity.isFinishing())
			// loadurl on UI main thread
			activity.runOnUiThread(new Runnable()
			{

				@Override
				public void run()
				{
					webView.loadUrl(webUrl);
				}
			});
	}

	/**
	 * function shows Android-Native Alert Dialog
	 */
	public void showDialog(String msg)
	{

		AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
		alertDialog.setTitle(activity.getString(R.string.app_dialog_title));
		alertDialog.setMessage(msg);
		alertDialog.setButton(DialogInterface.BUTTON_POSITIVE,
				activity.getString(R.string.label_ok_text),
				new DialogInterface.OnClickListener()
				{
					public void onClick(DialogInterface dialog, int which)
					{
						dialog.dismiss();
					}
				});
		alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE,
				activity.getString(R.string.label_cancel_text),
				new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						dialog.dismiss();
					}
				});
		alertDialog.show();
	}
}
