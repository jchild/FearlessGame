package com.fearless.game.android;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.fearless.game.FearlessGame;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_androidlauncher);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new FearlessGame(), config);
	}

	@Override
	public void onBackPressed(){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle("Exit");
		builder.setMessage("Are you sure you want to exit?");
		builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
		builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});
		AlertDialog dialog = builder.create();

		dialog.show();
	}
}
