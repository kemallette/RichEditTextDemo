package com.RichEditText.Demo.Activities;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.RichEditText.Demo.R;
import com.RichEditText.Widget.RichEditText;

public class LayoutExampleActivity extends Activity{

	private static final String	EXTRA_LAYOUT_RES	      = "EXTRA_LAYOUT_RES";
	private static final String	EXTRA_LAYOUT_EXPL_STR_RES	=
	                                                          "EXTRA_LAYOUT_EXPL_STR_RES";
	private static final String	EXTRA_TITLE	              = "EXTRA_TITLE";


	private FrameLayout	        flContainer;
	private TextView	        tvExplanation;
	private TextView	        tvTitle;


	@Override
	protected void onCreate(Bundle savedInstanceState){

		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_examplegeneric);

		flContainer = (FrameLayout) findViewById(R.id.fl);
		tvExplanation = (TextView) findViewById(R.id.tv_explanation);
		tvTitle = (TextView) findViewById(R.id.tv_title);

		flContainer.addView(getLayoutInflater().inflate(getIntent().getIntExtra(EXTRA_LAYOUT_RES,
		                                                                        0),
		                                                flContainer,
		                                                false));
		tvExplanation.setText(getIntent().getIntExtra(EXTRA_LAYOUT_EXPL_STR_RES,
		                                              0));
		tvTitle.setText(getIntent().getStringExtra(EXTRA_TITLE));
	}


	public static Intent buildIntent(Context ctx,
	                                 String title,
	                                 int layoutRes,
	                                 int explanationString){

		Intent toRet = new Intent(ctx,
		                          LayoutExampleActivity.class);
		toRet.putExtra(EXTRA_TITLE,
		               title);
		toRet.putExtra(EXTRA_LAYOUT_RES,
		               layoutRes);
		toRet.putExtra(EXTRA_LAYOUT_EXPL_STR_RES,
		               explanationString);
		return toRet;
	}


	public void onClickValidate(View v){

		RichEditText fdt = (RichEditText) findViewById(R.id.et);
		if (fdt.testValidity()){
			Toast.makeText(this,
			               ":)",
			               Toast.LENGTH_LONG)
			     .show();
		}
	}

}
