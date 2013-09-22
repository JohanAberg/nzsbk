package nzsbk2012.aberg.com;


import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.Plugin;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class NZSBK2012Activity extends Activity {
    /** Called when the activity is first created. */

	
	WebView mWebView;
	final Activity activity = this;
	
    @Override
    public void onDestroy() {
    	super.onDestroy();
    	mWebView.destroy();
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	((WebView) findViewById(R.id.webview)).saveState(outState);
//    	mWebView.saveState(outState);
     }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//        setContentView(R.layout.splash);
            

        final String appTitle = "New Zealand Superbike Championship 2012";
        activity.setTitle(appTitle);
        
        Intent i = getIntent();
        // Receiving the Data
        String name = i.getStringExtra("name");
        setResult(100,i);
//		Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();
		
		
//        if (savedInstanceState != null){
//        	mWebView = (WebView) findViewById(R.id.webview);
//	        mWebView.getSettings().setJavaScriptEnabled(true);
//	        mWebView.getSettings().setPluginsEnabled(true);
//	        mWebView.getSettings().setBuiltInZoomControls(true);
//	        mWebView.setWebViewClient(new HelloWebViewClient());
//	        
//        	mWebView.restoreState(savedInstanceState);
//        	
//        	Toast.makeText(getApplicationContext(), "saved instance", Toast.LENGTH_LONG).show();
//        }
//        else{
        	
//        	Toast.makeText(getApplicationContext(), "no saved instance", Toast.LENGTH_LONG).show();
	        mWebView = (WebView) findViewById(R.id.webview);
	        
	        mWebView.getSettings().setJavaScriptEnabled(true);
	               
	        
	        if (Build.VERSION.SDK_INT < 8) {
	            mWebView.getSettings().setPluginsEnabled(true);
	        } 
//	            else {
//	            mWebView.getSettings().setPluginState(Plugin.ON);
//	        }
	  	        
	        mWebView.getSettings().setBuiltInZoomControls(true);
	        
//	        mWebView.getSettings().setLoadWithOverviewMode(true);
	        mWebView.getSettings().setUseWideViewPort(true);
	        
	        mWebView.setWebViewClient(new HelloWebViewClient());
	      	        
	        mWebView.setWebChromeClient(new WebChromeClient() {
	            public void onProgressChanged(WebView view, int progress)
	            {
	                activity.setTitle("Loading...");
	                activity.setProgress(progress * 100);
	 
	                if(progress == 100)
	                    activity.setTitle(appTitle);
	            }
	        });        
	        
	//        String url = "http://www.livetiming.co.nz/wsNZSBK.aspx";
	//        mWebView.loadUrl(url);
	        
	        loadPage(name);
//        }

        
    }
    
    
    String emb = "<embed src=\"http://player.viewer.dacast.com/DacastPlayer.swf?c=3695_3982\"type=\"application/x-shockwave-flash\">";

    String f3=" \"http://viewer.dacast.com/b/3695/f/10545\" ";
   	String live=" \"http://viewer.dacast.com/b/3695/c/3982\" ";
   	String triSeries = "";
    
    public void loadStreams(){
	    String html = "<html><body><center><H4><strong>2012<br>New Zealand<BR> Superbike Championship<br></H4></strong>";
//	    html = html + "<P>Audio Stream<br><iframe id=\"dacasturl\" src=\"http://viewer.dacast.com/b/3695/c/4430\" width=\"300\" height=\"175\" frameborder=\"1\" scrolling=\"no\"></iframe> ";
//	    html = html + emb;
	    html = html + "<P>Video Stream<BR>";
	    html = html + "<iframe id=\"dacasturl " + live + "></iframe> ";
//	    html = html + "<iframe id=\"dacasturl " + f3 + " width=\"640\" height=\"360\" frameborder=\"1\" scrolling=\"no\"></iframe> ";
	    html = html + "<p>Streaming data provided by:<br><img border=\"0\" hspace=\"0\" src=\"http://www.ctas.co.nz/images/CtasLogo45.png\"><br> ";
	    html = html + "</body></html>";
	    String mime = "text/html";
	    String encoding = "utf-8";
	    mWebView.loadDataWithBaseURL(null, html, mime, encoding, null);  
    }
    
    
    
    
    public void loadSchedule(){
//    	String url = "http://www.livetiming.co.nz/data/NZSBKSchedule.png";
    	String url = "http://www.livetiming.co.nz/data/VicMCCSchedule.jpg";
        mWebView.loadUrl(url);	
    }
    	
    	
    public void loadTiming(){
//    	String url = "http://www.livetiming.co.nz/wsNZSBK.aspx";
    	String url = "http://livetiming.co.nz/wsTriSeries.aspx";
    	//String url = "http://www.livetiming.co.nz/wsVicMCC.aspx";
        mWebView.loadUrl(url);	
    }
    
    public void loadMylaps(){
//    	String url = "http://www.mylaps.com/championship/index.jsp?id=110173";
    	String url = "http://www.mylaps.com/championship/index.jsp?id=44628";
		mWebView.loadUrl(url);	
    }
    
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.item1:
			//
			loadTiming();			
			return true;
//		case R.id.item2:
//			//url = "http://player.viewer.dacast.com/DacastPlayer.swf?c=3695_4430";
//			//mWebView.loadUrl(url);
//			loadStreams();
//			return true;	
		case R.id.item4:
			loadMylaps();
			//finish();
			return true;	
		case R.id.item5:
//			finish();
			loadSchedule();
			return true;		
		case R.id.item6:
			mWebView.loadUrl( "javascript:window.location.reload( true )" );
			return true;		
		default:
			return super.onOptionsItemSelected(item);
		}
	}
  
  	
   public void loadPage(String page){

    	if (page.equals("Stream") ){
    		loadStreams();
    	}
    	if (page.equals("MyLaps") ){
    		loadMylaps();
    	}
    	if (page.equals("Timing") ){
    		loadTiming();
    	}
    	if (page.equals("Schedule") ){
    		loadSchedule();
    	}    	
    }
	
 
   
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}
    
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    
    
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}