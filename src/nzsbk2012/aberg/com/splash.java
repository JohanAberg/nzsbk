package nzsbk2012.aberg.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
 
public class splash extends Activity {
    /** Called when the activity is first created. */
	
	final Activity activity = this;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        
        final String appTitle = "New Zealand Superbike Championship 2012";
        activity.setTitle(appTitle);
        
        final Button btnStream = (Button) findViewById(R.id.streamButton);
        final Button btnMylaps = (Button) findViewById(R.id.mylapsButton);
        final Button btnTiming = (Button) findViewById(R.id.timingButton);
        final Button btnSchedule = (Button) findViewById(R.id.scheduleButton);
        

           
        
        //Listening to button event
        btnStream.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), NZSBK2012Activity.class);
                nextScreen.putExtra("name", btnStream.getText().toString());
//                startActivity(nextScreen);
                startActivityForResult(nextScreen, 100);
 
                
                
            }
        });
        
        //Listening to button event
        btnMylaps.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), NZSBK2012Activity.class);
                nextScreen.putExtra("name", btnMylaps.getText().toString());
                startActivityForResult(nextScreen, 100);
 
            }
        });  
        
        //Listening to button event
        btnTiming.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), NZSBK2012Activity.class);
                nextScreen.putExtra("name", btnTiming.getText().toString());
                startActivityForResult(nextScreen, 100);
 
            }
        }); 
        
        //Listening to button event
        btnSchedule.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), NZSBK2012Activity.class);
                nextScreen.putExtra("name", btnSchedule.getText().toString());
                startActivityForResult(nextScreen, 100);
 
            }
        });        
        
    }
    
    @Override
    public void onDestroy() {
    	super.onDestroy();
//    	client.getConnectionManager().shutdown();
    }
    
 // Function to read the result from newly created activity
    @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if(resultCode == 100){
        		finish();	
            }
     
        }
    
}