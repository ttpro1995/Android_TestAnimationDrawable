package meow.thaithien.testanimation;

import android.content.res.AssetManager;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable amin;
    ImageView img;


    AssetManager assetManager;

    ImageView img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animationFromDrawable();
        animationFromAssests1();
        animationFromAssests2();
        animationFromAssests3();


    }

    private void animationFromDrawable(){
        img = (ImageView) findViewById(R.id.imageView);
        img.setBackgroundResource(R.drawable.icon_animation);
        amin= (AnimationDrawable) img.getBackground();
        amin.start();
    }

    private void animationFromAssests1(){
        //from assert
       AnimationDrawable  animationDrawable = new AnimationDrawable();
        // animationDrawable = (AnimationDrawable) getResources().getDrawable(R.drawable.empty_animation);
        assetManager = getAssets();
        try {
            Drawable a = Drawable.createFromStream(assetManager.open("meow1.png"), null);
            animationDrawable.addFrame(a,200);
            Drawable b = Drawable.createFromStream(assetManager.open("meow2.png"), null);
            animationDrawable.addFrame(b,200);
            Drawable c = Drawable.createFromStream(assetManager.open("meow3.png"), null);
            animationDrawable.addFrame(c,200);
            //Drawable d = Drawable.createFromStream(assetManager.open("4.png"), null);
            // animationDrawable.addFrame(d,500);
        }catch (IOException e){e.printStackTrace();}
        img2 = (ImageView) findViewById(R.id.imageView2);
        img2.setBackground(animationDrawable);
        animationDrawable.setOneShot(false);
        animationDrawable.start();
    }

    private void animationFromAssests2(){
        final AnimationDrawable animationDrawable = new AnimationDrawable();
        assetManager = getAssets();
        try {
            Drawable a = Drawable.createFromStream(assetManager.open("drink1.png"), null);
            animationDrawable.addFrame(a,500);
            Drawable b = Drawable.createFromStream(assetManager.open("drink2.png"), null);
            animationDrawable.addFrame(b,500);
            Drawable c = Drawable.createFromStream(assetManager.open("drink3.png"), null);
            animationDrawable.addFrame(c,500);
            Drawable d = Drawable.createFromStream(assetManager.open("drink4.png"), null);
             animationDrawable.addFrame(d,500);
        }catch (IOException e){e.printStackTrace();}
        img2 = (ImageView) findViewById(R.id.big_imageView);
        img2.setBackground(animationDrawable);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (animationDrawable.isRunning())
                animationDrawable.stop();
                else animationDrawable.start();
            }
        });
        animationDrawable.setOneShot(false);
        animationDrawable.start();
    }

    private void animationFromAssests3(){
        final AnimationDrawable  animationDrawable = new AnimationDrawable();
        assetManager = getAssets();
        try {
            Drawable a = Drawable.createFromStream(assetManager.open("drink1.png"), null);
            animationDrawable.addFrame(a,200);
            Drawable b = Drawable.createFromStream(assetManager.open("drink2.png"), null);
            animationDrawable.addFrame(b,200);
            Drawable c = Drawable.createFromStream(assetManager.open("drink3.png"), null);
            animationDrawable.addFrame(c,200);
            Drawable d = Drawable.createFromStream(assetManager.open("drink4.png"), null);
            animationDrawable.addFrame(d,200);
        }catch (IOException e){e.printStackTrace();}
        img2 = (ImageView) findViewById(R.id.big2_imageView);
        img2.setBackground(animationDrawable);
        animationDrawable.setOneShot(false);
        animationDrawable.start();
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (animationDrawable.isRunning())
                    animationDrawable.stop();
                else animationDrawable.start();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
