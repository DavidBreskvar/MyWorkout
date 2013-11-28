package dbug.myworkout.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends BaseActivity {
	
	Button newWorkout, savedWorkout, celebWorkout;
	Intent activity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		newWorkout = (Button)findViewById(R.id.newWork);
		savedWorkout = (Button)findViewById(R.id.savedWork);
		celebWorkout = (Button)findViewById(R.id.celebWork);
		
		newWorkout.setOnClickListener(onClick);
		savedWorkout.setOnClickListener(onClick);
		celebWorkout.setOnClickListener(onClick);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private OnClickListener onClick = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.newWork:
				activity = new Intent(MainActivity.this, NewWorkout.class);
				startActivity(activity);
				break;
			case R.id.savedWork:
				activity = new Intent(MainActivity.this, SavedWorkout.class);
				startActivity(activity);
				break;
			case R.id.celebWork:
				activity = new Intent(MainActivity.this, CelebrityWorkout.class);
				startActivity(activity);
				break;
			}
			
		}
	};

}
