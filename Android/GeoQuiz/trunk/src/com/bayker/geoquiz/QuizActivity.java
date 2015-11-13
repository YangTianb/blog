package com.bayker.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class QuizActivity extends Activity {

	private Button mTrueButton;
	private Button mFalseButton;
	private Button mNextButton;
	private Button mLastButton;
	private Button mCheatButton;
	private TextView mQuestionTextView;
	
	private static final String TAG = "QuizActivity";
	private static final String KEY_INDEX = "index";
	
	
	private TrueFalse[] mQuestionBank = new TrueFalse[]{
		new TrueFalse(R.string.question_oceans,true),
		new TrueFalse(R.string.question_mideast,false)
	};
	
	private int mCurrentIndex = 0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);        
        //日志记录
        Log.d(TAG, "onCreate(Bundle) called");        
        setContentView(R.layout.activity_quiz);        
        if(savedInstanceState!=null){
        	mCurrentIndex= savedInstanceState.getInt(KEY_INDEX,0);
        }
        
        //从数组中得到一个问题，并显示在界面上。
        mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
        
        
        
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mCurrentIndex = (mCurrentIndex+1)%mQuestionBank.length;
				updateQuestion();			
			}
		});
       
        mTrueButton =(Button)findViewById(R.id.true_button);
        mFalseButton = (Button)findViewById(R.id.false_button);        
        
        //TrueButton按钮事件
        mTrueButton.setOnClickListener(new View.OnClickListener(){
			
			@Override
			public void onClick(View v) {
				//调用Toast 类的makeText方法
				//Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
				checkAnswer(true);
			}
		});
        //FalseButton按钮事件
        mFalseButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
				checkAnswer(false);
			}
		});
        
        //NextButton按钮
        mNextButton = (Button)findViewById(R.id.next_button);
        //NextButton按钮事件
        mNextButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mCurrentIndex = (mCurrentIndex+1)%mQuestionBank.length;
				updateQuestion();
			}
		});
        
        //LastButton按钮
        mLastButton = (Button)findViewById(R.id.last_button);
        //LastButton按钮事件
        mLastButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(mCurrentIndex>0)
				{
					mCurrentIndex = (mCurrentIndex-1)%mQuestionBank.length;
				}
				updateQuestion();				
			}
		});
        updateQuestion();
        
        mCheatButton = (Button)findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(QuizActivity.this,CheatActivity.class);
				boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
				i.putExtra(CheatActivity.EXTRA_ANSWER_IS_TRUE, answerIsTrue);
				startActivity(i);
			}
		});
    }
    @Override
    public void onPause() {
		super.onPause();
		Log.d(TAG, "onPause called");
	}
    
    @Override
    public void onResume(){
    	super.onResume();
    	Log.d(TAG,"onResume called");
    }
    
    @Override
    public void onStop(){
    	super.onStop();
    	Log.d(TAG, "onStop called");
    }
    @Override
    public void onDestroy(){
    	super.onDestroy();
    	Log.d(TAG, "onDestroy");
    }
    private void updateQuestion(){
    	int question = mQuestionBank[mCurrentIndex].getQuestion();
		mQuestionTextView.setText(question);        	
    }
    private void checkAnswer(boolean userPressedTrue){
    	boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
    	int messageResId = 0;
    	if(userPressedTrue==answerIsTrue){
    		messageResId = R.string.correct_toast;    		
    	}else{
    		messageResId = R.string.incorrect_toast;    		
    	}
    	Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
    	super.onSaveInstanceState(savedInstanceState);
    	Log.d(TAG,"onSaveInstanceState");
    	savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }
}
