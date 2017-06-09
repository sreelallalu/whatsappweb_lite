package d1x.webwhatsapp.com.d1_web_res;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.Toast;

import org.xwalk.core.JavascriptInterface;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkResourceClient;
import org.xwalk.core.XWalkView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    public boolean f458m;
    private XWalkView xWalkWebView;
    String f460q = "";
    boolean f461r = false;
    boolean f459p = false;
    private ValueCallback VCallback;
    boolean doubleBackToExitPressedOnce = false;
    public int currentapiVersion = Build.VERSION.SDK_INT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        XWalkPreferences.setValue("animatable-xwalk-view", true);
       // requestWindowFeature(1);
        setContentView(new XWalkView(MainActivity.this));
        setContentView(R.layout.activity_main2);
        toolBarSetUp();
        xWalkWebView=(XWalkView)findViewById(R.id.xwalkWebView89);

        // MainActivity.this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.VCallback = new C02491();
//this.xWalkWebView.setResourceClient(new C09732(this.xWalkWebView, ""));
        this.xWalkWebView.setResourceClient(new C097321(this.xWalkWebView, ""));
       // xWalkWebView.getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0");
        xWalkWebView.getSettings().setUserAgentString(
"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.130 Safari/537.36");

        xWalkWebView.load("http://bit.ly/1yMlbtv", null);
    // this.xWalkWebView.addJavascriptInterface(new ScriptAdd(xWalkWebView,this), "appmini");
    }
    public class WebAppInterface {
        @JavascriptInterface
        public void callFunction(){
            // Do your Android Stuff here
        }
    }
    public void putit()
    {
        try
        {
            InputStream localInputStream = getAssets().open("c.css");
            byte[] arrayOfByte = new byte[localInputStream.available()];
            localInputStream.read(arrayOfByte);
            localInputStream.close();
            this.xWalkWebView.load("javascript:(function() {var parent = document.getElementsByTagName('head').item(0);var style = document.createElement('style');style.type = 'text/css';style.innerHTML = window.atob('" + Base64.encodeToString(arrayOfByte, 2) + "');parent.appendChild(style)})();", null);
            return;
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
    }
    public boolean onCreateOptionsMenu(Menu paramMenu)
    {
        getMenuInflater().inflate(R.menu.onoption, paramMenu);
        return super.onCreateOptionsMenu(paramMenu);
    }
    private void toolBarSetUp() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        assert getSupportActionBar() != null;
     getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.user_ask_attachment:
                CreateFile();
                cafu1234();


                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
    private void CreateFile()
    {
        File localFile = new File(Environment.getExternalStorageDirectory().toString() + "/DCIM/WhatWeb");
        try
        {
            if (!localFile.exists()) {
                localFile.mkdir();
            }
            return;
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
    }
    public void cafu1234()
    {
        Bitmap localBitmap2 = null;
        Object localObject1 = new Date();
        DateFormat.format("yyyy-MM-dd_hh:mm:ss", (Date)localObject1);
        Object localObject2 = Environment.getExternalStorageDirectory().toString() + "/DCIM/WhatWeb/" + localObject1 + ".png";
        Toast.makeText(this, "Screenshot Saved in /DCIM/WhatWeb", Toast.LENGTH_SHORT).show();
        int i = 0;
        if (this.xWalkWebView != null)
        {
            localBitmap2 = null;
            i = 0;
        }
        try
        {
            Class.forName("org.xwalk.core.XWalkView");
            i = 1;

                try
                {
                    Bitmap localBitmap1 = Bitmap.createBitmap(this.xWalkWebView.getWidth(), this.xWalkWebView.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas localCanvas = new Canvas(localBitmap1);
                    this.xWalkWebView.draw(localCanvas);
                    Log.e("jj","suucc_opp");


                    localObject2 = new File((String)localObject2);
                    localObject1 = localBitmap2;
                    localBitmap2 = coo205x(this.xWalkWebView).getBitmap();
                    localObject1 = localBitmap2;
                    Object localObject3 = new FileOutputStream((File)localObject2);
                    localObject1 = localBitmap2;
                    localBitmap2.compress(Bitmap.CompressFormat.PNG, 85, (OutputStream)localObject3);
                    localObject1 = localBitmap2;
                    ((FileOutputStream)localObject3).flush();
                    localObject1 = localBitmap2;
                    ((FileOutputStream)localObject3).close();
                    localObject1 = localBitmap2;
                    localObject2 = ((File)localObject2).toString();
                    localObject1 = localBitmap2;
                    localObject3 = new MediaScannerConnection.OnScanCompletedListener()
                    {
                        public void onScanCompleted(String paramAnonymousString, Uri paramAnonymousUri)
                        {
                            // Log.i("ExternalStorage", "Scanned " + paramAnonymousString + ":");
                            // Log.i("ExternalStorage", "-> uri=" + paramAnonymousUri);
                        }
                    };
                    localObject1 = localBitmap2;
                    Log.e("jj","suucc");

                    MediaScannerConnection.scanFile(this, new String[] {(String) localObject2}, null, (MediaScannerConnection.OnScanCompletedListener)localObject3);
                    //return localBitmap2;
                }
                catch (Exception localException2)
                {
                    localException2.printStackTrace();

                }
                /*localException1 = localException1;
                localException1.printStackTrace();*/

        }
        catch (Exception localException1)
        {
            
        }
        if (i != 0) {
            localObject1 = localBitmap2;
        }








       // return localBitmap1;
    }

    private TextureView coo205x(ViewGroup paramViewGroup)
    {
        int j = paramViewGroup.getChildCount();
        int i = 0;
        while (i < j)
        {
            Object localObject = paramViewGroup.getChildAt(i);
            if ((localObject instanceof TextureView))
            {
                if (((View)localObject).getParent().getClass().toString().contains("XWalk")) {
                    return (TextureView)localObject;
                }
            }
            else if ((localObject instanceof ViewGroup))
            {
                localObject = coo205x((ViewGroup)localObject);
                if (localObject != null) {
                    return (TextureView)localObject;
                }
            }
            i += 1;
        }
        return null;
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
        if (this.xWalkWebView != null) {
            this.xWalkWebView.onActivityResult(paramInt1, paramInt2, paramIntent);
        }
    }


    class C02491
            implements ValueCallback
    {
        @Override
        public void onReceiveValue(Object o) {
            m185a((String)o);

        }

        C02491() {}

        public void m185a(String paramString)
        {
            Log.e("valuecallback",paramString);
            if (paramString.equals("\"is_closed\""))
            {
             //  m486k();

            }
            xWalkWebView.evaluateJavascript("javascript:ccp();", null);

        }


    }

    public class ScriptAdd {
        private Context context;
        private XWalkView xWalkWebView;

        public ScriptAdd(XWalkView xWalkWebView,Context context ) {
            this.context=context;
            this.xWalkWebView=xWalkWebView;

        }

        @JavascriptInterface
        public void p3542(String paramString1, String paramString2)
        {
            Log.e("calling","value");

            if (MainActivity.this.f460q.length() == 0)
            {
                Log.e("calling","value");
                MainActivity.this.f460q = (paramString1 + ": " + paramString2);
                if (MainActivity.this.f461r) {
                  //  MainActivity.this.m484a(MainActivity.this, paramString1, paramString2, 0);
                }
            }
            do
            {

                StringBuilder localStringBuilder = new StringBuilder();
                MainActivity localMainActivity = MainActivity.this;
                localMainActivity.f460q = (localMainActivity.f460q + "\n" + paramString1 + ": " + paramString2);

            } while (!MainActivity.this.f461r);
          //  MainActivity.this.m484a(MainActivity.this, "WhatWeb", MainActivity.this.f460q, 0);
            return;
        }


        }
        @JavascriptInterface
        public void showToast(String toast) {
            Log.d("tag", "showToast(String toast)");
            Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_SHORT).show();
        }




    private class C097321 extends XWalkResourceClient {
        public C097321(XWalkView xWalkWebView, String s) {
            super(xWalkWebView);
        }
        @Override
        public void onLoadStarted(XWalkView view, String url) {
            super.onLoadStarted(view, url);
        }

        @Override
        public void onLoadFinished(XWalkView view, String url) {
            super.onLoadFinished(view, url);

            MainActivity.this.putit();
       view.load("javascript:document.getElementById('pane-side').addEventListener('click',function f(e) {setTimeout(function(){ document.getElementById('main').style.width='100%';document.getElementById('side').style.display='none';}, 1000);})()", null);
        }

    }
    public void onBackPressed()
    {
        xWalkWebView.load("javascript:(function(){document.getElementById('side').style.display='';document.getElementById('main').style.width='0%';})()", null);
        xWalkWebView.load("javascript:document.getElementById('pane-side').addEventListener('click',function f(e) {setTimeout(function(){ document.getElementById('main').style.width='100%';document.getElementById('side').style.display='none'; }, 1000);})()", null);
        if (this.doubleBackToExitPressedOnce)
        {
           /* super.onBackPressed();
            return;*/
        }
        this.doubleBackToExitPressedOnce = true;

        new Handler().postDelayed(new Runnable()
        {
            public void run()
            {
                MainActivity.this.doubleBackToExitPressedOnce = false;
            }
        }, 2000L);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == 0)
        {
            onBackPressed();
        }




        return super.onKeyDown(keyCode, event);




    }





}



