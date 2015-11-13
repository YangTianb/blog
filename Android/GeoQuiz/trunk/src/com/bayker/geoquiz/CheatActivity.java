package com.bayker.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends Activity {
	public static final String EXTRA_ANSWER_IS_TRUE = "com.bignerdranch.android.geoquiz.answer_is_true";
	
	private boolean mAnswerIsTrue;
	//查看答案按钮
	private Button mShowAnswer;
	//显示答案的文本
	private TextView mAnswerTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cheat);
		//得到传递的值
		mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);
		
		mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
		mAnswerTextView  = (TextView)findViewById(R.id.answerTextView);
		
		//设置查看答案的按钮事件
		mShowAnswer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(mAnswerIsTrue){
					mAnswerTextView.setText(R.string.true_button);
				}else{
					mAnswerTextView.setText(R.string.false_button);
				}
			}
		});
	}
}
