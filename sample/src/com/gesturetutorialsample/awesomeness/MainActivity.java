package com.gesturetutorialsample.awesomeness;

import com.gesturetutorial.awesomeness.TutorialView;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

public class MainActivity extends Activity implements OnItemSelectedListener {
	Spinner spinAnimation, spinLocation;
	TutorialView tv;
	int location = TutorialView.UpperCenter,
			swipe = TutorialView.DoubleFingerTap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		spinAnimation = (Spinner) findViewById(R.id.spinAnimation);
		spinLocation = (Spinner) findViewById(R.id.spinLocation);

		spinAnimation.setOnItemSelectedListener(this);
		spinLocation.setOnItemSelectedListener(this);
		tv = TutorialView.create(this, TutorialView.DoubleFingerTap, location,
				findViewById(R.id.exampleArea));
		tv.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		if (parent.getId() == spinAnimation.getId()) {
			switch (position) {
			case 0:
				this.swipe = TutorialView.SingleFingerTap;
				break;
			case 1:
				this.swipe = TutorialView.DoubleFingerTap;
				break;
			case 2:
				this.swipe = TutorialView.LeftToRight;
				break;
			case 3:
				this.swipe = TutorialView.RightToLeft;
				break;
			case 4:
				this.swipe = TutorialView.UpToDown;
				break;
			case 5:
				this.swipe = TutorialView.DownToUp;
				break;
			default:
				this.swipe = TutorialView.DoubleFingerTap;
				break;
			}
		} else if (parent.getId() == spinLocation.getId()) {
			switch (position) {
			case 0:
				this.location = TutorialView.UpperLeft;
				break;
			case 1:
				this.location = TutorialView.UpperCenter;
				break;
			case 2:
				this.location = TutorialView.UpperRight;
				break;
			case 3:
				this.location = TutorialView.CenterLeft;
				break;
			case 4:
				this.location = TutorialView.Center;
				break;
			case 5:
				this.location = TutorialView.CenterRight;
				break;
			case 6:
				this.location = TutorialView.LowerLeft;
				break;
			case 7:
				this.location = TutorialView.LowerCenter;
				break;
			case 8:
				this.location = TutorialView.LowerRight;
				break;
			default:
				this.location = TutorialView.UpperCenter;
				break;
			}
		}
		tv = TutorialView.create(this, this.swipe, this.location,
				findViewById(R.id.exampleArea));
		tv.show();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
	}

}
