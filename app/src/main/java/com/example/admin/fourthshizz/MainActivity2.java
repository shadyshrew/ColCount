 package com.example.admin.fourthshizz;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.lang.reflect.Array;

import java.lang.String;
import java.util.ArrayList;
import java.util.Random;



 public class MainActivity2 extends ActionBarActivity {
     RelativeLayout MyLayout;
     public static int a[] = new int[4];


     ArrayList<String> colorst = new ArrayList();
     Random random = new Random();
     int count = 0;
     //Thread thread;
    String temp;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         for (int i=0; i< 4 ; i++)
         {
             a[i]=0;
         }
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main_activity2);
         colorst.add("#9400d3");
         colorst.add("#ffffff");
         colorst.add("#ff0000");
         colorst.add("#ff281cff");
         colorst.add("#ff4aff13");

         MyLayout = (RelativeLayout)findViewById(R.id.stuff);
         new ChangeBgAsyncTask().execute();

     }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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


     public class ChangeBgAsyncTask extends AsyncTask<Void, Void, Void> {

         @Override
         protected Void doInBackground(Void... voids) {
            /* try {
                 Thread.sleep(3000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }*/
            return null;
         }

         @Override
         protected void onPostExecute(Void aVoid) {
            restart:

             if (count < 10) {
                 final String chosenString = colorst.get(random.nextInt(colorst.size() - 1));
                 //if (temp==chosenString)
                 //{
                    // if (count==10)

                        // {
                        //     Intent intent = new Intent(MainActivity2.this, TheQuestion.class);
                         //    startActivity(intent);
                       ///  }
                   //  else

                   // break restart;
                 //}

                       // else
                // {
                 try {
                     if (count != 0) {
                         temp = chosenString;
                     }
                     Thread.sleep(300);
                     MyLayout.setBackgroundColor(Color.parseColor(chosenString));
                     Log.d("color", chosenString);
                     switch (chosenString) {
                         case "#9400d3":
                             a[0]++;
                             break;
                         case "#ffffff":
                             a[1]++;
                             break;
                         case "#ff0000":
                             a[2]++;
                             break;
                         case "#ff281cff":
                             a[3]++;
                             break;
                         case "#ff4aff13":
                             a[4]++;
                             break;
                         default:
                             break;
                     }
                 } catch (InterruptedException e) {
                     // e.printStackTrace();
                 }
                 count++;
                 if (count == 10) {
                     Intent intent = new Intent(MainActivity2.this, TheQuestion.class);
                     startActivity(intent);
                 }

                 new ChangeBgAsyncTask().execute();
             //}
         }
             super.onPostExecute(aVoid);



         }
     }

}
